package org.javablues.wicket_reusables.behaviors.fieldrequired;

import static org.junit.Assert.assertEquals;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.javablues.wicket_reusables.WicketBaseTest;
import org.junit.Test;

public class FieldRequiredBehaviorTest extends WicketBaseTest {

  @Test
  public void testIfAsteriskMarkupRenders() {
    Panel panel = createTestPanel(
      "panelWithField",
      "<wicket:panel><input type=\"text\" " +
      "wicket:id=\"field\"/></wicket:panel>"
    );

    TextField<String> textField = new TextField<>("field");
    FieldRequiredBehavior fieldRequired = new FieldRequiredBehavior();
    textField.add(fieldRequired);

    panel.add(textField);
    tester.startComponentInPage(panel);

    String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
    String expectedMarkup = new StringBuilder()
      .append("<span wicket:id=\"panelWithField\">")
      .append("<wicket:panel>")
      .append(
        "<input type=\"text\" wicket:id=\"field\" value=\"\"" +
        " name=\"panelWithField:field\"/>"
      )
      .append(fieldRequired.getMarkup())
      .append("</wicket:panel>")
      .append("</span>")
      .toString();

    assertEquals(
      "Rendered panel markup does not contain required asterisk markup",
      expectedMarkup,
      actualMarkup
    );
  }
}
