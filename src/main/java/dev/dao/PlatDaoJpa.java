/**
 * 
 */
package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.entite.Plat;

/**
 * @author boukh
 *
 */
@Repository
@Profile("jpa")
public class PlatDaoJpa implements IPlatDao {

	private EntityManager em;

	@Override
	public List<Plat> listerPlats() {

		return em.createQuery("select p from Plat p", Plat.class).getResultList();
	}

	@Transactional
	@Override
	public void ajouterPlat(String nomPlat, Integer prixPlat) {

		em.persist(new Plat(nomPlat, prixPlat));
	}

	/**
	 * Setter
	 *
	 * @param emf the emf to set
	 */
	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
