package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Facture implements  Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	
 		private long idFacture ;
	 	private float montantRemise ;
	 	private float montantFacture ;
	 	@Temporal(value=TemporalType.TIMESTAMP)
		private Date DateFacture  ;
		private boolean active  ;


		@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
		private Set<DetailFacture> detailFactures;
		@ManyToOne
		Client client;

		public Set<DetailFacture> getDetailFactures() {
			return detailFactures;
		}

		public void setDetailFactures(Set<DetailFacture> detailFactures) {
			this.detailFactures = detailFactures;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public long getIdFacture() {
			return idFacture;
		}
		public void setIdFacture(long idFacture) {
			this.idFacture = idFacture;
		}
		public float getMontantRemise() {
			return montantRemise;
		}
		public void setMontantRemise(float montantRemise) {
			this.montantRemise = montantRemise;
		}
		public float getmontantFacture() {
			return montantFacture;
		}
		public void setmontantFacture(float montantFacture) {
			this.montantFacture = montantFacture;
		}
		public Date getDateFacture() {
			return DateFacture;
		}
		public void setDateFacture(Date dateFacture) {
			DateFacture = dateFacture;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
	 
}
