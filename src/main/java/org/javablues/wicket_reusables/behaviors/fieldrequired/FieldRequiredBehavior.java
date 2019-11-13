package org.javablues.wicket_reusables.behaviors.fieldrequired;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.FormComponent;

public class FieldRequiredBehavior extends Behavior {

    @Override
    public void afterRender(Component component) {
        if (!(component instanceof FormComponent)) {
            return;
        }
        if (!((FormComponent<?>) component).isRequired()) {
            return;
        }
        component.getResponse().write(getMarkup());
        super.beforeRender(component);
    }

    protected String getMarkup() {
        return "<span class='field-required'>*</span>";
    }
}
