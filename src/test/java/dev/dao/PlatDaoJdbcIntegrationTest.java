/**
 * 
 */
package dev.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.config.JdbcTestConfig;
import dev.entite.Plat;

/**
 * @author boukh
 *
 */
@SpringJUnitConfig({ JdbcTestConfig.class, PlatDaoJdbc.class })
@ActiveProfiles("daojdbc")
public class PlatDaoJdbcIntegrationTest {
	
	@Autowired
	private PlatDaoJdbc platdaojdbc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	

	@Test
	void listerPlatsNonVide(){
		List<Plat> listePlats = platdaojdbc.listerPlats();
		assertFalse(listePlats.isEmpty());
	}
	
	@Test
	void testAjouterPlat() {

		Plat platAjoute = new Plat("plat 1", 1200);
		platdaojdbc.ajouterPlat(platAjoute.getNom(), platAjoute.getPrixEnCentimesEuros());

		String sql = "SELECT * FROM plat where nom=?";
		Plat platRecupere = jdbcTemplate.queryForObject(sql, new Object[] { "plat 1" }, new PlatRowMapper());

		assertThat(platAjoute).isEqualTo(platRecupere);
	}
}
