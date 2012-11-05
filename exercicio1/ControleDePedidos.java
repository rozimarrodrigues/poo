import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ControleDePedidos implements InterfaceSistemaDeControle{
	
	List<Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public int calculaQuantidaDeDePedidosDoCliente(String nomeCliente){
		int quantidadeDePedidosDoCliente = 0;
		for (Pedido p : pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				//quantidadeDePedidosDoCliente = p.getItens().size();
				quantidadeDePedidosDoCliente ++;
				//break;
			}
		}
		return quantidadeDePedidosDoCliente;
	}

	@Override
	public void adicionaPedido(Pedido p) {
		pedidos.add(p);
		
	} 

	@Override
	public List<Pedido> pesquisaPedidosIncluindoProduto(long codProduto) {
		List<Pedido> p = new ArrayList<Pedido>();
		for (Pedido pedido : pedidos) {
			for (ItensDePedido itensPedido : pedido.getItens()) {
				if(itensPedido.getCodProduto()==codProduto){
					p.add(pedido);
				}
			}
		}
		return p;
	}

	@Override
	public void removerPedido(long numPedido) {
		int indice = 0;
		for (Pedido p : pedidos) {
			if(p.getNumeroDePedido()==numPedido){
				break;
			}
			indice = indice + 1;
		}
		pedidos.remove(indice);
	}
	
	public static void main(String[] args) {
		
		ControleDePedidos control = new ControleDePedidos();
		ItensDePedido item;
		List<ItensDePedido> listaDeItens = new ArrayList<ItensDePedido>();
		Pedido p1 = new Pedido(1);
		Pedido p2 = new Pedido(2);
		
		String nome = JOptionPane.showInputDialog("Nome:");
		p1.getCliente().setNome(nome);
		p2.getCliente().setNome(nome);
		
		item = new ItensDePedido(1,0,1.50);
		
		listaDeItens.add(item);//adicionando um ItemDePedido na lista de ItemDePedido
		
		p1.setItens(listaDeItens);
		p1.setNumeroDePedido(1);
		control.adicionaPedido(p1);
		
		item = new ItensDePedido(2,1,2.50);
		
		listaDeItens.add(item);//adicionando um ItemDePedido na lista de ItemDePedido
		
		p2.setItens(listaDeItens);
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
 