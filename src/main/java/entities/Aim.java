package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aim database table.
 * 
 */
@Entity
@NamedQuery(name="Aim.findAll", query="SELECT a FROM Aim a")
public class Aim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aim")
	private int idAim;

	@Column(name="id_family")
	private int idFamily;

	@Column(name="id_receipt")
	private int idReceipt;

	private float owned;

	@Column(name="price_aim")
	private float priceAim;

	@Lob
	@Column(name="text_aim")
	private String textAim;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Aim() {
	}

	public int getIdAim() {
		return this.idAim;
	}

	public void setIdAim(int idAim) {
		this.idAim = idAim;
	}

	public int getIdFamily() {
		return this.idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public int getIdReceipt() {
		return this.idReceipt;
	}

	public void setIdReceipt(int idReceipt) {
		this.idReceipt = idReceipt;
	}

	public float getOwned() {
		return this.owned;
	}

	public void setOwned(float owned) {
		this.owned = owned;
	}

	public float getPriceAim() {
		return this.priceAim;
	}

	public void setPriceAim(float priceAim) {
		this.priceAim = priceAim;
	}

	public String getTextAim() {
		return this.textAim;
	}

	public void setTextAim(String textAim) {
		this.textAim = textAim;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}