package edu.missouri.milesfarmer.factories.standard;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class LegatoMidiEventFactory implements MidiEventFactory {
    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        return null;
    }

    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        return null;
    }
}
