package org.javablues.wicket_reusables.behaviors.popover;

public enum Trigger {

    CLICK, HOVER, FOCUS, MANUAL;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
