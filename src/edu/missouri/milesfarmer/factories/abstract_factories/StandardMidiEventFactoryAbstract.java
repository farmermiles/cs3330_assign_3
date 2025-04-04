package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;
import edu.missouri.milesfarmer.factories.standard.StandardMidiEventFactory;

/**
 * The standard abstract factory. Produces a factory with normal behavior.
 */
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    /**
     * Create the standard abstract factory.
     * @return the standard abstract factory
     */
    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}
