package io.aneeslabs.views.welcome;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import io.aneeslabs.views.MainLayout;

@PageTitle("Welcome")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class WelcomeView extends VerticalLayout {

    public WelcomeView() {
        setSpacing(false);

        Image img = new Image("images/Giftio_GiftCard.png", "Giftio Welcome");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("Giftio: Lets Cherish your Gifting Experience with Rewards");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("To grow your network or love, this is the place"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
