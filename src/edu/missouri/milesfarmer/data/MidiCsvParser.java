package edu.missouri.milesfarmer.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidiCsvParser {
    private static String noteOnKey = "Note_on_c";
    private static String noteOffKey = "Note_off_c";

    public static List<MidiEventData> parseCsv(String path) {
        List<MidiEventData> eventDatas = new ArrayList<MidiEventData>();

        File csvFile = new File(path);
        Scanner reader = null;
        try {
            reader = new Scanner(csvFile);
        } catch (FileNotFoundException e) {
            // This is graceful enough for my purposes. If the CSV can't be found, the program cannot run correctly.
            System.err.println("CSV input file not found!");
            throw new RuntimeException(e);
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(",");
            int startEndTick, channel, note, velocity, instrument;
            boolean noteOn;

            try {
                startEndTick = Integer.parseInt(tokens[0]);
                channel = Integer.parseInt(tokens[2]);
                note = Integer.parseInt(tokens[3]);
                velocity = Integer.parseInt(tokens[4]);
                instrument = Integer.parseInt(tokens[5]);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing ints on the following line: " + line);
                throw new RuntimeException(e);
            }

            if (tokens[1].strip().equals(noteOnKey)) {
                noteOn = true;
            } else if (tokens[1].strip().equals(noteOffKey)) {
                noteOn = false;
            } else {
                System.err.println("Error parsing the note on/off type on the following line: " + line);
                throw new RuntimeException();
            }

            eventDatas.add(new MidiEventData(startEndTick, velocity, note, channel, noteOn ? 1 : 0, instrument));
        }

        return eventDatas;
    }
}
