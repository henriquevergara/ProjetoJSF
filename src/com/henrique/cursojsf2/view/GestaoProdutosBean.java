package com.henrique.cursojsf2.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.henrique.cursojsf2.model.Produto;

@ManagedBean
@SessionScoped
public class GestaoProdutosBean {

	
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	

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
	
	
	
}
