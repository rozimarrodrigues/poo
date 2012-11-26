package br.ufpb.produto;

import java.io.Serializable;

public class ItensDePedido implements Serializable{

	private int quantidade;
	private long codProduto;
	private double valorUnitario;
	
	public ItensDePedido(int quantidade, long codProduto,double valorUnitario) {
		this.quantidade = quantidade;
		this.codProduto = codProduto;
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValor(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@Override
	public String toString() {
		return "Itens\n" +
				"Codigo: " + this.getCodProduto() +"\n"+
				"Quantidade: " + this.getQuantidade() + "\n" +
				"Valor unitario: R$" + this.getValorUnitario();
	}
}
