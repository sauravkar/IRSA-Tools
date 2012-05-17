/**
 *  File: LayoutStyleSheetResourceReference
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.component.layout;

import org.apache.wicket.request.resource.CssResourceReference;

/**
 * @author N.Semenov
 */
public class LayoutStyleSheetResourceReference extends CssResourceReference {

    /**
     * Singleton instance
     */
    private static LayoutStyleSheetResourceReference instance;

    /**
     * Builds a new instance of {@link LayoutStyleSheetResourceReference}.
     */
    private LayoutStyleSheetResourceReference() {
        super(LayoutStyleSheetResourceReference.class, "layout-default.css");
    }

    /**
     * @return the instance
     */
    public static LayoutStyleSheetResourceReference get() {
        if (instance == null) {
            instance = new LayoutStyleSheetResourceReference();
        }
        return instance;
    }
}

