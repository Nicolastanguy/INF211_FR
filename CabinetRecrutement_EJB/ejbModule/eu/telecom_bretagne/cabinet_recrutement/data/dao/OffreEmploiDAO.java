package eu.telecom_bretagne.cabinet_recrutement.data.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.NiveauQualification;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;

/**
 * Session Bean implementation class OffreEmploiDAO
 * @author TANGUY
 */
@Stateless
@LocalBean
public class OffreEmploiDAO
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
	public OffreEmploiDAO()
	{
		// TODO Auto-generated constructor stub
	}
	//-----------------------------------------------------------------------------
	public OffreEmploi findById(Integer id)
	{
		return entityManager.find(OffreEmploi.class, id);
	}
	//----------------------------------------------------------------------------
  public List<OffreEmploi> findAll()
	{
		Query query = entityManager.createQuery("select offreemploi from offreemploi offreemploi order by offreemploi.numoffreemploi");
		List l = query.getResultList();
		return (List<OffreEmploi>) l;
	}
	//-----------------------------------------------------------------------------
  public List<OffreEmploi> findOffreEmploi(OffreEmploi offreEmploi)
	{
		Query query = entityManager.createQuery("select offreemploi from offreemploi offreemploi where offre_emploi.entreprise=entreprise order by offre_emploi.id");
		List l = query.getResultList();
		return (List<OffreEmploi>) l;
	}
	//-----------------------------------------------------------------------------
  public List<OffreEmploi> find(NiveauQualification NQ, SecteurActivite SA)
	{
		Query query = entityManager.createQuery("select offre_emploi from OffreEmploi offre_emploi where offre_emploi.niveauQualifaction=NQ and offre_emploi.SecteurActivite=SA order by offre_emploi.id");
		List l = query.getResultList();
		return (List<OffreEmploi>) l;
	}
	//-----------------------------------------------------------------------------
  public OffreEmploi create(OffreEmploi offreemploi) {
      this.entityManager.persist(offreemploi);
      return offreemploi;
  }

  public OffreEmploi update(OffreEmploi offreemploi) {
      return this.entityManager.merge(offreemploi);
  }

  public void delete(OffreEmploi offreemploi) {
	  offreemploi = this.entityManager.merge(offreemploi);
      this.entityManager.remove(offreemploi);
  }
}