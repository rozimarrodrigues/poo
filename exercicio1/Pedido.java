import java.util.ArrayList;
import java.util.List;


public class Pedido {

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

	public void setItens(List<ItensDePedido> itens) {
		this.itens = itens;
	}
}
