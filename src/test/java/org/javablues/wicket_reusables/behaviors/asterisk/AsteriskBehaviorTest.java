package org.javablues.wicket_reusables.behaviors.asterisk;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.javablues.wicket_reusables.WicketBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsteriskBehaviorTest extends WicketBaseTest {

    @Test
    public void asteriskMarkupRenderedForRequiredField() {
        Panel panel = createTestPanel("panelWithField", "<wicket:panel><input type=\"text\" wicket:id=\"field\"/></wicket:panel>");

        TextField textField = new TextField("field");
        textField.setRequired(true);
        AsteriskBehavior asteriskBehavior = new AsteriskBehavior();
        textField.add(asteriskBehavior);

        panel.add(textField);
        tester.startComponentInPage(panel);

        String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
        String expectedMarkup = new StringBuilder()
                .append("<span wicket:id=\"panelWithField\">")
                .append("<wicket:panel>")
                .append(asteriskBehavior.getAsteriskMarkup())
                .append("<input type=\"text\" wicket:id=\"field\" value=\"\" name=\"panelWithField:field\"/>")
                .append("</wicket:panel>")
                .append("</span>")
                .toString();
        assertEquals("Rendered panel markup does not contain correct asterisk markup", expectedMarkup, actualMarkup);
    }

    @Test
    public void asteriskMarkupNotRenderedForRegularField() {
        Panel panel = createTestPanel("panelWithField", "<wicket:panel><input type=\"text\" wicket:id=\"field\"/></wicket:panel>");

        TextField textField = new TextField("field");
        textField.setRequired(false);
        textField.add(new AsteriskBehavior());

        panel.add(textField);
        tester.startComponentInPage(panel);

        String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
        String expectedMarkup = new StringBuilder()
                .append("<span wicket:id=\"panelWithField\">")
                .append("<wicket:panel>")
                .append("<input type=\"text\" wicket:id=\"field\" value=\"\" name=\"panelWithField:field\"/>")
                .append("</wicket:panel>")
                .append("</span>")
                .toString();
        assertEquals("Rendered panel contains asterisk markup", expectedMarkup, actualMarkup);
    }

}
