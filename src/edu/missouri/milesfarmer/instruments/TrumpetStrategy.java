package edu.missouri.milesfarmer.instruments;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class TrumpetStrategy implements InstrumentStrategy {
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
