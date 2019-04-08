package com.presentation.loginUI;

import com.presentation.components.Footer;
import com.presentation.components.Header;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class HomePage extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -810830636383065778L;
	private VerticalLayout mainLayout;

	@Override
	protected void init(VaadinRequest request) {
		mainLayout = new VerticalLayout();
		mainLayout.setMargin(false);
		mainLayout.setSpacing(false);
		
		GridLayout grid = new GridLayout(2, 1); // I use a grid layout because I will need 3 rows and 3 columns
		grid.setSpacing(true);
		System.out.println(grid.getColumns() + " " + grid.getRows());
		grid.addComponent(createLeftPartOfLogin(), 0, 0);
		grid.addComponent(createRightPartOfLogin(), 1, 0);
		
		
		mainLayout.addComponent(new Header());
		mainLayout.addComponent(grid);
		mainLayout.setComponentAlignment(grid, Alignment.MIDDLE_CENTER);
		mainLayout.addComponent(new Label("&nbsp;", ContentMode.HTML));
		Component bottom = createBottomPanel();
		mainLayout.addComponent(bottom);
		mainLayout.setComponentAlignment(bottom, Alignment.MIDDLE_CENTER);
		mainLayout.addComponent(new Label("&nbsp;", ContentMode.HTML));
		mainLayout.addComponent(new Footer());
		this.setContent(mainLayout);
	}

	private Component createLeftPartOfLogin() { //
		VerticalLayout Traveller = new VerticalLayout();
		Label titulo = new Label("Traveler");
		final Page.Styles styles = Page.getCurrent().getStyles();
		String css = ".v-label-stylename {\n" + // This fragment allows you to configure the title font
				"    font-size: 35px;\n" + "    font-weight: bold;\n" + "    line-height: normal;\n" + "}";
		styles.add(css);
		titulo.setStyleName("v-label-stylename");
		Label description = new Label("Traveling around the world is your passion?\n" + 
				"<br>\n" + 
				"Are you ready for new adventures?\n" + 
				"<br>\n" + 
				"Do you want to pay with your knowledge?\n" + 
				"<br>\n" + 
				"Come and join us now, Traveler.",
				ContentMode.HTML);

		Image img = new Image();
		img.setSource(new ExternalResource("https://raw.githubusercontent.com/evivar/images/master/traveler.jpg"));
		img.setWidth(400, Unit.PIXELS);

		Traveller.addComponent(titulo);
		Traveller.addComponent(description);
		Traveller.addComponent(img);
		Traveller.setComponentAlignment(titulo, Alignment.TOP_CENTER);
		Traveller.setComponentAlignment(description, Alignment.MIDDLE_CENTER);
		Traveller.setComponentAlignment(img, Alignment.BOTTOM_CENTER);
		Traveller.setSizeFull();
		Traveller.setWidth("100%");
		Traveller.setHeightUndefined();
		Traveller.setMargin(true);

		return Traveller;

	}

	private Component createRightPartOfLogin() {
		VerticalLayout Host = new VerticalLayout();
		Host.setSizeFull();
		Host.setHeightUndefined();
		Host.setWidth("100%");
		Host.setMargin(true);
		Label title = new Label("Host");
		final Page.Styles styles = Page.getCurrent().getStyles();
		String css = ".v-label-stylename {\n" + "    font-size: 35px;\n" + "    font-weight: bold;\n"
				+ "    line-height: normal;\n" + "}";
		styles.add(css);
		title.setStyleName("v-label-stylename");
		Label description = new Label(
				"Do you like meeting new people and learning " +
				"<br>\n" 
				+ "about different cultures?\n" + 
				"<br>\n" + 
				"Do you want to gain new knowledge?\n" + 
				"<br>\n" + 
				"Join us as Host. Explore the world in the comfort of your home.\n",
				ContentMode.HTML);

		Image img = new Image();
		img.setSource(new ExternalResource("https://raw.githubusercontent.com/evivar/images/master/host.jpg"));
		img.setWidth(400, Unit.PIXELS);

		Host.addComponent(title);
		Host.addComponent(description);
		Host.addComponent(img); // TODO LUEGO SE PONDRA ESTE METODO EN UNA CLASE AUXILIAR
		Host.setComponentAlignment(title, Alignment.TOP_CENTER);
		Host.setComponentAlignment(description, Alignment.MIDDLE_CENTER);
		Host.setComponentAlignment(img, Alignment.BOTTOM_CENTER);

		return Host;
	}

	private Component createBottomPanel() {
		GridLayout panel = new GridLayout(2, 1);
		panel.setSpacing(false);
		Button join = new Button("Register");
		join.setId("joinBtn");
		join.addClickListener(event -> {
			HomePage.this.getUI().getPage().setLocation("register");
		});
		panel.addComponent(join);

		Button login = new Button("Log in");
		login.setId("loginBtn");
		login.addClickListener(event -> {
			HomePage.this.getUI().getPage().setLocation("login");
		});
		panel.addComponent(login);
		return panel;
	}

}
