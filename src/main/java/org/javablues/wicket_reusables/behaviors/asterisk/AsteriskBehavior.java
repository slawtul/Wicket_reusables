package org.javablues.wicket_reusables.behaviors.asterisk;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.FormComponent;

public class AsteriskBehavior extends Behavior {

    @Override
    public void beforeRender(Component component) {
        if (!(component instanceof FormComponent)) {
            return;
        }
        if (!((FormComponent<?>) component).isRequired()) {
            return;
        }
        component.getResponse().write(getAsteriskMarkup());
        super.beforeRender(component);
    }

    protected String getAsteriskMarkup() {
        return "<span class='asterisk-sign'>*</span>";
    }
}
