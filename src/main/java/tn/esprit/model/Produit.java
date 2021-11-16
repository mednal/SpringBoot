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
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  idProduit; 
	private String  code; 
	private String  libelle;
	private float  prixUnitaire;

	@ManyToMany(targetEntity=Fournisseur.class,cascade=CascadeType.MERGE)
	private Set<Fournisseur> fournisseurProduit;

	public Set<Fournisseur> getFournisseurProduit() {
		return fournisseurProduit;
	}

	public void setFournisseurProduit(Set<Fournisseur> fournisseurProduit) {
		this.fournisseurProduit = fournisseurProduit;
	}

	@ManyToOne
	Rayon rayon;
	@ManyToOne
	DetailFacture detailFacture;
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToOne
	Stock stock;


	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public DetailFacture getDetailFacture() {
		return detailFacture;
	}

	public void setDetailFacture(DetailFacture detailFacture) {
		this.detailFacture = detailFacture;
	}

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}


	
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIdlibelle() {
		return libelle;
	}
	public void setIdlibelle(String idlibelle) {
		this.libelle = idlibelle;
	}
	public float getIdprixUnitaire() {
		return prixUnitaire;
	}
	public void setIdprixUnitaire(float idprixUnitaire) {
		this.prixUnitaire = idprixUnitaire;
	}

}
