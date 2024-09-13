/**
 * 
 */
package io.aneeslabs;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.theme.Theme;

/**
 * 
 */
@Theme(value = "giftio-web")
public class ApplicationConfigurator implements AppShellConfigurator {

	private static final long serialVersionUID = 1L;
	@Override
	public void configurePage(AppShellSettings settings) {
		settings.addFavIcon("icon", "icons/icon.png", "200x200");
		settings.addLink("short icon", "icons/icon.png");
	}

}
