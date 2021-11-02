package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Rayon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idRayon ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
	private Set<Produit> produits;

	@Override
	public String toString() {
		return "Rayon{" +
				"idRayon=" + idRayon +
				", produits=" + produits +
				", code='" + code + '\'' +
				", libelle='" + libelle + '\'' +
				'}';
	}

	public long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(long idRayon) {
		this.idRayon = idRayon;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	String code ;

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	String libelle;
}
