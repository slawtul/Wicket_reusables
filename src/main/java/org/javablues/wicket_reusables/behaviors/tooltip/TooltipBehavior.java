package org.javablues.wicket_reusables.behaviors.tooltip;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;

public class TooltipBehavior extends Behavior {

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
    }

    private String enableTooltips() {
        return "$(function () {$('[data-toggle=tooltip]').tooltip();})";
    }
}
