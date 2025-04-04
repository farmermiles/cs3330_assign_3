package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;
import edu.missouri.milesfarmer.factories.standard.StaccatoMidiEventFactory;

/**
 * The staccato abstract factory. Produces a factory where notes are modified to be staccato.
 */
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    /**
     * Create the staccato abstract factory.
     * @return the staccato abstract factory
     */
    @Override
    public MidiEventFactory createFactory() {
        return new StaccatoMidiEventFactory();
    }
}
