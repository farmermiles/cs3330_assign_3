package edu.missouri.milesfarmer.factories.standard;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

/**
 * A factory that produces notes in a desired style. The exact behavior of this factory is determined by the particular
 * subclass that is instantiated.
 *
 * It is NOT intended that these subclasses be instantiated directly. Rather, you should use the abstract factory to
 * attain your desired factory.
 */
public interface MidiEventFactory {
    /**
     * Create a note on event.
     * @param tick the tick for the note to start on
     * @param note the desired note
     * @param velocity the note's velocity
     * @param channel the channel on which the note plays
     * @return A MidiEvent object that is ready for use in Java's MIDI library.
     * @throws InvalidMidiDataException thrown if there is an error in creating the MIDI event objects
     */
    MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;

    /**
     * Create a note off event.
     * @param tick the tick for the note to end on
     * @param note the desired note
     * @param channel the channel on which the note plays
     * @return A MidiEvent object that is ready for use in Java's MIDI library.
     * @throws InvalidMidiDataException thrown if there is an error in creating the MIDI event objects
     */
    MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}