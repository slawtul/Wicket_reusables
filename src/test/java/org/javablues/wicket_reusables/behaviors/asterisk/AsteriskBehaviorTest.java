package org.javablues.wicket_reusables.behaviors.asterisk;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.javablues.wicket_reusables.WicketBaseTest;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AsteriskBehaviorTest extends WicketBaseTest {

    @Test
    public void asteriskSignRenderedForRequiredField() {
        TestPanel panel = new TestPanel("panel");

        TextField textField = new TextField("field");
        textField.setRequired(true);
        textField.add(new AsteriskBehavior());

        panel.add(textField);
        tester.startComponentInPage(panel);

        String renderedMarkup = ComponentRenderer.renderComponent(panel).toString();
        assertTrue("Rendered markup does not contain asterisk sign", renderedMarkup.contains("<span class='asterisk-sign'>*</span>"));
    }

    @Test
    public void asteriskSignNotRenderedForRegularField() {
        TestPanel panel = new TestPanel("panel");

        TextField textField = new TextField("field");
        textField.setRequired(false);
        textField.add(new AsteriskBehavior());

        panel.add(textField);
        tester.startComponentInPage(panel);

        String renderedMarkup = ComponentRenderer.renderComponent(panel).toString();
        assertFalse("Rendered markup contains asterisk sign", renderedMarkup.contains("<span class='asterisk-sign'>*</span>"));
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
