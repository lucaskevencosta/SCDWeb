/**
 * 
 */
package br.com.SCDWeb.model.equipamento;

import java.io.Serializable;
import java.util.Date;

import br.com.SCDWeb.model.categoria.Categoria;

/**
 * @author Leonardo
 *
 */
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer referencia;
	private String produto;
	private Date dataDeCompra;
	private Date dataDeVenda;
	private Double valorDeCompra;
	private double valorDeVenda;
	private Integer turnoDeTrabalho;
	private String estadoDoProduto;
	private Integer depreciacao;
	private Double valorResidual = null;
	private Categoria categoria = new Categoria();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getReferencia() {
		return referencia;
	}
	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Date getDataDeCompra() {
		return dataDeCompra;
	}
	public void setDataDeCompra(Date dataDeCompra) {
		this.dataDeCompra = dataDeCompra;
	}
	public Date getDataDeVenda() {
		return dataDeVenda;
	}
	public void setDataDeVenda(Date dataDeVenda) {
		this.dataDeVenda = dataDeVenda;
	}
	public Double getValorDeCompra() {
		return valorDeCompra;
	}
	public void setValorDeCompra(Double valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}
	
	public Integer getTurnoDeTrabalho() {
		return turnoDeTrabalho;
	}
	public void setTurnoDeTrabalho(Integer turnoDeTrabalho) {
		this.turnoDeTrabalho = turnoDeTrabalho;
	}
	public String getEstadoDoProduto() {
		return estadoDoProduto;
	}
	public void setEstadoDoProduto(String estadoDoProduto) {
		this.estadoDoProduto = estadoDoProduto;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getDepreciacao() {
		return depreciacao;
	}
	public void setDepreciacao(Integer depreciacao) {
		this.depreciacao = depreciacao;
	}
	public double getValorDeVenda() {
		return valorDeVenda;
	}
	public void setValorDeVenda(double valorDeVenda) {
		this.valorDeVenda = valorDeVenda;
	}
	public Double getValorResidual() {
		return valorResidual;
	}
	public void setValorResidual(Double valorResidual) {
		this.valorResidual = valorResidual;
	}
}
