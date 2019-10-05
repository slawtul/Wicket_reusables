package org.javablues.wicket_reusables;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;

public class WicketBaseTest {

    protected WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester();
    }
}
