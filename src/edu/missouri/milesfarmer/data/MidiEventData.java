package edu.missouri.milesfarmer.data;

/**
 * Represents a MIDI Event data point. Acts as an intermediate within the program before the event makes it into the
 * Java MIDI library.
 */
public class MidiEventData {
    private int startEndTick, velocity, note, channel, noteOnOff;
    private int instrument;

    /**
     * Default constructor.
     * @param startEndTick the start or end tick of the event
     * @param velocity the velocity
     * @param note the desired note to start/stop
     * @param channel the channel on which the note should be played
     * @param noteOnOff the event (if the note should become on or off)
     * @param instrument the instrument desired for the note
     */
    public MidiEventData(int startEndTick, int velocity, int note, int channel, int noteOnOff, int instrument) {
        this.startEndTick = startEndTick;
        this.velocity = velocity;
        this.note = note;
        this.channel = channel;
        this.noteOnOff = noteOnOff;
        this.instrument = instrument;
    }

    /**
     * Get the start/end tick of the note
     * @return the tick
     */
    public int getStartEndTick() {
        return startEndTick;
    }

    /**
     * Set the start/end tick of the note (whether it is a start or end is determined by the noteOnOff attribute)
     * @param startEndTick the tick on which the note should start/end
     */
    public void setStartEndTick(int startEndTick) {
        this.startEndTick = startEndTick;
    }

    /**
     * Get the velocity
     * @return the velocity
     */
    public int getVelocity() {
        return velocity;
    }

    /**
     * Set the velocity
     * @param velocity the velocity
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    /**
     * Get the note
     * @return the note
     */
    public int getNote() {
        return note;
    }

    /**
     * Set the note
     * @param note the note
     */
    public void setNote(int note) {
        this.note = note;
    }

    /**
     * Get the channel
     * @return the channel
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Set the channel
     * @param channel the channel
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * Get the event
     * @return the event (whether the note should be on or off)
     */
    public int getNoteOnOff() {
        return noteOnOff;
    }

    /**
     * Set the note to be on or off
     * @param noteOnOff the desired event
     */
    public void setNoteOnOff(int noteOnOff) {
        this.noteOnOff = noteOnOff;
    }

    /**
     * Get the instrument
     * @return the instrument ID
     */
    public int getInstrument() {
        return instrument;
    }

    /**
     * Set the instrument
     * @param instrument the instrument ID
     */
    public void setInstrument(int instrument) {
        this.instrument = instrument;
    }
}
