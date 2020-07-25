package org.javablues.wicket_reusables.behaviors.shared;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSEventsTest {
    @Test
    public void eventNameToLowercase() {
        assertEquals("Javascript event name is not lowercase", "change",
            JSEvents.CHANGE.toString());
    }
}
