package edu.missouri.milesfarmer.pitch;

/**
 * A strategy to change the pitch of the given note. To change the pitch of a note, instantiate the strategy that
 * corresponds to the pitch change you desire and apply the strategy to the note.
 */
public interface PitchStrategy {
    /**
     * Apply the current strategy to change the pitch of the given note.
     * @param note the current note
     * @return the pitch-shifted note
     */
    int modifyPitch(int note);
}
