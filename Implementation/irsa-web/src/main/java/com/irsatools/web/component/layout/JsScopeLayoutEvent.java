/**
 *  File: JsScopeLayoutEvent
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.component.layout;

import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.core.javascript.JsScopeContext;

/**
 * @author N.Semenov
 */
public abstract class JsScopeLayoutEvent extends JsScope {

    private static final long serialVersionUID = 1L;

    public JsScopeLayoutEvent() {
        super("paneName", "paneElement", "paneState", "paneOptions", "layoutName");
    }

    /**
     * Creates a default {@link JsScopeLayoutEvent} to execute the given statement.
     *
     * @param javascriptCode the JavaScript statement to execute with the scope.
     * @return the created {@link JsScopeLayoutEvent}.
     */
    public static JsScopeLayoutEvent quickScope(final CharSequence javascriptCode) {
        return new JsScopeLayoutEvent() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void execute(JsScopeContext scopeContext) {
                scopeContext.append(javascriptCode);
            }

        };
    }
}


