/**
 * 
 */
package io.aneeslabs.views.secure.dashboard;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import io.aneeslabs.views.MainLayout;

/**
 * 
 */
@PageTitle("Register User")
@Route(value= "/secure/dashboard", layout = MainLayout.class)
public class SecureDashboard extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	public SecureDashboard() {
		setSpacing(true);
		
		setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.END);
		H1 welcomeMessg = new H1("Welcome to the Gifting System");
		
		H3 secondMsg = new H3("=> Our Next Topic will be Spring Security and its Integration with Vaadin");
		
		
		add(welcomeMessg, secondMsg);
	}

}
