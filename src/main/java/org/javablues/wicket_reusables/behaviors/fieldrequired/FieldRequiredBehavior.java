package org.javablues.wicket_reusables.behaviors.fieldrequired;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

public class FieldRequiredBehavior extends Behavior {

  @Override
  public void afterRender(Component component) {
    component.getResponse().write(getMarkup());
    super.beforeRender(component);
  }

  protected String getMarkup() {
    return "<span class='field-required'>*</span>";
  }
}
