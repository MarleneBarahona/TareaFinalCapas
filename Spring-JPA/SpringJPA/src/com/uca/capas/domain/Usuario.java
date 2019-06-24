package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public",name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(generator="usuario_id_usuario_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="usuario_id_usuario_seq",sequenceName="public.usuario_id_usuario_seq",allocationSize = 1)
	@Column(name="id_usuario")
	private Integer cUsuario;
	
	@Column(name="usuario")
	private String uUsuario;
	
	@Column(name="clave")
	private String uClave;

	public Usuario(Integer cUsuario, String uUsuario, String uClave) {
		super();
		this.cUsuario = cUsuario;
		this.uUsuario = uUsuario;
		this.uClave = uClave;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}

	public String getuUsuario() {
		return uUsuario;
	}

	public void setuUsuario(String uUsuario) {
		this.uUsuario = uUsuario;
	}

	public String getuClave() {
		return uClave;
	}

	public void setuClave(String uClave) {
		this.uClave = uClave;
	}
	
}
