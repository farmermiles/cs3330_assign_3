package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;
import edu.missouri.milesfarmer.factories.standard.StaccatoMidiEventFactory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    @Override
    public MidiEventFactory createFactory() {
        return new StaccatoMidiEventFactory();
    }
}
