package org.javablues.wicket_reusables.behaviors.select2;

import java.io.Serializable;

public class Select2OnEvent implements Serializable {

    final private StringBuilder events = new StringBuilder();

    public Select2OnEvent() {
    }

    String getEvents() {
        return events.toString();
    }

    public Select2OnEvent onEvent(String event, String function) {
        events.append(".on('").append(event).append("', ")
                .append(function).append(")");
        return this;
    }

    public Select2OnEvent onEvent(Select2Events event, String function) {
        events.append(".on('").append(event).append("', ")
                .append(function).append(")");
        return this;
    }
}
