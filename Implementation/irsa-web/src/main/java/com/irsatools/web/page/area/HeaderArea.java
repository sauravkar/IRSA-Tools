/**
 *  File: HeaderArea
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.page.area;

import com.irsatools.web.page.menu.MainToolbar;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author N.Semenov
 */
public class HeaderArea extends Panel {

    public HeaderArea(String id) {
        super(id);
        add(new MainToolbar("main-toolbar"));
    }
}
