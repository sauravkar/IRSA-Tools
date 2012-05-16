/**
 *  File: BasePage
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 15.05.12
 */
package com.irsatools.web.page;

import org.apache.wicket.Component;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author N.Semenov
 */
public abstract class BasePage extends WebPage {

    public BasePage() {
        final Component northPanel = initNorthPanel("north-container");
        add(northPanel);
        final Component westPanel = initWestPanel("west-container");
        add(westPanel);
        final Component centerPanel = initCenterPanel("center-container");
        add(centerPanel);
        final Component eastPanel = initEastPanel("east-container");
        add(eastPanel);
        final Component southPanel = initSouthPanel("south-container");
        add(southPanel);
        add(new DebugBar("debug"));
    }

    abstract Component initNorthPanel(String id);

    abstract Component initWestPanel(String id);

    abstract Component initCenterPanel(String id);

    abstract Component initEastPanel(String id);

    abstract Component initSouthPanel(String id);
}