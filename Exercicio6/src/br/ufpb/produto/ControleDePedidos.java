package br.ufpb.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Este comtole de pedidos implementa a interface sistema de controle
 * dos pedidos.
 *
 * @author Rozimar
 */
public class ControleDePedidos implements InterfaceSistemaDeControle{

	List<Pedido> pedidos  = new ArrayList<Pedido>();;
	private GravadorDePedidos gravadorDePedidos = new GravadorDePedidos();

	/**
	 * O metodo controle de pedidos cria uma lista de pedido dos clientes
	 * */
	public ControleDePedidos(){
		try {
			pedidos = gravadorDePedidos.lePedidos();
		} catch (IOException e) {				
			e.printStackTrace();
		}	
	}

	/**
	 * O metodo controle de pedidos do cliente recebe o nome do cliente
	 * compara o nome recebido com cada nome existente nalista e a comula 
	 * essa informacao em uma variavel depois retorna essa informacao. 
	 * 
	 * */
	public int calculaQuantidaDeDePedidosDoCliente(String nomeCliente){
		int quantidadeDePedidosDoCliente = 0;
		for (Pedido p : pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				quantidadeDePedidosDoCliente ++;
			}
		}
		return quantidadeDePedidosDoCliente;
	}

	/**
	 * O metodo adiciona pedido pega cada pedido passado como 
	 * parametro e adicina na lista 
	 * */
	@Override
	public void adicionaPedido(Pedido p){
		pedidos.add(p);
		gravarLista();

	} 

	/**
	 * O metodo pesquisa pedido incluindo produto recebe uma codigo de um
	 * produto como parametro e pesquisa na lista de pedidos os pedidos que tenha
	 * produtos que tenham codigo igual ao passado como parametro.    
	 * */
	@Override
	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto){
		
		List<Pedido> p = new ArrayList<Pedido>();
		for (Pedido c : pedidos) {
			for (ItensDePedido itensPedido : c.getItens()) {
				if(itensPedido.getCodProduto()==codProduto){
					p.add(c);
				}
			}
		}
		return p;
	}

	/**
	 * O metodo remover pedido recebe um numero de um pedido 
	 * a ser remvido como parametro e compara esse numero com os 
	 * numeros existentes na lista e depois remove.   
	 * */
	@Override
	public void removerPedido(long numPedido) {
		for (Pedido p : this.pedidos) {
			for (ItensDePedido item : p.getItens()) {
				if(item.getCodProduto()==numPedido){
					this.pedidos.remove(p);
					JOptionPane.showMessageDialog(null, "pedido excluído");
					break;
				}
			}
		}
		this.gravarLista(); // grava a lista sem o item que foi removido
	}

	private void gravarLista() {
		try {
			gravadorDePedidos.gravaPedidos(pedidos);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



	public static void main(String[] args) {

		ControleDePedidos control = new ControleDePedidos();
		ItensDePedido item;

		Pedido p1 = new Pedido(1);
		Pedido p2 = new Pedido(2);

		String nome = JOptionPane.showInputDialog("Nome:");
		p1.getCliente().setNome(nome);
		p2.getCliente().setNome(nome);

		item = new ItensDePedido(1,0,1.50);

		p1.adicionaIten(item); //adicionando um ItemDePedido na lista de ItemDePedido
		p1.setNumeroDePedido(1);
		control.adicionaPedido(p1);

		item = new ItensDePedido(2,1,2.50);

		p2.adicionaIten(item); //adicionando um ItemDePedido na lista de ItemDePedido
		p2.setNumeroDePedido(2);
		control.adicionaPedido(p2);

		if(control.calculaQuantidaDeDePedidosDoCliente(nome)==2)
		{
			JOptionPane.showMessageDialog(null, "Programa correto");
		}else{
			JOptionPane.showMessageDialog(null, "Programa incorreto");
		}
	}
}
