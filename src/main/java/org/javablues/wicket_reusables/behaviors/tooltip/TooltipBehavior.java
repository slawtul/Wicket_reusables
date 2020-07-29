package org.javablues.wicket_reusables.behaviors.tooltip;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.javablues.wicket_reusables.behaviors.shared.Placement;

public class TooltipBehavior extends Behavior {
  private String title;
  private Placement placement;

  public TooltipBehavior() {}

  public TooltipBehavior(String title) {
    this.title = title;
  }

  public TooltipBehavior(String title, Placement placement) {
    this.title = title;
    this.placement = placement;
  }

  @Override
  public void renderHead(Component component, IHeaderResponse response) {
    super.renderHead(component, response);
    response.render(OnDomReadyHeaderItem.forScript(enableTooltips()));
  }

  @Override
  public void onComponentTag(Component component, ComponentTag tag) {
    super.onComponentTag(component, tag);
    tag.append("data-toggle", "tooltip", "");

    if (title != null) {
      tag.append("title", title, "");
    }
    if (placement != null) {
      tag.append("data-placement", placement.toString(), "");
    }
  }

  protected String enableTooltips() {
    return "$(function () {$('[data-toggle=tooltip]').tooltip();})";
  }

  public TooltipBehavior withTitle(String title) {
    this.title = title;
    return this;
  }

  public TooltipBehavior withPlacement(Placement placement) {
    this.placement = placement;
    return this;
  }
}
