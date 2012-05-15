/**
 *  File: Dictionary
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 30.04.12
 */
package com.irsatools.web;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

/**
 * Config class for Wicket web application
 *
 * @author N.Semenov
 */
public class WicketApplication extends WebApplication {

    @Override
    public Class getHomePage() {
        return BasePage.class;
    }

    @Override
    public void init() {
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        // additional configuration
    }
}
