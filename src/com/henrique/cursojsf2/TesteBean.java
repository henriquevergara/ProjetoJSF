package com.henrique.cursojsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
public class TesteBean {

	private HtmlInputText input;
	private HtmlCommandButton botao;
	
	
	public void testar() {
		this.input.setDisabled(true);
		this.botao.setStyle("background-color:red; color:white");
	}
	
	public HtmlInputText getInput() {
		return input;
	}
	public void setInput(HtmlInputText input) {
		this.input = input;
	}
	public HtmlCommandButton getBotao() {
		return botao;
	}
	public void setBotao(HtmlCommandButton botao) {
		this.botao = botao;
	}
	
}
