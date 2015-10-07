package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the entreprise database table.
 * 
 */
@Entity
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENTREPRISE_NUMENTREPRISE_GENERATOR", sequenceName="ENTREPRISE_NUM_ENTREPRISE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENTREPRISE_NUMENTREPRISE_GENERATOR")
	@Column(name="num_entreprise")
	private Integer numEntreprise;

	private String adressepostale;

	private String descriptif;

	private String nom;
	
	private int id;

	//bi-directional many-to-one association to OffreEmploi
	@OneToMany(mappedBy="entreprise")
	private Set<OffreEmploi> offreEmplois;

	public Entreprise() {
	}

	public Integer getNumEntreprise() {
		return this.numEntreprise;
	}

	public void setNumEntreprise(Integer numEntreprise) {
		this.numEntreprise = numEntreprise;
	}

	public String getAdressepostale() {
		return this.adressepostale;
	}

	public void setAdressepostale(String adressepostale) {
		this.adressepostale = adressepostale;
	}

	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<OffreEmploi> getOffreEmplois() {
		return this.offreEmplois;
	}

	public void setOffreEmplois(Set<OffreEmploi> offreEmplois) {
		this.offreEmplois = offreEmplois;
	}

	public OffreEmploi addOffreEmploi(OffreEmploi offreEmploi) {
		getOffreEmplois().add(offreEmploi);
		offreEmploi.setEntreprise(this);

		return offreEmploi;
	}

	public OffreEmploi removeOffreEmploi(OffreEmploi offreEmploi) {
		getOffreEmplois().remove(offreEmploi);
		offreEmploi.setEntreprise(null);

		return offreEmploi;
	}

	public int getId() {
		return this.id;
	}
	
	public String getAdressePostale() {
		return this.adressepostale;
	}

}