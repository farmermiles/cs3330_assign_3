package edu.missouri.milesfarmer.instruments;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * A concrete strategy to change the instrument to trumpet.
 */
public class TrumpetStrategy implements InstrumentStrategy {
    /**
     * Apply this the trumpet instrument to the given channel on the given track.
     * @param track the track on which to apply the instrument
     * @param channel the channel for which the instrument is changed
     */
    @Override
    public void applyInstrument(Track track, int channel) {
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
            track.add(new MidiEvent(msg, 0));
        } catch (InvalidMidiDataException e) {
            System.err.println("Unable to set the instrument.");
            throw new RuntimeException(e);
        }
    }
}
