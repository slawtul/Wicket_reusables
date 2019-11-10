package org.javablues.wicket_reusables.behaviors.popover;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

@AllArgsConstructor
@Builder
public class PopoverBehavior extends Behavior {

    private String title;
    private String content;
    private String template;
    private String selector;
    private String container;
    private String boundary;

    private Trigger trigger;
    private Placement placement;

    @Builder.Default
    private boolean animation = true;

    private boolean html = false;

    private int delay;
    private int offset;

    public PopoverBehavior(String title, String content) {
        this.title = title;
        this.content = content;
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

        if (title != null) tag.append("title", title, "");
        if (content != null) tag.append("data-content", content, "");
        if (trigger != null) tag.append("data-trigger", trigger.toString(), "");
        if (placement != null) tag.append("data-placement", placement.toString(), "");
        if (selector != null) tag.append("data-selector", selector, "");
        if (template != null) tag.append("data-template", template, "");
        if (boundary != null) tag.append("data-boundary", boundary, "");
        if (delay != 0) tag.append("data-delay", Integer.toString(delay), "");
        if (offset != 0) tag.append("data-offset", Integer.toString(offset), "");
        if (!animation) tag.append("data-animation", "false", "");
        if (html) tag.append("data-html", "true", "");
    }

    private String enablePopovers() {
        return "$(function () {$('[data-toggle=popover]').popover();})";
    }
}
