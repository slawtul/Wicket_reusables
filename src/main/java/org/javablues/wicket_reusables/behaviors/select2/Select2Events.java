package org.javablues.wicket_reusables.behaviors.select2;

public enum Select2Events {
  CHANGE("change"),
  CHANGE_SELECT2("change.select2"),
  SELECT2_CLOSING("select2:closing"),
  SELECT2_CLOSE("select2:close"),
  SELECT2_OPENING("select2:opening"),
  SELECT2_OPEN("select2:open"),
  SELECT2_SELECTING("select2:selecting"),
  SELECT2_SELECT("select2:select"),
  SELECT2_UNSELECTING("select2:unselecting"),
  SELECT2_UNSELECT("select2:unselect"),
  SELECT2_CLEARING("select2:clearing"),
  SELECT2_CLEAR("select2:clear");

  private final String eventName;

  Select2Events(String eventName) {
    this.eventName = eventName;
  }

  @Override
  public String toString() {
    return eventName;
  }
}
