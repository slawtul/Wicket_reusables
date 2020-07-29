package org.javablues.wicket_reusables.behaviors.shared;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JSEventsTest {

  @Test
  public void eventNameToLowercase() {
    assertEquals(
      "Javascript event name is not lowercase",
      "change",
      JSEvents.CHANGE.toString()
    );
  }
}
