package dev;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.ihm.Menu;
import dev.service.IPlatService;

public class AppSpringXML {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-fichier.xml");


		Menu menu = context.getBean(Menu.class);

		menu.afficher();

		context.close();
	}
}
