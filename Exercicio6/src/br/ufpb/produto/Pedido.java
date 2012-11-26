package br.ufpb.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{

	private long numeroDePedido;
	private Cliente cliente;
	private List<ItensDePedido> itens;
	
	public Pedido(long numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
		this.cliente = new Cliente("Fulano");
		this.itens = new ArrayList<ItensDePedido>();
	}

	public long getNumeroDePedido() {
		return this.numeroDePedido;
	}

	public void setNumeroDePedido(long numeroDePedido) {
		this.numeroDePedido = numeroDePedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItensDePedido> getItens() {
		return this.itens;
	}

	public void adicionaIten(ItensDePedido item) {
		this.itens.add(item);
	}

	@Override
	public String toString() {
		String itens = "";
		for (ItensDePedido it : this.getItens()) {
			itens += it.toString()+"\n"; 
		}
		return "Pedido\n" +
				"Numero de Pedido: " + this.getNumeroDePedido() + 
				"\n" + this.getCliente().toString() + 
				"\nItens: " + itens;
	}
}
