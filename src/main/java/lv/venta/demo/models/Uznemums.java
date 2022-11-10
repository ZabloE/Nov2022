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
	@JoinColumn(name="idUser", referencedColumnName = "idUser",insertable = false, updatable = false)
	private User user;
	
	
	
	@OneToMany(mappedBy="uznemums",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	private Collection<PievienoPakalpojumu>pievienoPakalpojumu = new ArrayList<PievienoPakalpojumu>();


	private Long idUser;
	

	

	

	@Override
	public String toString() {
		return "Uznemums [id_uznemums=" + id_uznemums + ", name=" + name + ", adrese=" + adrese + ", user=" + user
				+  "]";
	}

	public Uznemums(String name, String adrese, Long id) {
		super();
		this.name = name;
		this.adrese = adrese;
		this.id_uznemums = id;
		
		
	}

	public Uznemums() {
	
	}
	


	

	public Long getId_uznemums() {
		return id_uznemums;
	}

	public void setId_uznemums(Long id_uznemums) {
		this.id_uznemums = id_uznemums;
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
	
	public Long getIdUser()
	{
		return getIdUser();
	}
	
	public void setIdUser(Long idUser)
	{
		
		this.idUser = idUser;
	}
	
	
	
}
