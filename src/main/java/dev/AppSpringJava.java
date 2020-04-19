package dev;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.config.AppConfig;
import dev.ihm.Menu;

public class AppSpringJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Menu menu = context.getBean(Menu.class);
		menu.afficher();

		// fermeture du contexte Spring
		context.close();
	}

}
