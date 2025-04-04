package edu.missouri.milesfarmer.instruments;

import javax.sound.midi.Track;

/**
 * A strategy to change the instrument. To change a channel to a particular instrument, instantiate the strategy that
 * corresponds to that instrument.
 */
public interface InstrumentStrategy {
    /**
     * Apply this strategy's instrument to the given channel on the given track.
     * @param track the track on which to apply the instrument
     * @param channel the channel for which the instrument is changed
     */
    void applyInstrument(Track track, int channel);
}
