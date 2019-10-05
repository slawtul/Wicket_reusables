package org.javablues.wicket_reusables.behaviors.popover;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.javablues.wicket_reusables.WicketBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PopoverBehaviorTest extends WicketBaseTest {

    @Test
    public void popoverRenderedWithDefaultValues() {
        Panel panel = createTestPanel("panelWithButton", "<wicket:panel><input type=\"submit\" wicket:id=\"register\"/></wicket:panel>");
        Button button = new Button("register");
        button.add(new PopoverBehavior("Register user", "Please click to register user"));

        panel.add(button);
        tester.startComponentInPage(panel);

        String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
        String expectedMarkup = new StringBuilder()
                .append("<span wicket:id=\"panelWithButton\">")
                .append("<wicket:panel>")
                .append("<input type=\"submit\" wicket:id=\"register\" name=\"panelWithButton:register\" id=\"register1\" ")
                .append("data-toggle=\"popover\" title=\"Register user\" data-content=\"Please click to register user\" ")
                .append("data-trigger=\"hover\" data-placement=\"right\"/>")
                .append("</wicket:panel>")
                .append("</span>")
                .toString();

        assertEquals("Rendered panel markup does not contain correct popover markup", expectedMarkup, actualMarkup);
    }

    @Test
    public void popoverRenderedWithUserSettings() {
        Panel panel = createTestPanel("panelWithButton", "<wicket:panel><input type=\"submit\" wicket:id=\"register\"/></wicket:panel>");
        Button button = new Button("register");
        button.add(new PopoverBehavior("Register user", "Please click to register user", DataTrigger.CLICK, DataPlacement.BOTTOM));

        panel.add(button);
        tester.startComponentInPage(panel);

        String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
        String expectedMarkup = new StringBuilder()
                .append("<span wicket:id=\"panelWithButton\">")
                .append("<wicket:panel>")
                .append("<input type=\"submit\" wicket:id=\"register\" name=\"panelWithButton:register\" id=\"register1\" ")
                .append("data-toggle=\"popover\" title=\"Register user\" data-content=\"Please click to register user\" ")
                .append("data-trigger=\"click\" data-placement=\"bottom\"/>")
                .append("</wicket:panel>")
                .append("</span>")
                .toString();

        assertEquals("Rendered panel markup does not contain correct popover markup", expectedMarkup, actualMarkup);
    }

    @Test
    public void popoverRenderedWithEscapedText() {
        Panel panel = createTestPanel("panelWithButton", "<wicket:panel><input type=\"submit\" wicket:id=\"register\"/></wicket:panel>");
        Button button = new Button("register");
        button.add(new PopoverBehavior("Register user <>", "Please click to register user <>"));

        panel.add(button);
        tester.startComponentInPage(panel);

        String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
        String expectedMarkup = new StringBuilder()
                .append("<span wicket:id=\"panelWithButton\">")
                .append("<wicket:panel>")
                .append("<input type=\"submit\" wicket:id=\"register\" name=\"panelWithButton:register\" id=\"register1\" ")
                .append("data-toggle=\"popover\" title=\"Register user &lt;&gt;\" data-content=\"Please click to register user &lt;&gt;\" ")
                .append("data-trigger=\"hover\" data-placement=\"right\"/>")
                .append("</wicket:panel>")
                .append("</span>")
                .toString();

        assertEquals("Rendered panel markup does not contain correct popover markup", expectedMarkup, actualMarkup);
    }
}
