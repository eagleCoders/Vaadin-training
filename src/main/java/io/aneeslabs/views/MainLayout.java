package io.aneeslabs.views;

import org.vaadin.lineawesome.LineAwesomeIcon;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

import io.aneeslabs.views.aboutus.AboutUsView;
import io.aneeslabs.views.secure.LoginView;
import io.aneeslabs.views.secure.UserRegistrationView;
import io.aneeslabs.views.welcome.WelcomeView;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private static final long serialVersionUID = 1L;
	private H1 viewTitle;
    
	private HorizontalLayout imageViewTitleLayout, securityLayout;
	private FlexLayout centerNavigationLayout;
	private Image logoImg;
    

    public MainLayout() {
        setPrimarySection(Section.NAVBAR);
        setDrawerOpened(false);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
		imageViewTitleLayout = new HorizontalLayout();
		securityLayout = new HorizontalLayout();
		imageViewTitleLayout.setAlignItems(Alignment.CENTER);
		imageViewTitleLayout.setWidth(50, Unit.PERCENTAGE);
		securityLayout.setAlignItems(Alignment.END);
        securityLayout.setJustifyContentMode(JustifyContentMode.END);
		
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

		logoImg = new Image("icons/icon.png", "aneesLabs");
		logoImg.setWidth(30, Unit.PIXELS);
		logoImg.setHeight(30, Unit.PIXELS);
		logoImg.addClickListener(e->{
			UI.getCurrent().navigate("");
		});

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        
        centerNavigationLayout = new FlexLayout();
        centerNavigationLayout.setSizeFull();

		imageViewTitleLayout.add(logoImg, viewTitle);

		
        addToNavbar(true, toggle, imageViewTitleLayout,centerNavigationLayout, createLoginBar());
    }
    
    private HorizontalLayout createLoginBar() {
    	HorizontalLayout loginLayout = new HorizontalLayout();
    	loginLayout.setAlignItems(Alignment.CENTER);
    	loginLayout.setJustifyContentMode(JustifyContentMode.END);
    	Button loginBtn = new Button("Login");
    	Button registerBtn = new Button("Registration");
    	
    	loginBtn.setIcon(VaadinIcon.ENTER_ARROW.create());
    	loginBtn.setIconAfterText(true);
    	loginBtn.addThemeVariants(ButtonVariant.LUMO_SMALL);
    	loginBtn.addClassName("login");
    	loginBtn.getStyle().set("cursor", "hand");
    	
    	loginBtn.addClickListener((evt)->{
			UI.getCurrent().navigate(LoginView.class);
		});
    	
    	registerBtn.setIcon(LineAwesomeIcon.PEN_ALT_SOLID.create());
    	registerBtn.setIconAfterText(false);
    	registerBtn.addThemeVariants(ButtonVariant.LUMO_SMALL);
    	registerBtn.addClassName("register");
    	
    	registerBtn.addClickListener(e->{
    		UI.getCurrent().navigate(UserRegistrationView.class);
    	});
    	
    	loginLayout.add(registerBtn, loginBtn);
    	
    	return loginLayout;
    }

    private void addDrawerContent() {
        Span appName = new Span("Giftio-Web");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());
        
        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        SideNavItem welcomeItem =  new SideNavItem("Welcome", WelcomeView.class, LineAwesomeIcon.HOME_SOLID.create());
        SideNavItem aboutusItem =  new SideNavItem("About Us", AboutUsView.class, LineAwesomeIcon.USER_FRIENDS_SOLID.create());
        nav.addItem(welcomeItem);
        nav.addItem(aboutusItem);
        
        welcomeItem.addClassName("external");
        aboutusItem.addClassName("external");

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        SideNav nav = new SideNav();

        SideNavItem registerItem =  new SideNavItem("Register", UserRegistrationView.class, VaadinIcon.ENTER_ARROW.create());
        SideNavItem loginItem =  new SideNavItem("Login", LoginView.class, LineAwesomeIcon.PEN_ALT_SOLID.create());
        nav.addItem(registerItem);
        nav.addItem(loginItem);

        layout.add(nav);
        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
