package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class EntrepriseDAO
 * @author Philippe TANGUY
 */
@Stateless
@LocalBean
public class SecteurActiviteDAO
{
	//-----------------------------------------------------------------------------
	/**
	 * Référence vers le gestionnaire de persistance.
	 */
	@PersistenceContext
	EntityManager entityManager;
	//-----------------------------------------------------------------------------
	/**
	 * Default constructor.
	 */
	public SecteurActiviteDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public SecteurActivite findById(Integer id)
	{
		return entityManager.find(SecteurActivite.class, id);
	}
	//----------------------------------------------------------------------------
  public List<SecteurActivite> findAll()
	{
		Query query = entityManager.createQuery("select secteuractivite from secteurActivite secteuractivite order by secteuractivite.id");
		List l = query.getResultList();
		return (List<SecteurActivite>) l;
	}
	//-----------------------------------------------------------------------------
  public SecteurActivite create(SecteurActivite secteuractivite) {
      this.entityManager.persist(secteuractivite);
      return secteuractivite;
  }

  public SecteurActivite update(SecteurActivite secteuractivite) {
      return this.entityManager.merge(secteuractivite);
  }
  // public List<SecteurActivite> Choix de navigabilité
	{
	}
}
