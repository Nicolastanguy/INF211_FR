package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class CandidatureDAO
 * @author TANGUY
 */
@Stateless
@LocalBean
public class CandidatureDAO
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
	public CandidatureDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public Candidature findById(Integer id)
	{
		return entityManager.find(Candidature.class, id);
	}
	//----------------------------------------------------------------------------
  public List<Candidature> findAll()
	{
		Query query = entityManager.createQuery("select candidature from Candidature candidature order by candidature.id");
		List l = query.getResultList();
		return (List<Candidature>) l;
	}
	//-----------------------------------------------------------------------------
  public List<Candidature> find(NiveauQualification NQ, SecteurActivite SA)
	{
		Query query = entityManager.createQuery("select candidature from Candidature candidature where candidature.niveauQualifaction=NQ and candidature.SecteurActivite=SA order by candidature.id");
		List l = query.getResultList();
		return (List<Candidature>) l;
	}
	//-----------------------------------------------------------------------------
  public Candidature create(Candidature candidature) {
      this.entityManager.persist(candidature);
      return candidature;
  }

  public Candidature update(Candidature candidature) {
      return this.entityManager.merge(candidature);
  }

  public void delete(Candidature candidature) {
	  candidature = this.entityManager.merge(candidature);
      this.entityManager.remove(candidature);
  }
}
