package br.ufpb.sistemapedidos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Este comtole de pedidos implementa a interface sistema de controle
 * dos pedidos.
 *
 * @author Rozimar.
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List <Pedido> pedidos;

	public ControleDePedidos(){
		/**
		 * O metodo controle de pedidos cria uma lista de pedido dos clientes
		 * */
		this.pedidos = new ArrayList<Pedido>();
	}

	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		/**
		 * O metodo controle de pedidos do cliente recebe o nome do cliente
		 * compara o nome recebido com cada nome existente nalista e a comula 
		 * essa informacao em uma variavel depois retorna essa informacao. 
		 * 
		 * */
		int cont = 0;
		for (Pedido p: this.pedidos){
			if (p.getCliente().getNome().equals(nomeCliente)){
				cont++;
			}
		}
		return cont;
	}

	@Override
	public void adicionaPedido(Pedido p) {
		/**
		 * O metodo adiciona pedido pega cada pedido passado como 
		 * parametro e adicina na lista 
		 * */
		
		this.pedidos.add(p);

	}

	@Override
	public List<Pedido> pesquisaPedidosIncluindoProduto(
			long codProduto) {
		/**
		 * O metodo pesquisa pedido incluindo produto recebe uma codigo de um
		 * produto como parametro e pesquisa na lista de pedidos os pedidos que tenha
		 * produtos que tenham codigo igual ao passado como parametro.    
		 * */
		List <Pedido> pedidosProcurados = new LinkedList<Pedido>();
		for (Pedido p: this.pedidos){
			List<ItemDePedido> itens = p.getItens();
			for (ItemDePedido it: itens){
				if (it.getCodProduto()==codProduto){
					pedidosProcurados.add(p);
				}
			}
		}
		//TODO: ajeitar para verificar itens repetidos
		return pedidosProcurados;
	}

	@Override
	public void removerPedido(long numPedido) {
		/**
		 * O metodo remover pedido recebe um numero de um pedido 
		 * a ser remvido como parametro e compara esse numero com os 
		 * numeros existentes na lista e depois remove.   
		 * */
		for (Pedido p: this.pedidos){
			if (p.getNumeroDePedido()== numPedido){
				this.pedidos.remove(p);
				break;
			}
		}
	}
}