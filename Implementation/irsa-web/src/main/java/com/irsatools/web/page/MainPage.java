/**
 *  File: MainPage
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.page;

import com.irsatools.web.component.layout.Layout;
import com.irsatools.web.page.area.*;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author N.Semenov
 */
public class MainPage extends WebPage {
    private static final long serialVersionUID = 1L;

    public MainPage() {
        add(new Label("title", "IRSA Tools"));

        Layout layout = new Layout("layout", false) {

            private static final long serialVersionUID = 1L;

            @Override
            public Panel getLayoutNorthComponent(String wicketId) {
                return new HeaderArea(wicketId);
            }

            @Override
            public Panel getLayoutWestComponent(String wicketId) {
                return new WestArea(wicketId);
            }

            @Override
            public Panel getLayoutCenterComponent(String wicketId) {
                return new CenterArea(wicketId);
            }

            @Override
            public Panel getLayoutEastComponent(String wicketId) {
                return new EastArea(wicketId);
            }

            @Override
            public Panel getLayoutSouthComponent(String wicketId) {
                return new FooterArea(wicketId);
            }
        };
        layout.setMarkupId("body_container");
        // Setup pane's properties
        layout.setSize(Layout.PanePositionEnum.NORTH, 32)
                .setResizable(Layout.PanePositionEnum.NORTH, false)
                .setClosable(Layout.PanePositionEnum.NORTH, false)
                .setSpacingOpen(Layout.PanePositionEnum.NORTH, 0);

        layout.setSize(Layout.PanePositionEnum.WEST, 200)
                .setMinSize(Layout.PanePositionEnum.WEST, 100)
                .setMaxSize(Layout.PanePositionEnum.WEST, 400);

        layout.setSize(Layout.PanePositionEnum.EAST, 300)
                .setMinSize(Layout.PanePositionEnum.EAST, 200)
                .setMaxSize(Layout.PanePositionEnum.EAST, 500);

        layout.setSize(Layout.PanePositionEnum.SOUTH, 30)
                .setMinSize(Layout.PanePositionEnum.SOUTH, 30)
                .setMaxSize(Layout.PanePositionEnum.SOUTH, 300);
        add(layout);
    }
}

