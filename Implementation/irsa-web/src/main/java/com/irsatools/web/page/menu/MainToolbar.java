/**
 *  File: MainToolbar
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 16.05.12
 */
package com.irsatools.web.page.menu;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.ui.button.ButtonBehavior;
import org.odlabs.wiquery.ui.themes.UiIcon;

/**
 * Main toolbar menu
 *
 * @author N.Semenov
 */
public class MainToolbar extends Panel {

    public MainToolbar(String id) {
        super(id);

        Form<String> mainMenuForm = new Form<String>("main-menu-form");
        add(mainMenuForm);

        AjaxButton newButton = new AjaxButton("new-main-menu-button", mainMenuForm) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
            }
        };
        newButton.add(new ButtonBehavior().setLabel("New").setIcons(UiIcon.DOCUMENT, null));
        mainMenuForm.add(newButton);

        AjaxButton openButton = new AjaxButton("open-main-menu-button", mainMenuForm) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
            }

            @Override
            protected void onError(AjaxRequestTarget target, Form<?> form) {
            }
        };
        openButton.add(new ButtonBehavior().setLabel("Open").setIcons(UiIcon.FOLDER_OPEN, null));
        mainMenuForm.add(openButton);
    }
}
