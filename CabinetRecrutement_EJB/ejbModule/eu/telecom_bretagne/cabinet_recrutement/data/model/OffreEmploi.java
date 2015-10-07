package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the offre_emploi database table.
 * 
 */
@Entity
@Table(name="offre_emploi")
@NamedQuery(name="OffreEmploi.findAll", query="SELECT o FROM OffreEmploi o")
public class OffreEmploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OFFRE_EMPLOI_NUMOFFREEMPLOI_GENERATOR", sequenceName="OFFRE_EMPLOI_NUM_OFFREEMPLOI_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFFRE_EMPLOI_NUMOFFREEMPLOI_GENERATOR")
	@Column(name="num_offreemploi")
	private Integer numOffreemploi;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	private String descriptifmission;

	private String profilrecherche;

	private String titre;

	//bi-directional many-to-one association to MessageCandidature
	@OneToMany(mappedBy="offreEmploi")
	private Set<MessageCandidature> messageCandidatures;

	//bi-directional many-to-one association to MessageOffreemploi
	@OneToMany(mappedBy="offreEmploi")
	private Set<MessageOffreemploi> messageOffreemplois;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="num_entreprise")
	private Entreprise entreprise;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="num_niveauqualification")
	private NiveauQualification niveauQualification;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="offreEmplois")
	private Set<SecteurActivite> secteurActivites;

	public OffreEmploi() {
	}

	public Integer getNumOffreemploi() {
		return this.numOffreemploi;
	}

	public void setNumOffreemploi(Integer numOffreemploi) {
		this.numOffreemploi = numOffreemploi;
	}

	public Date getDatedepot() {
		return this.datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public String getDescriptifmission() {
		return this.descriptifmission;
	}

	public void setDescriptifmission(String descriptifmission) {
		this.descriptifmission = descriptifmission;
	}

	public String getProfilrecherche() {
		return this.profilrecherche;
	}

	public void setProfilrecherche(String profilrecherche) {
		this.profilrecherche = profilrecherche;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<MessageCandidature> getMessageCandidatures() {
		return this.messageCandidatures;
	}

	public void setMessageCandidatures(Set<MessageCandidature> messageCandidatures) {
		this.messageCandidatures = messageCandidatures;
	}

	public MessageCandidature addMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().add(messageCandidature);
		messageCandidature.setOffreEmploi(this);

		return messageCandidature;
	}

	public MessageCandidature removeMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().remove(messageCandidature);
		messageCandidature.setOffreEmploi(null);

		return messageCandidature;
	}

	public Set<MessageOffreemploi> getMessageOffreemplois() {
		return this.messageOffreemplois;
	}

	public void setMessageOffreemplois(Set<MessageOffreemploi> messageOffreemplois) {
		this.messageOffreemplois = messageOffreemplois;
	}

	public MessageOffreemploi addMessageOffreemploi(MessageOffreemploi messageOffreemploi) {
		getMessageOffreemplois().add(messageOffreemploi);
		messageOffreemploi.setOffreEmploi(this);

		return messageOffreemploi;
	}

	public MessageOffreemploi removeMessageOffreemploi(MessageOffreemploi messageOffreemploi) {
		getMessageOffreemplois().remove(messageOffreemploi);
		messageOffreemploi.setOffreEmploi(null);

		return messageOffreemploi;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public NiveauQualification getNiveauQualification() {
		return this.niveauQualification;
	}

	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}