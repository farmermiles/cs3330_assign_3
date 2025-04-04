package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;
import edu.missouri.milesfarmer.factories.standard.StandardMidiEventFactory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}
