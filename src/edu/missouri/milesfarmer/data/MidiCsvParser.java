package edu.missouri.milesfarmer.data;

import javax.sound.midi.ShortMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Parser for MIDI files.
 */
public class MidiCsvParser {
    private static String noteOnKey = "Note_on_c";
    private static String noteOffKey = "Note_off_c";

    /**
     * Parse the given CSV file into intermediate MIDI Event Data objects. Must be of the column format:
     *      startEndTick, Note on/off, channel, note, velocity , instrument
     *
     * This method does not throw any errors, but will return null if any are encountered.
     *
     * @param path the string path to the file (accepts relative paths).
     * @return the list of MIDI Event Data points. Null if there was a parsing error.
     */
    public static List<MidiEventData> parseCsv(String path) {
        List<MidiEventData> eventDatas = new ArrayList<MidiEventData>();

        File csvFile = new File(path);
        Scanner reader = null;
        try {
            reader = new Scanner(csvFile);
        } catch (FileNotFoundException e) {
            System.err.println("CSV input file not found!");
            return null;
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] tokens = line.split(",");

            if (tokens.length < 6) {
                continue;
            }

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
                return null;
            }

            if (tokens[1].strip().equals(noteOnKey)) {
                noteOn = true;
            } else if (tokens[1].strip().equals(noteOffKey)) {
                noteOn = false;
            } else {
                System.err.println("Error parsing the note on/off type on the following line: " + line);
                return null;
            }

            eventDatas.add(new MidiEventData(
                    startEndTick, velocity, note, channel,
                    noteOn ? ShortMessage.NOTE_ON : ShortMessage.NOTE_OFF,
                    instrument));
        }

        return eventDatas;
    }
}
