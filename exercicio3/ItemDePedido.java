package br.ufpb.exercicio3;

public class ItemDePedido {

	private int quantidade;
	private long codProduto;
	private double valorUnitario;
	
	public ItemDePedido(long codigo, int quant, double valor){
		this.quantidade = quant;
		this.codProduto = codigo;
		this.valorUnitario = valor;
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

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade(){
		return this.quantidade;
	}
	public void setQuantidade(int quant){
		this.quantidade = quant;
	}
	
	public double getSubTotal(){
		return this.valorUnitario*this.quantidade;
	}
}
