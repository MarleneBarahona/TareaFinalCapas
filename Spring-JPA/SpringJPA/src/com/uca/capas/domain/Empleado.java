package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="empleado")
public class Empleado {

	@Id
	@GeneratedValue(generator="empleado_codigo_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="empleado_codigo_seq",sequenceName="public.empleado_codigo_seq",allocationSize = 1)
	@Column(name="codigo")
	private Integer cEmpleado;
	
	@Column(name="nombre")
	private String eNombre;
	
	@Column(name="edad")
	private Integer eEdad;
	
	@Column(name="genero")
	private String eGenero;
	
	@Column(name="estado")
	private boolean eEstado;
	
	@Column(name="f_sucursal")
	private Integer cSucursal;

	public Empleado(Integer cEmpleado, String eNombre, Integer eEdad, String eGenero, boolean eEstado,
			Integer cSucursal) {
		super();
		this.cEmpleado = cEmpleado;
		this.eNombre = eNombre;
		this.eEdad = eEdad;
		this.eGenero = eGenero;
		this.eEstado = eEstado;
		this.cSucursal = cSucursal;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getcEmpleado() {
		return cEmpleado;
	}

	public void setcEmpleado(Integer cEmpleado) {
		this.cEmpleado = cEmpleado;
	}

	public String geteNombre() {
		return eNombre;
	}

	public void seteNombre(String eNombre) {
		this.eNombre = eNombre;
	}

	public Integer geteEdad() {
		return eEdad;
	}

	public void seteEdad(Integer eEdad) {
		this.eEdad = eEdad;
	}

	public String geteGenero() {
		return eGenero;
	}

	public void seteGenero(String eGenero) {
		this.eGenero = eGenero;
	}

	public boolean iseEstado() {
		return eEstado;
	}

	public void seteEstado(boolean eEstado) {
		this.eEstado = eEstado;
	}

	public Integer getcSucursal() {
		return cSucursal;
	}

	public void setcSucursal(Integer cSucursal) {
		this.cSucursal = cSucursal;
	}
	
}
