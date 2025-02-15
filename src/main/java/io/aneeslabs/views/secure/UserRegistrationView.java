/**
 * 
 */
package io.aneeslabs.views.secure;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

import io.aneeslabs.views.MainLayout;

/**
 * 
 */
@Route(value="registration", layout = MainLayout.class)
public class UserRegistrationView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	public UserRegistrationView() {
	       setSpacing(false);

	        Image img = new Image("images/empty-plant.png", "placeholder plant");
	        img.setWidth("200px");
	        add(img);

	        H2 header = new H2("This place is for User Registration Form");
	        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
	        add(header);
	        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

	        setSizeFull();
	        setJustifyContentMode(JustifyContentMode.CENTER);
	        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	        getStyle().set("text-align", "center");
	}

}
