package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the receipts database table.
 * 
 */
@Entity
@Table(name="receipts")
@NamedQuery(name="Receipt.findAll", query="SELECT r FROM Receipt r")
public class Receipt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_receipt")
	private int idReceipt;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="id_aim")
	private int idAim;

	@Column(name="id_family")
	private int idFamily;

	private float receipt;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	public Receipt() {
	}

	public int getIdReceipt() {
		return this.idReceipt;
	}

	public void setIdReceipt(int idReceipt) {
		this.idReceipt = idReceipt;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public float getReceipt() {
		return this.receipt;
	}

	public void setReceipt(float receipt) {
		this.receipt = receipt;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}