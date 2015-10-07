package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the candidature database table.
 * 
 */
@Entity
@NamedQuery(name="Candidature.findAll", query="SELECT c FROM Candidature c")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CANDIDATURE_NUMCANDIDATURE_GENERATOR", sequenceName="CANDIDATURE_NUM_CANDIDATURE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CANDIDATURE_NUMCANDIDATURE_GENERATOR")
	@Column(name="num_candidature")
	private Integer numCandidature;

	private String adresseemail;

	private String adressepostale;

	@Temporal(TemporalType.DATE)
	private Date datedepot;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to NiveauQualification
	@ManyToOne
	@JoinColumn(name="num_niveauqualification")
	private NiveauQualification niveauQualification;

	//bi-directional many-to-one association to MessageCandidature
	@OneToMany(mappedBy="candidature")
	private Set<MessageCandidature> messageCandidatures;

	//bi-directional many-to-one association to MessageOffreemploi
	@OneToMany(mappedBy="candidature")
	private Set<MessageOffreemploi> messageOffreemplois;

	//bi-directional many-to-many association to SecteurActivite
	@ManyToMany(mappedBy="candidatures")
	private Set<SecteurActivite> secteurActivites;

	public Candidature() {
	}

	public Integer getNumCandidature() {
		return this.numCandidature;
	}

	public void setNumCandidature(Integer numCandidature) {
		this.numCandidature = numCandidature;
	}

	public String getAdresseemail() {
		return this.adresseemail;
	}

	public void setAdresseemail(String adresseemail) {
		this.adresseemail = adresseemail;
	}

	public String getAdressepostale() {
		return this.adressepostale;
	}

	public void setAdressepostale(String adressepostale) {
		this.adressepostale = adressepostale;
	}

	public Date getDatedepot() {
		return this.datedepot;
	}

	public void setDatedepot(Date datedepot) {
		this.datedepot = datedepot;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public NiveauQualification getNiveauQualification() {
		return this.niveauQualification;
	}

	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

	public Set<MessageCandidature> getMessageCandidatures() {
		return this.messageCandidatures;
	}

	public void setMessageCandidatures(Set<MessageCandidature> messageCandidatures) {
		this.messageCandidatures = messageCandidatures;
	}

	public MessageCandidature addMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().add(messageCandidature);
		messageCandidature.setCandidature(this);

		return messageCandidature;
	}

	public MessageCandidature removeMessageCandidature(MessageCandidature messageCandidature) {
		getMessageCandidatures().remove(messageCandidature);
		messageCandidature.setCandidature(null);

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
		messageOffreemploi.setCandidature(this);

		return messageOffreemploi;
	}

	public MessageOffreemploi removeMessageOffreemploi(MessageOffreemploi messageOffreemploi) {
		getMessageOffreemplois().remove(messageOffreemploi);
		messageOffreemploi.setCandidature(null);

		return messageOffreemploi;
	}

	public Set<SecteurActivite> getSecteurActivites() {
		return this.secteurActivites;
	}

	public void setSecteurActivites(Set<SecteurActivite> secteurActivites) {
		this.secteurActivites = secteurActivites;
	}

}