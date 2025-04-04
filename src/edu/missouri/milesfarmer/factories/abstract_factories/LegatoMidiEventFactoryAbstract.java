package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.LegatoMidiEventFactory;
import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;

/**
 * The legato abstract factory. Produces a factory where notes are modified to be legato.
 */
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    /**
     * Create the legato abstract factory.
     * @return the legato abstract factory
     */
    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}
