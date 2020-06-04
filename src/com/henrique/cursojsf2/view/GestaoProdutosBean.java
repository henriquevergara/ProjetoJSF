package com.henrique.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.henrique.cursojsf2.model.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutosBean implements Serializable {
	
	private static final long serialVersionUID = 8420319774242452876L;
	
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou Bean.");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando Bean.");
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void cadastrar() {
		produtos.add(produto);
		produto = new Produto();
	}
	
	public String obterAjuda() {
		
		if (produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		}else {
		    return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
		
	}
	
	
	
}
