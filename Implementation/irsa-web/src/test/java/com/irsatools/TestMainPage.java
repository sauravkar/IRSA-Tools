/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 30.04.12
 */
package com.irsatools;

import com.irsatools.web.config.WicketApplication;
import com.irsatools.web.page.MainPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple test using the WicketTester
 */
public class TestMainPage {

    private WicketTester tester;

    @Before
    public void setUp() {
        WicketApplication application = new WicketApplication() {
            @Override
            public void init() {
                ApplicationContext context = new ClassPathXmlApplicationContext("classpath:provider-context.xml");
                getComponentInstantiationListeners().add(new SpringComponentInjector(this, context, true));
            }
        };
        tester = new WicketTester(application);
    }

    @Test
    public void mainPageRendersSuccessfully() {
        //start and render the test page
        tester.startPage(MainPage.class);

        //assert rendered page class
        tester.assertRenderedPage(MainPage.class);
    }
}
