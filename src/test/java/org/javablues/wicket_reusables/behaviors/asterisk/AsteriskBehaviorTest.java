package org.javablues.wicket_reusables.behaviors.asterisk;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.javablues.wicket_reusables.WicketBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AsteriskBehaviorTest extends WicketBaseTest {

    @Test
    public void requiredFieldShouldHasAsteriskSign() {
        TestPanel panel = new TestPanel("testPanel");

        TextField textField = new TextField("field");
        textField.setRequired(true);
        textField.add(new AsteriskBehavior());

        panel.add(textField);
        tester.startComponentInPage(panel);

        String renderedMarkup = ComponentRenderer.renderComponent(panel).toString();
        assertTrue("Wrong rendered markup", renderedMarkup.contains("<span class='asterisk-sign'>*</span>"));
    }

    private static class TestPanel extends Panel {

        TestPanel(String id) {
            super(id);
        }

        @Override
        public Markup getAssociatedMarkup() {
            return Markup.of("<wicket:panel><div><input type='text' wicket:id='field'/></div></wicket:panel>");
        }
    }
}
