package eu.telecom_bretagne.cabinet_recrutement.front.controlesDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.telecom_bretagne.cabinet_recrutement.data.dao.CandidatureDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.EntrepriseDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.OffreEmploiDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.dao.SecteurActiviteDAO;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;
import eu.telecom_bretagne.cabinet_recrutement.data.model.Entreprise;
import eu.telecom_bretagne.cabinet_recrutement.data.model.OffreEmploi;
import eu.telecom_bretagne.cabinet_recrutement.data.model.SecteurActivite;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocator;
import eu.telecom_bretagne.cabinet_recrutement.front.utils.ServicesLocatorException;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/ControlesDAO")
public class ControlesDAOServlet extends HttpServlet
{
	//-----------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	//-----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlesDAOServlet()
	{
		super();
	}
	//-----------------------------------------------------------------------------
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Flot de sortie pour écriture des résultats.
    PrintWriter out = response.getWriter();
    
    // Récupération de la réféence vers le(s) DAO(s)
		EntrepriseDAO entrepriseDAO = null;
		CandidatureDAO candidatureDAO = null;
		OffreEmploiDAO offreEmploiDAO = null;
		SecteurActiviteDAO secteurActiviteDAO = null;
    try
    {
	    entrepriseDAO = (EntrepriseDAO) ServicesLocator.getInstance().getRemoteInterface("EntrepriseDAO");
	    candidatureDAO = (CandidatureDAO) ServicesLocator.getInstance().getRemoteInterface("CandidatureDAO");
	    offreEmploiDAO = (OffreEmploiDAO) ServicesLocator.getInstance().getRemoteInterface("OffreEmploiDAO");
	    secteurActiviteDAO = (SecteurActiviteDAO) ServicesLocator.getInstance().getRemoteInterface("SecteurActiviteDAO");
    }
    catch (ServicesLocatorException e)
    {
    	e.printStackTrace();
    }
		out.println("Contrôles de fonctionnement du DAO EntrepriseDAO");
		out.println();
		
		// Contrôle(s) de fonctionnalités.
		out.println("Liste des entreprises :");
		List<Entreprise> entreprises = entrepriseDAO.findAll();
		
		for(Entreprise entreprise : entreprises)
		{
			out.println(entreprise.getNom());
		}
		out.println();
		
		out.println("Obtention de l'entreprise n° 1 :");
		Entreprise e = entrepriseDAO.findById(1);
		//out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println();
		
		out.println("Obtention de l'entreprise n° 2 :");
		e = entrepriseDAO.findById(2);
		//out.println(e.getId());
		out.println(e.getNom());
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println();

		out.println("Contrôles de fonctionnement du DAO CandidatureDAO");
		out.println();
		out.println("Liste des candidatures");
		out.println();
		List<Candidature> candidatures = candidatureDAO.findAll();
		
		for(Candidature candidature : candidatures)
		{
			out.print(candidature.getNom());
			out.println();
		}
		out.println();
		
		out.println("Obtention de la candidature numéro 1:");
		Candidature c = candidatureDAO.findById(1);
		//out.println(e.getId());
		out.println(c.getNom());
		out.println(c.getPrenom());
		out.println(c.getDatenaissance());
		out.println(c.getAdresseemail());
		out.println(c.getNumCandidature());
		out.println(c.getDatedepot());
		out.println();
		
		out.println("Obtention de la candidature numéro 2:");
		Candidature c2 = candidatureDAO.findById(2);
		//out.println(e.getId());
		out.println(c2.getNom());
		out.println(c2.getPrenom());
		out.println(c2.getDatenaissance());
		out.println(c2.getAdresseemail());
		out.println(c2.getNumCandidature());
		out.println(c2.getDatedepot());
		out.println();
		
		
		out.println("Contrôles de fonctionnement du DAO OffreEmploiDAO");
		out.println();
		out.println("Liste des Offre d'emplois");
		out.println();
		
		List<OffreEmploi> offreEmplois = (offreEmploiDAO).findAll();
		
		for(OffreEmploi offreEmploi : offreEmplois)
		{
			out.print(offreEmploi.getTitre());
			out.println();
		}
		out.println();
		
		out.println("Obtention de l'offre d'emploi numéro 1:");
		OffreEmploi o = offreEmploiDAO.findById(1);
		out.println(e.getId());
		out.println(o.getNumOffreemploi());
		out.println(o.getTitre());
		out.println(o.getEntreprise());
		out.println(o.getDescriptifmission());
		out.println(o.getProfilrecherche());
		out.println(o.getDatedepot());
		out.println();
		
		out.println("Contrôles de fonctionnement du DAO SecteurActiviteDAO");
		out.println();
		out.println("Liste des secteurs d'activités");
		out.println();
		
		List<SecteurActivite> secteurActivites = (secteurActiviteDAO).findAll();

		//corriger boucle for
		/*for(SecteurActivite SecteurActivite : SecteurActivite)
		{
			out.print(SecteurActivite.getIntitule());
			out.println();
		}
		out.println();
		*/
		out.println("Obtention du secteur d'activité numéro 1:");
		SecteurActivite s = secteurActiviteDAO.findById(1);
		out.println(e.getDescriptif());
		out.println(e.getAdressePostale());
		out.println(e.getNom());
		out.println(e.getId());
		out.println();

		
		
	}
	//-----------------------------------------------------------------------------
}
