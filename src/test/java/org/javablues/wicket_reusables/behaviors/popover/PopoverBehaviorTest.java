package org.javablues.wicket_reusables.behaviors.popover;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.TagTester;
import org.javablues.wicket_reusables.WicketBaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

        List<TagTester> dataToggle = TagTester.createTagsByAttribute(actualMarkup, "data-toggle", "popover", false);
        List<TagTester> title = TagTester.createTagsByAttribute(actualMarkup, "title", "Register user", false);
        List<TagTester> dataContent = TagTester.createTagsByAttribute(actualMarkup, "data-content", "Please click to register user", false);

        Assert.assertEquals(1, dataToggle.size());
        Assert.assertEquals(1, title.size());
        Assert.assertEquals(1, dataContent.size());

        Assert.assertEquals("input", title.get(0).getName());
    }

    @Test
    public void popoverRenderedWithUserSettings() {
        Panel panel = createTestPanel("panelWithButton", "<wicket:panel><input type=\"submit\" wicket:id=\"register\"/></wicket:panel>");
        Button button = new Button("register");
        button.add(PopoverBehavior.builder()
                .title("Register user")
                .content("Please click to register user")
                .trigger(Trigger.CLICK)
                .placement(Placement.BOTTOM).build());

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
        button.add(PopoverBehavior.builder()
                .title("Register user <>")
                .content("Please click to register user <>")
                .build());

        panel.add(button);
        tester.startComponentInPage(panel);

        String actualMarkup = ComponentRenderer.renderComponent(panel).toString();
        String expectedMarkup = new StringBuilder()
                .append("<span wicket:id=\"panelWithButton\">")
                .append("<wicket:panel>")
                .append("<input type=\"submit\" wicket:id=\"register\" name=\"panelWithButton:register\" id=\"register1\" ")
                .append("data-toggle=\"popover\" title=\"Register user &lt;&gt;\" data-content=\"Please click to register user &lt;&gt;\"/>")
                .append("</wicket:panel>")
                .append("</span>")
                .toString();

        assertEquals("Rendered panel markup does not contain correct popover markup", expectedMarkup, actualMarkup);
    }
}
