package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private int idCategory;

	@Lob
	@Column(name="category_name")
	private String categoryName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to Expens
	@OneToMany(mappedBy="category")
	private List<Expens> expenses;

	//bi-directional many-to-one association to Income
	@OneToMany(mappedBy="category")
	private List<Income> incomes;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Expens> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expens> expenses) {
		this.expenses = expenses;
	}

	public Expens addExpens(Expens expens) {
		getExpenses().add(expens);
		expens.setCategory(this);

		return expens;
	}

	public Expens removeExpens(Expens expens) {
		getExpenses().remove(expens);
		expens.setCategory(null);

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
		income.setCategory(this);

		return income;
	}

	public Income removeIncome(Income income) {
		getIncomes().remove(income);
		income.setCategory(null);

		return income;
	}

}