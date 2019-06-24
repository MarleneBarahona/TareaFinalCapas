package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="sucursal")
public class Sucursal {

	@Id
	@GeneratedValue(generator="sucursal_codigo_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sucursal_codigo_seq",sequenceName="public.sucursal_codigo_seq",allocationSize = 1)
	@Column(name="codigo")
	private Integer cSucursal;
	
	@Column(name="nombre")
	private String sNombre;
	
	@Column(name="ubicacion")
	private String sUbicacion;
	
	@Column(name="horarios")
	private String sHorarios;
	
	@Column(name="nmesas")
	private Integer sNmesas;
	
	@Column(name="nomgerente")
	private String sNomGerente;
	
	//@OneToMany(mappedBy="sucursal",cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE},fetch=FetchType.EAGER)
	//private List<Empleado> empleados;

	public Sucursal(Integer cSucursal, String sNombre, String sUbicacion, String sHorarios, Integer sNmesas,
			String sNomGerente) {
		super();
		this.cSucursal = cSucursal;
		this.sNombre = sNombre;
		this.sUbicacion = sUbicacion;
		this.sHorarios = sHorarios;
		this.sNmesas = sNmesas;
		this.sNomGerente = sNomGerente;
	}

	public Sucursal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getcSucursal() {
		return cSucursal;
	}

	public void setcSucursal(Integer cSucursal) {
		this.cSucursal = cSucursal;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsUbicacion() {
		return sUbicacion;
	}

	public void setsUbicacion(String sUbicacion) {
		this.sUbicacion = sUbicacion;
	}

	public String getsHorarios() {
		return sHorarios;
	}

	public void setsHorarios(String sHorarios) {
		this.sHorarios = sHorarios;
	}

	public Integer getsNmesas() {
		return sNmesas;
	}

	public void setsNmesas(Integer sNmesas) {
		this.sNmesas = sNmesas;
	}

	public String getsNomGerente() {
		return sNomGerente;
	}

	public void setsNomGerente(String sNomGerente) {
		this.sNomGerente = sNomGerente;
	}

	/*public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}*/
	
	
}
