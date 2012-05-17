/**
 *  File: FooterArea
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.page.area;

import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author N.Semenov
 */
public class FooterArea extends Panel {

    public FooterArea(String id) {
        super(id);
        add(new DebugBar("debug"));
    }
}
