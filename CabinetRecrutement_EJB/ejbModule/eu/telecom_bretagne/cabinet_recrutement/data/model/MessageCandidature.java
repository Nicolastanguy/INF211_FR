package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message_candidature database table.
 * 
 */
@Entity
@Table(name="message_candidature")
@NamedQuery(name="MessageCandidature.findAll", query="SELECT m FROM MessageCandidature m")
public class MessageCandidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGE_CANDIDATURE_NUMMESSAGECANDIDATURE_GENERATOR", sequenceName="MESSAGE_CANDIDATURE_NUM_MESSAGECANDIDATURE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_CANDIDATURE_NUMMESSAGECANDIDATURE_GENERATOR")
	@Column(name="num_messagecandidature")
	private Integer numMessagecandidature;

	private String corpsmessage;

	@Temporal(TemporalType.DATE)
	private Date dateenvoi;

	//bi-directional many-to-one association to Candidature
	@ManyToOne
	@JoinColumn(name="num_candidature")
	private Candidature candidature;

	//bi-directional many-to-one association to OffreEmploi
	@ManyToOne
	@JoinColumn(name="num_offreemploi")
	private OffreEmploi offreEmploi;

	public MessageCandidature() {
	}

	public Integer getNumMessagecandidature() {
		return this.numMessagecandidature;
	}

	public void setNumMessagecandidature(Integer numMessagecandidature) {
		this.numMessagecandidature = numMessagecandidature;
	}

	public String getCorpsmessage() {
		return this.corpsmessage;
	}

	public void setCorpsmessage(String corpsmessage) {
		this.corpsmessage = corpsmessage;
	}

	public Date getDateenvoi() {
		return this.dateenvoi;
	}

	public void setDateenvoi(Date dateenvoi) {
		this.dateenvoi = dateenvoi;
	}

	public Candidature getCandidature() {
		return this.candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

	public OffreEmploi getOffreEmploi() {
		return this.offreEmploi;
	}

	public void setOffreEmploi(OffreEmploi offreEmploi) {
		this.offreEmploi = offreEmploi;
	}

}