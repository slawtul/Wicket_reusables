package org.javablues.wicket_reusables;

import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;

public class WicketBaseTest {

    protected WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester();
    }

    protected Panel createTestPanel(String id, String associatedMarkup) {
        return new Panel(id) {
            @Override
            public Markup getAssociatedMarkup() {
                return Markup.of(associatedMarkup);
            }
        };
    }
}
