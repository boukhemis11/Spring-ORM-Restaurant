/**
 * 
 */
package dev.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;

/**
 * @author boukh
 *
 */
@Repository
@Profile("daojdbc")
public class PlatDaoJdbc implements IPlatDao {
	private JdbcTemplate jdbcTemplate;
	

	
	  public PlatDaoJdbc(DataSource datasource) { 
		  this.jdbcTemplate = new JdbcTemplate(datasource); 
	  }
	  
	  public Integer countPlat() {
		  String sql = "SELECT COUNT(*) FROM plat";
		  return this.jdbcTemplate.queryForObject(sql, Integer.class);
	  }

	@Override
	public List<Plat> listerPlats() {
		return this.jdbcTemplate.query("select * from plat", new PlatRowMapper());
	}

	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat p = new Plat(nomPlat, prixPlat);
		String sql = "INSERT INTO plat (NOM,PRIX) VALUES(?,?)";
		jdbcTemplate.update(sql, p.getNom(), p.getPrixEnCentimesEuros());
		
	}
}
