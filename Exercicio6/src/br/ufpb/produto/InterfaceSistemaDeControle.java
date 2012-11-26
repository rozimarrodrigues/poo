package br.ufpb.produto;
import java.util.List;


/** 
 *Esta interface define as operacoes de um sistema de gerenciamento de pedidos.
 *
 * @author Rozimar 
 */
public interface InterfaceSistemaDeControle 
{
 /**
  * Adiciona um novo pedido
  * @param p Pedido 
  * 
  * */
	public void adicionaPedido(Pedido p);
	
	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto);
	
	public void removerPedido(long numPedido);
}
