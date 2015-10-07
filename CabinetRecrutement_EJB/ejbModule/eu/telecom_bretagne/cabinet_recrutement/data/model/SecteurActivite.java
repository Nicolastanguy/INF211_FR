package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the secteur_activite database table.
 * 
 */
@Entity
@Table(name="secteur_activite")
@NamedQuery(name="SecteurActivite.findAll", query="SELECT s FROM SecteurActivite s")
public class SecteurActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTEUR_ACTIVITE_NUMSECTEURACTIVITE_GENERATOR", sequenceName="SECTEUR_ACTIVITE_NUM_SECTEURACTIVITE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTEUR_ACTIVITE_NUMSECTEURACTIVITE_GENERATOR")
	@Column(name="num_secteuractivite")
	private Integer numSecteuractivite;

	private String intitule;

	//bi-directional many-to-many association to OffreEmploi
	@ManyToMany
	@JoinTable(
		name="offreemploi_secteuractivite"
		, joinColumns={
			@JoinColumn(name="num_secteuractivite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="num_offreemploi")
			}
		)
	private Set<OffreEmploi> offreEmplois;

	//bi-directional many-to-many association to Candidature
	@ManyToMany
	@JoinTable(
		name="secteuractivite_candidature"
		, joinColumns={
			@JoinColumn(name="num_secteuractivite")
			}
		, inverseJoinColumns={
			@JoinColumn(name="num_candidature")
			}
		)
	private Set<Candidature> candidatures;

	public SecteurActivite() {
	}

	public Integer getNumSecteuractivite() {
		return this.numSecteuractivite;
	}

	public void setNumSecteuractivite(Integer numSecteuractivite) {
		this.numSecteuractivite = numSecteuractivite;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Set<OffreEmploi> getOffreEmplois() {
		return this.offreEmplois;
	}

	public void setOffreEmplois(Set<OffreEmploi> offreEmplois) {
		this.offreEmplois = offreEmplois;
	}

	public Set<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

}