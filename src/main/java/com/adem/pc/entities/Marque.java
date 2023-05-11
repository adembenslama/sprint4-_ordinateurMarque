package com.adem.pc.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idMar;
private String nomMar;
private String descriptionMar;

@OneToMany(mappedBy = "marque")
@JsonIgnore
private List<Pc> pcs;



public long getIdMar() {
	return idMar;
}

public void setIdMar(long idMar) {
	this.idMar= idMar;
}

public String getNomMar() {
	return nomMar;
}

public void setNomMar(String nomMar) {
	this.nomMar= nomMar;
}

public String getDescriptionMar() {
	return descriptionMar;
}

public void setDescriptionMar(String descriptionMar) {
	this.descriptionMar= descriptionMar;
}

public List<Pc> getPcs() {
	return pcs;
}

public void setPcs(List<Pc> pcs) {
	this.pcs= pcs;
}





}
