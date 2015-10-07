package eu.telecom_bretagne.cabinet_recrutement.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message_offreemploi database table.
 * 
 */
@Entity
@Table(name="message_offreemploi")
@NamedQuery(name="MessageOffreemploi.findAll", query="SELECT m FROM MessageOffreemploi m")
public class MessageOffreemploi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGE_OFFREEMPLOI_NUMMESSAGEOFFREEMPLOI_GENERATOR", sequenceName="MESSAGE_OFFREEMPLOI_NUM_MESSAGEOFFREEMPLOI_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGE_OFFREEMPLOI_NUMMESSAGEOFFREEMPLOI_GENERATOR")
	@Column(name="num_messageoffreemploi")
	private Integer numMessageoffreemploi;

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

	public MessageOffreemploi() {
	}

	public Integer getNumMessageoffreemploi() {
		return this.numMessageoffreemploi;
	}

	public void setNumMessageoffreemploi(Integer numMessageoffreemploi) {
		this.numMessageoffreemploi = numMessageoffreemploi;
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