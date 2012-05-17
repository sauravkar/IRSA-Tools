/**
 *  File: LayoutJavascriptResourceReference
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.component.layout;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @author N.Semenov
 */
public class LayoutJavascriptResourceReference extends JavaScriptResourceReference {

    /**
     * Singleton instance
     */
    private static LayoutJavascriptResourceReference instance;

    /**
     * Builds a new instance of {@link LayoutJavascriptResourceReference}.
     */
    private LayoutJavascriptResourceReference() {
        super(LayoutJavascriptResourceReference.class, "jquery.layout.min.js");
    }

    /**
     * @return the instance
     */
    public static LayoutJavascriptResourceReference get() {
        if (instance == null) {
            instance = new LayoutJavascriptResourceReference();
        }
        return instance;
    }
}
