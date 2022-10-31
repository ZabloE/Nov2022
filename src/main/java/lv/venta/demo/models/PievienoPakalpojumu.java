package lv.venta.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "pievienoPakalpojumu" )
@Setter
@Getter
@ToString
@Data
public class PievienoPakalpojumu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="id_pievieno")
	private Long id_pievieno;
	
	@Column(name="name")
	private String name;
	
	@Column(name="time")
	private double laiks;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="id_uznemums")
	private Uznemums uznemums;


	public PievienoPakalpojumu(String name, double laiks) {
		super();
		this.name = name;
		this.laiks = laiks;
		
	}


	public PievienoPakalpojumu() {
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getLaiks() {
		return laiks;
	}


	public void setLaiks(double laiks) {
		this.laiks = laiks;
	}
	
	
	
	
	
}
