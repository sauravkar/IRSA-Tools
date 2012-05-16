/**
 *  File: Main
 *  Author: Nikolay Semenov <ns.semenov@gmail.com>
 *  Date: 15.05.12
 */
package com.irsatools.web.pages;

import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author N.Semenov
 */
public class Main extends WebPage {

    public Main() {
        add(new DebugBar("debug"));
    }
}