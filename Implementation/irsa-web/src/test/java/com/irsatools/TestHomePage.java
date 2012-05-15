/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 30.04.12
 */
package com.irsatools;

import com.irsatools.web.BasePage;
import com.irsatools.web.WicketApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage {
    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }

    @Test
    @Ignore
    public void homepageRendersSuccessfully() {
        //start and render the test page
        tester.startPage(BasePage.class);

        //assert rendered page class
        tester.assertRenderedPage(BasePage.class);
    }
}
