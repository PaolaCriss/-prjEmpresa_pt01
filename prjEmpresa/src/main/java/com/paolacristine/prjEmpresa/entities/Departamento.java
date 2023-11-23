package com.paolacristine.prjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@TableGenerator(name = "tb_departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long depcodigo;

	@NotNull
	@NotBlank
	private String depnome;
	
	public Departamento() {

	}
	
	public Departamento(Long depcodigo, String depnome) {
		super();
		this.depcodigo = depcodigo;
		this.depnome = depnome;
	}

	public long getDepcodigo() {
		return depcodigo;
	}

	public void setDepcodigo(Long depcodigo) {
		this.depcodigo = depcodigo;
	}

	public String getDepnome() {
		return depnome;
	}

	public void setDepnome(String depnome) {
		this.depnome = depnome;
	}

	
	
}
