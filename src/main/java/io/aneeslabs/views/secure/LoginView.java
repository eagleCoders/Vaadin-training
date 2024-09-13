/**
 * 
 */
package io.aneeslabs.views.secure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import io.aneeslabs.server.beans.UserBean;
import io.aneeslabs.server.services.UserManagementServices;
import io.aneeslabs.views.MainLayout;

/**
 * 
 */
@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
public class LoginView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	UserManagementServices userManagementServices;
	
	
	private FormLayout formLayout;
	
	private TextField userNameField;
	private PasswordField passwordField;
	
	private Button loginButton, resetButton;
	
	public LoginView() {
		setAlignItems(Alignment.END);
		setJustifyContentMode(JustifyContentMode.START);
		setSizeFull();
		addClassName("base");
		
		formLayout = new FormLayout();
		formLayout.setResponsiveSteps(new ResponsiveStep("0", 2),
				new ResponsiveStep("250px", 1));
		
		
		
		userNameField = new TextField("User Name");
		
		passwordField = new PasswordField("Password");
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setAlignItems(Alignment.CENTER);
		buttonLayout.setJustifyContentMode(JustifyContentMode.END);
		
		loginButton = new Button("Login");
		loginButton.addClassName("btnLogin");
		resetButton = new Button("Reset");
		resetButton.addClassName("btnReset");
		buttonLayout.setSpacing(true);
		
		resetButton.addClickListener(e->{
			userNameField.setValue("");
			passwordField.setValue("");
		});
		
		loginButton.addClickListener(e->{
			System.out.println("the values are : userName: "+ userNameField.getValue()+ " | password :"+passwordField.getValue());
			try {
				UserBean validUser = userManagementServices.authenticateUser(userNameField.getValue(), passwordField.getValue());
				System.out.println("All Users are : "+validUser.getRole());
				UI.getCurrent().navigate("/secure/dashboard");
			}catch(NullPointerException npe) {
				
			}
			
		});
		
		
		
		buttonLayout.add(resetButton, loginButton);
		
		formLayout.add(userNameField, passwordField, buttonLayout);
		
		add(formLayout);
	}

}
