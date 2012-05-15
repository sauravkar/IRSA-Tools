/**
 *  File: BasePage
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 15.05.12
 */
package com.irsatools.web;

import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author N.Semenov
 */
public class BasePage extends WebPage {

    public BasePage() {
        add(new DebugBar("debug"));
    }
}