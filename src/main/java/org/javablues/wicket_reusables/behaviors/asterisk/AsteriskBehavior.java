package org.javablues.wicket_reusables.behaviors.asterisk;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.FormComponent;

public class AsteriskBehavior extends Behavior {

    private static final String ASTERISK_SIGN = "<span class='asterisk-sign'>*</span>";

    @Override
    public void beforeRender(Component component) {
        if (!(component instanceof FormComponent)) {
            return;
        }
        if (!((FormComponent<?>) component).isRequired()) {
            return;
        }
        component.getResponse().write(ASTERISK_SIGN);
        super.beforeRender(component);
    }
}
