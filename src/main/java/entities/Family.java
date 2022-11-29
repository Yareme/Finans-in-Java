package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the family database table.
 * 
 */
@Entity
@NamedQuery(name="Family.findAll", query="SELECT f FROM Family f")
public class Family implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_family")
	private int idFamily;

	@Column(name="invite_code")
	private int inviteCode;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="family")
	private List<User> users;

	public Family() {
	}

	public int getIdFamily() {
		return this.idFamily;
	}

	public void setIdFamily(int idFamily) {
		this.idFamily = idFamily;
	}

	public int getInviteCode() {
		return this.inviteCode;
	}

	public void setInviteCode(int inviteCode) {
		this.inviteCode = inviteCode;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setFamily(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setFamily(null);

		return user;
	}

}