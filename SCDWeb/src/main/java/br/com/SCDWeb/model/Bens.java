package br.com.SCDWeb.model;

import java.io.Serializable;
import java.util.Date;

public class Bens implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer referenciaProduto;
	private String produto;
	private Date data_de_compra;
	private Date data_de_venda;
	private Double valor_da_compra;
	private Double valor_da_venda;
	private Integer turno_de_trabalho;
	private String tipo_de_produto;
	private Integer anos_depreciacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReferenciaProduto() {
		return referenciaProduto;
	}
	public void setReferenciaProduto(Integer referenciaProduto) {
		this.referenciaProduto = referenciaProduto;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Date getData_de_compra() {
		return data_de_compra;
	}
	public void setData_de_compra(Date data_de_compra) {
		this.data_de_compra = data_de_compra;
	}
	public Date getData_de_venda() {
		return data_de_venda;
	}
	public void setData_de_venda(Date data_de_venda) {
		this.data_de_venda = data_de_venda;
	}
	public Double getValor_da_compra() {
		return valor_da_compra;
	}
	public void setValor_da_compra(Double valor_da_compra) {
		this.valor_da_compra = valor_da_compra;
	}
	public Double getValor_da_venda() {
		return valor_da_venda;
	}
	public void setValor_da_venda(Double valor_da_venda) {
		this.valor_da_venda = valor_da_venda;
	}
	public Integer getTurno_de_trabalho() {
		return turno_de_trabalho;
	}
	public void setTurno_de_trabalho(Integer turno_de_trabalho) {
		this.turno_de_trabalho = turno_de_trabalho;
	}
	public String getTipo_de_produto() {
		return tipo_de_produto;
	}
	public void setTipo_de_produto(String tipo_de_produto) {
		this.tipo_de_produto = tipo_de_produto;
	}
	public Integer getAnos_depreciacao() {
		return anos_depreciacao;
	}
	public void setAnos_depreciacao(Integer anos_depreciacao) {
		this.anos_depreciacao = anos_depreciacao;
	}
}
