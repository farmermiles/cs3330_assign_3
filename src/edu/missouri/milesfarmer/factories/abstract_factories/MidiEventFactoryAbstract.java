package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;

/**
 * An abstract factory for MIDI events. Allows different factories to be chosen based on the desired MIDI note behavior.
 */
public interface MidiEventFactoryAbstract {
    /**
     * Create the factory itself.
     * @return the MIDI event factory itself.
     */
    MidiEventFactory createFactory();
}
