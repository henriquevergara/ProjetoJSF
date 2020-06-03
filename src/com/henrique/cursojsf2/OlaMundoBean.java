package com.henrique.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void maisculo() {
		this.setNome(this.nome.toUpperCase());
	}

}
