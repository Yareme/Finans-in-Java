package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	private float balance;

	@Lob
	private String email;

	private String login;

	private String name;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="when_created")
	private Date whenCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="when_modified")
	private Date whenModified;

	@Column(name="who_create")
	private int whoCreate;

	@Column(name="who_update")
	private int whoUpdate;

	//bi-directional many-to-one association to Aim
	@OneToMany(mappedBy="user")
	private List<Aim> aims;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="user")
	private List<Category> categories;

	//bi-directional many-to-one association to Expens
	@OneToMany(mappedBy="user")
	private List<Expens> expenses;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="user")
	private List<Income> incomes;

	//bi-directional many-to-one association to Receipt
	@OneToMany(mappedBy="user")
	private List<Receipt> receipts;

	//bi-directional many-to-one association to Family
	@ManyToOne
	@JoinColumn(name="id_family")
	private Family family;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getWhenCreated() {
		return this.whenCreated;
	}

	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}

	public Date getWhenModified() {
		return this.whenModified;
	}

	public void setWhenModified(Date whenModified) {
		this.whenModified = whenModified;
	}

	public int getWhoCreate() {
		return this.whoCreate;
	}

	public void setWhoCreate(int whoCreate) {
		this.whoCreate = whoCreate;
	}

	public int getWhoUpdate() {
		return this.whoUpdate;
	}

	public void setWhoUpdate(int whoUpdate) {
		this.whoUpdate = whoUpdate;
	}

	public List<Aim> getAims() {
		return this.aims;
	}

	public void setAims(List<Aim> aims) {
		this.aims = aims;
	}

	public Aim addAim(Aim aim) {
		getAims().add(aim);
		aim.setUser(this);

		return aim;
	}

	public Aim removeAim(Aim aim) {
		getAims().remove(aim);
		aim.setUser(null);

		return aim;
	}

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setUser(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setUser(null);

		return category;
	}

	public List<Expens> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expens> expenses) {
		this.expenses = expenses;
	}

	public Expens addExpens(Expens expens) {
		getExpenses().add(expens);
		expens.setUser(this);

		return expens;
	}

	public Expens removeExpens(Expens expens) {
		getExpenses().remove(expens);
		expens.setUser(null);

		return expens;
	}

	public List<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public Income addIncome(Income income) {
		getIncomes().add(income);
		income.setUser(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setUser(null);

		return income;
	}

	public List<Receipt> getReceipts() {
		return this.receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}

	public Receipt addReceipt(Receipt receipt) {
		getReceipts().add(receipt);
		receipt.setUser(this);

		return receipt;
	}

	public Receipt removeReceipt(Receipt receipt) {
		getReceipts().remove(receipt);
		receipt.setUser(null);

		return receipt;
	}

	public Family getFamily() {
		return this.family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}