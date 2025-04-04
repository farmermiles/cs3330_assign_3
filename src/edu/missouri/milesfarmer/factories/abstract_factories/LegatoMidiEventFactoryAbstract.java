package edu.missouri.milesfarmer.factories.abstract_factories;

import edu.missouri.milesfarmer.factories.standard.LegatoMidiEventFactory;
import edu.missouri.milesfarmer.factories.standard.MidiEventFactory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}
