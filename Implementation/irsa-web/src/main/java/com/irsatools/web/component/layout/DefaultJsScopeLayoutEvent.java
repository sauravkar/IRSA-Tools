/**
 *  File: DefaultJsScopeLayoutEvent
 *  Author: Nikolay Semenov <nsemenov@reksoft.ru>
 *  Date: 17.05.12
 */
package com.irsatools.web.component.layout;

import org.odlabs.wiquery.core.javascript.JsScopeContext;

/**
 * @author N.Semenov
 */
public class DefaultJsScopeLayoutEvent extends JsScopeLayoutEvent {

    private static final long serialVersionUID = 1L;

    // Properties
    private CharSequence javascriptCode;

    public DefaultJsScopeLayoutEvent(CharSequence javascriptCode) {
        super();
        this.javascriptCode = javascriptCode;
    }

    @Override
    protected final void execute(JsScopeContext scopeContext) {
        scopeContext.append(javascriptCode);
    }

}
