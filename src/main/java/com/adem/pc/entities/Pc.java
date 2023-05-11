package com.adem.pc.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Pc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPc;
	
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomPc;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prix;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateAjout;
	@ManyToOne
	private Marque marque;
	
	public Pc() {
	super();
	}
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque= marque;
	}
	public Pc(String nomPc, Double prix, Date dateAjout) {
	this.nomPc = nomPc;
	this.prix = prix;
	this.dateAjout= dateAjout;
	}
	public Long getIdPc() {
		return idPc;
	}
	public void setIdPc(Long idPc) {
		this.idPc= idPc;
	}
	public String getNomPc() {
		return nomPc;
	}
	public void setNomPc(String nomPc) {
		this.nomPc= nomPc;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix= prix;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout= dateAjout;
	}
	@Override
	public String toString() {
		return "Pc [idPc=" + idPc + ", nomPc=" + nomPc + ", prix=" + prix + ", dateAjout=" + dateAjout + ", marque="
				+ marque + "]";
	}

	
}
