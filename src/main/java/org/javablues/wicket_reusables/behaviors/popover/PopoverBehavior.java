package org.javablues.wicket_reusables.behaviors.popover;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

public class PopoverBehavior extends Behavior {

    private String title;
    private String content;
    private String template;
    private String selector;
    private String container;
    private String boundary;

    private Trigger trigger;
    private Placement placement;

    private boolean animation = true;
    private boolean html;

    private int delay;
    private int offset;

    public PopoverBehavior() {
    }

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
        if (container != null) tag.append("data-container", container, "");
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

    public PopoverBehavior withTitle(String title) {
        this.title = title;
        return this;
    }

    public PopoverBehavior withContent(String content) {
        this.content = content;
        return this;
    }

    public PopoverBehavior withTemplate(String template) {
        this.template = template;
        return this;
    }

    public PopoverBehavior withSelector(String selector) {
        this.selector = selector;
        return this;
    }

    public PopoverBehavior withContainer(String container) {
        this.container = container;
        return this;
    }

    public PopoverBehavior withBoundary(String boundary) {
        this.boundary = boundary;
        return this;
    }

    public PopoverBehavior withPlacement(Placement placement) {
        this.placement = placement;
        return this;
    }

    public PopoverBehavior withTrigger(Trigger trigger) {
        this.trigger = trigger;
        return this;
    }

    public PopoverBehavior withAnimation(boolean animation) {
        this.animation = animation;
        return this;
    }

    public PopoverBehavior withHtml(boolean html) {
        this.html = html;
        return this;
    }

    public PopoverBehavior withDelay(int delay) {
        this.delay = delay;
        return this;
    }

    public PopoverBehavior withOffset(int offset) {
        this.offset = offset;
        return this;
    }
}
