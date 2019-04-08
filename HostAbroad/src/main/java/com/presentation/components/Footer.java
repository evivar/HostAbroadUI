package com.presentation.components;

import com.vaadin.annotations.Theme;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

@Theme("mytheme")
public class Footer extends Panel {

	public Footer() {
		GridLayout footer = new GridLayout(3, 1);
		
		GridLayout social = new GridLayout(1, 3);
		//social.setSpacing(true);
		
		footer.setStyleName("footer-color-gray");
		footer.setWidth("100%");
		footer.setMargin(true);
		footer.setSpacing(false);
		Label title = new Label("Host Abroad ©");
		title.setStyleName("title-label");
		footer.addComponent(title);
		title.setWidth(null);
		//footer.setComponentAlignment(title, Alignment.MIDDLE_LEFT);
		
		Button twitter = new Button();
		twitter.setIcon(VaadinIcons.TWITTER);
		twitter.setStyleName("button-social");
		social.addComponent(twitter);
		
		Button facebook = new Button();
		facebook.setIcon(VaadinIcons.FACEBOOK);
		facebook.setStyleName("button-social");
		social.addComponent(facebook);
		
		Button instagram = new Button();
		instagram.setIcon(VaadinIcons.CAMERA);
		instagram.setStyleName("button-social");
		social.addComponent(instagram);
		
		footer.addComponent(social);
		
		this.setContent(footer);
	}
	
}
