/**
 * 
 */
package dev.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JpaTestConfig;
import dev.dao.PlatDaoJpa;
import dev.entite.Plat;

/**
 * @author boukh
 *
 */
@SpringJUnitConfig(classes = { PlatDaoJpa.class, JpaTestConfig.class })
@ActiveProfiles("jpa")
class PlatDaoJpaIntegrationTest {

	@Autowired
	PlatDaoJpa dao;

	@Test
	void testListerPlatsNonVide() {

		Assertions.assertThat(dao.listerPlats()).isNotEmpty();
	}

	@Test
	void testAjouterPlat() {

		Plat plat = new Plat("couscous", 1600);

		dao.ajouterPlat(plat.getNom(), plat.getPrixEnCentimesEuros());

		Assertions.assertThat(dao.listerPlats()).contains(plat);
	}

}