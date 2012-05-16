/**
 *  File: WicketApplication
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 30.04.12
 */
package com.irsatools.web.config;

import com.irsatools.web.page.Main;
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
        return Main.class;
    }

    @Override
    public void init() {
        // Global configuration
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        // Pages and resources
//        mountPackage("/", Main.class);
    }
}
