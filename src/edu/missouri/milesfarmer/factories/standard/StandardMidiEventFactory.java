package edu.missouri.milesfarmer.factories.standard;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

/**
 * A factory that produces notes in a standard style. No modifications are made to the notes.
 *
 * It is NOT intended that this class be instantiated directly. Rather, you should attain it via the abstract factory.
 */
public class StandardMidiEventFactory implements MidiEventFactory {
    /**
     * Create a note on event.
     * @param tick the tick for the note to start on
     * @param note the desired note
     * @param velocity the note's velocity
     * @param channel the channel on which the note plays
     * @return A MidiEvent object that is ready for use in Java's MIDI library.
     * @throws InvalidMidiDataException thrown if there is an error in creating the MIDI event objects
     */
    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        ShortMessage msg = new ShortMessage();
        msg.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(msg, tick);
    }

    /**
     * Create a note off event. No modifications are made to the tick.
     * @param tick the tick for the note to end on
     * @param note the desired note
     * @param channel the channel on which the note plays
     * @return A MidiEvent object that is ready for use in Java's MIDI library.
     * @throws InvalidMidiDataException thrown if there is an error in creating the MIDI event objects
     */
    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        ShortMessage msg = new ShortMessage();
        msg.setMessage(ShortMessage.NOTE_OFF, channel, note);
        return new MidiEvent(msg, tick);
    }
}
