package edu.missouri.milesfarmer;

import edu.missouri.milesfarmer.data.MidiCsvParser;
import edu.missouri.milesfarmer.data.MidiEventData;
import edu.missouri.milesfarmer.factories.abstract_factories.LegatoMidiEventFactoryAbstract;
import edu.missouri.milesfarmer.factories.abstract_factories.MidiEventFactoryAbstract;
import edu.missouri.milesfarmer.factories.abstract_factories.StaccatoMidiEventFactoryAbstract;
import edu.missouri.milesfarmer.factories.abstract_factories.StandardMidiEventFactoryAbstract;
import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;
import edu.missouri.milesfarmer.instruments.ElectricBassGuitarStrategy;
import edu.missouri.milesfarmer.instruments.InstrumentStrategy;
import edu.missouri.milesfarmer.instruments.TrumpetStrategy;
import edu.missouri.milesfarmer.pitch.HigherPitchStrategy;
import edu.missouri.milesfarmer.pitch.PitchStrategy;

import javax.sound.midi.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./mystery_song.csv");
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();

            MidiEventFactory factory = factoryAbstract.createFactory();

            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);

            PitchStrategy pitchStrategy = new HigherPitchStrategy();

            for (MidiEventData event : midiEvents) {
                int modifiedNote = event.getNote();
                // int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                // modifiedNote = pitchStrategy.modifyPitch(modifiedNote);

                if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
                    track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
                } else {
                    track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
                }
            }

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRecording() || sequencer.isOpen()) {
                Thread.sleep(100);
            }
            Thread.sleep(500);
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}