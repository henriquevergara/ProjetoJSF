package com.henrique.cursojsf2.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import com.henrique.cursojsf2.model.Produto;

@ManagedBean
@ApplicationScoped
public class GestaoProdutosBean implements Serializable {

	private static final long serialVersionUID = 8420319774242452876L;

	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();
	private List<Produto> produtosFiltrados = new ArrayList<>();
	private Produto produtoSelecionado;
	private String fabricantePesquisa;

	public String getFabricantePesquisa() {
		return fabricantePesquisa;
	}

	public void setFabricantePesquisa(String fabricantePesquisa) {
		this.fabricantePesquisa = fabricantePesquisa;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
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

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public void cadastrar() {
		produtos.add(produto);
		produto = new Produto();
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou Bean.");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando Bean.");
	}

	public String obterAjuda() {

		if (produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}

	}

	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
		this.produtosFiltrados.remove(this.produtoSelecionado);
	}

	public void verificarInclusao() {

		if (this.produto.getFabricante().isEmpty() && this.produto.getCategoria().isEmpty()) {
			this.produto.setFabricante("Sem fabricante.");
			this.produto.setCategoria("Sem categoria.");
		} else if (this.produto.getCategoria().isEmpty()) {
			this.produto.setCategoria("Sem categoria.");
		} else if (this.produto.getFabricante().isEmpty()) {
			this.produto.setFabricante("Sem fabricante.");
		}

	}
	
	public void pesquisar(ValueChangeEvent produtoPesquisado) {
		
		produtosFiltrados.clear();
		
		for (Produto produto : produtos) {
			if (produto.getNome()!= null && produto.getNome().toLowerCase().startsWith(produtoPesquisado.getNewValue().toString().toLowerCase())) {
				produtosFiltrados.add(produto);
			}
			
		}
		
	}

}
