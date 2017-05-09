package bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.*;

@Entity
@Table (name="USERS")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id_user")
	private int id;
	@Column (name="firstName_user", nullable = true, length = 100)
	private String firstName;
	@Column (name="lastName_user", nullable = true, length = 100)
	private String lastName;
	@Column (name="email_user", nullable=true, length = 150)
	private String email;
	@Column(name="login", nullable=true, length=10)
	private String login;
	@Column (name="password_user", nullable=true, length=10)
	private String password;
	@Column (name="isAdmin_user")
	boolean isAdmin;

	@OneToMany(mappedBy="user")
	private Set<OrderHeader> orderHeader;

	public User(){
		
	}
	public User(int id, String firstName, String lastName, String email, String login, String password,
			boolean isAdmin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Set<OrderHeader> getOrderHeader() {
		return orderHeader;
	}
	public void setOrderHeader(Set<OrderHeader> orderHeader) {
		this.orderHeader = orderHeader;
	}

	

}