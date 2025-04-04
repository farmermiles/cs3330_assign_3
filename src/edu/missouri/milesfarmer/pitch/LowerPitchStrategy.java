package edu.missouri.milesfarmer.pitch;

/**
 * A concrete strategy to lower the pitch of the given note. To change the pitch of a note, apply this strategy to the
 * note via the modifyPitch method.
 */
public class LowerPitchStrategy implements PitchStrategy {
    /**
     * Lower the pitch of the given note.
     * @param note the current note
     * @return the pitch-shifted note
     */
    @Override
    public int modifyPitch(int note) {
        return note - 2;
    }
}
