/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 30.04.12
 */
package com.irsatools;

import com.irsatools.web.config.WicketApplication;
import com.irsatools.web.pages.Main;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestMainPage {
    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }

    @Test
    @Ignore
    public void mainPageRendersSuccessfully() {
        //start and render the test page
        tester.startPage(Main.class);

        //assert rendered page class
        tester.assertRenderedPage(Main.class);
    }
}
