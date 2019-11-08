package org.javablues.wicket_reusables.behaviors.popover;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

public class PopoverBehavior extends Behavior {

    private String title;
    private String dataContent;
    private DataTrigger dataTrigger = DataTrigger.HOVER;
    private DataPlacement dataPlacement = DataPlacement.RIGHT;

    public PopoverBehavior(String title, String dataContent) {
        this.title = title;
        this.dataContent = dataContent;
    }

    public PopoverBehavior(String title, String dataContent, DataTrigger dataTrigger) {
        this(title, dataContent);
        this.dataTrigger = dataTrigger;
    }

    public PopoverBehavior(String title, String dataContent, DataTrigger dataTrigger, DataPlacement dataPlacement) {
        this(title, dataContent, dataTrigger);
        this.dataPlacement = dataPlacement;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(OnDomReadyHeaderItem.forScript(enablePopovers()));
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);
        tag.append("data-toggle", "popover", "");
        tag.append("title", title, "");
        tag.append("data-content", dataContent, "");
        tag.append("data-trigger", dataTrigger.toString(), "");
        tag.append("data-placement", dataPlacement.toString(), "");
    }

    private String enablePopovers() {
        return "$(function () {$('[data-toggle=popover]').popover();})";
    }
}
