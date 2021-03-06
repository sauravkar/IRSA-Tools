/**
 *  File: WiQueryInitializer
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 15.05.12
 */
package com.irsatools.web.config;

import org.apache.wicket.Application;
import org.odlabs.wiquery.core.IWiQueryInitializer;
import org.odlabs.wiquery.core.WiQuerySettings;

/**
 * Config class for WiQuery settings and behavior
 *
 * @author N.Semenov
 */
public class WiQueryInitializer implements IWiQueryInitializer {
    private static final long serialVersionUID = 1L;

    public void init(Application application, WiQuerySettings wiQuerySettings) {
        wiQuerySettings.setAutoImportJQueryResource(false);
        wiQuerySettings.setAutoImportJQueryUIJavaScriptResource(false);
        wiQuerySettings.setAutoImportJQueryUIStyleSheetResource(false);
    }
}