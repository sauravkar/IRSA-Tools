/**
 *  File: Main
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 15.05.12
 */
package com.irsatools.web.page;

import com.irsatools.web.component.MainMenu;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;

/**
 * @author N.Semenov
 */
public class Main extends BasePage {

    public Main() {
    }

    @Override
    Component initNorthPanel(String id) {
        return new MainMenu(id);
    }

    @Override
    Component initWestPanel(String id) {
        return new Label(id);
    }

    @Override
    Component initCenterPanel(String id) {
        return new Label(id);
    }

    @Override
    Component initEastPanel(String id) {
        return new Label(id);
    }

    @Override
    Component initSouthPanel(String id) {
        return new Label(id);
    }
}