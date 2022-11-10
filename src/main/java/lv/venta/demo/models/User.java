package lv.venta.demo.models;




import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Setter
@Getter
@ToString
@Data
public class User {

	
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", password=" + password
				+ ", email=" + email + ", roles=" + roles + ", uznemums=" + uznemums + "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idUser")
	private Long idUser;
	
	
	@Column(name="name")
	private String name;
	

	@Column(name="surname")
	private String surname;
	

	@Column(name="password")
	private String password;
	

	@Column(nullable = false, unique = true)
	private String email;
	


	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "idUser", referencedColumnName = "idUser"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	private Collection<Role>roles;
	
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	private Collection<Uznemums>uznemums = new ArrayList<Uznemums>();


public User() 
	{
		
	}
	

	public User(String name, String surname,  String password,String email, Collection<Role> roles) {
		super();

		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}



	public Long getIdUser() {
		return idUser;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	


	
}

