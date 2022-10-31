package lv.venta.demo.models;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "uznemums")
@Setter
@Getter
@ToString
@Data
public class Uznemums {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_uznemums")
	private Long id_uznemums;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="adrese")
	private String adrese;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idUser", referencedColumnName = "idUser")
	private User user;
	
	
	
	@OneToMany(mappedBy="id_pievieno")
	@ToString.Exclude
	private Collection<PievienoPakalpojumu>pievienoPakalpojumu = new ArrayList<PievienoPakalpojumu>();
	

	

	public Uznemums(String name, String adrese, User user) {
		super();
		this.name = name;
		this.adrese = adrese;
		setUser(user);
	}

	public Uznemums() {
	
	}
	
public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdrese() {
		return adrese;
	}

	public void setAdrese(String adrese) {
		this.adrese = adrese;
	}
	
	
	
	
	
}
