package org.javablues.wicket_reusables.behaviors.select2;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.request.resource.ContextRelativeResourceReference;

public class Select2Behavior extends Behavior {
    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        if (component.getMarkupId() == null) {
            throw new RuntimeException("Select2Behavior cannot be attached. " +
                "Component does not have a markup id: " + component);
        }
        response.render(
            OnDomReadyHeaderItem.forScript(appendScript(component)));
        response.render(CssHeaderItem.forReference(
            new ContextRelativeResourceReference(
                "webjars/select2/4.0.13/css/select2.css")));
        response.render(JavaScriptHeaderItem.forReference(
            new ContextRelativeResourceReference(
                "webjars/select2/4.0.13/js/select2.full.min.js")));
    }

    protected Select2Options createSelect2Options(Component component) {
        return new Select2Options();
    }

    protected Select2OnEvent createSelect2OnEvent(Component component) {
        return new Select2OnEvent();
    }

    protected String appendScript(Component component) {
        return String.format("$('select#%s').select2(%s)%s",
            component.getMarkupId(),
            createSelect2Options(component).getOptions(),
            createSelect2OnEvent(component).getEvents()
        );
    }
}
