
public class ItensDePedido {

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
}
