/**
 * 
 */
package dev.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.entite.Plat;

/**
 * @author boukh
 *
 */
public class PlatRowMapper implements RowMapper<Plat> {
	 public Plat mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Plat plat = new Plat();
	        plat.setNom(rs.getString("nom"));
	        plat.setPrixEnCentimesEuros(rs.getInt("prix"));
	        return plat;
	    }
}
