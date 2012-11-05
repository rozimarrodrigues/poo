import java.util.List;


public interface InterfaceSistemaDeControle 
{
	public void adicionaPedido(Pedido p);
	
	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto);
	
	public void removerPedido(long numPedido);
}
