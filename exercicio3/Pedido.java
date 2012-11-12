package br.ufpb.exercicio3;
import java.util.ArrayList;
import java.util.List;


public class Pedido {

	private long numeroDePedido;
	private Cliente cliente;
	private List<ItemDePedido> itens;
	
	public Pedido(long numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
		this.cliente = new Cliente("Fulano");
		this.itens = new ArrayList<ItemDePedido>();
	}

	public long getNumeroDePedido() {
		return numeroDePedido;
	}

	public void setNumeroDePedido(long numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemDePedido> getItens() {
		return itens;
	}

	public void adicionaItens(ItemDePedido itens) {
		this.itens.add(itens);
	}
}
