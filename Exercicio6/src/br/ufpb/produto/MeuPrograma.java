package br.ufpb.produto;

import java.util.List;

import javax.swing.JOptionPane;

public class MeuPrograma {

	public static void main(String args[]) throws PedidoInexistenteException {
		ControleDePedidos controleDePedidos = new ControleDePedidos();
		ItensDePedido item;
		Pedido p = new Pedido(1000);
		int op = 0;
		while (true) {
			op = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1- gravar pedido\n 2- remover\n 3- pesquisar\n 4-sair"));
			switch (op) {
			case 1: // gravar contato
				int quantidade = Integer.parseInt(
						JOptionPane.showInputDialog(null,"digite a quantidade"));
				long codProduto = Long.parseLong(JOptionPane
						.showInputDialog(null, "digite o nome do produto"));
				double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog(null,
						"Digite o valor unitário"));

				item = new ItensDePedido(quantidade, codProduto, valorUnitario);

				p.adicionaIten(item);

				controleDePedidos.adicionaPedido(p);
				break;

			case 2: // excluir pedido
				int remover = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Digite o codigo"));
				controleDePedidos.removerPedido(remover);
				break;

			case 3: // ler pedido
				long codProduto1 = Long.parseLong(JOptionPane.showInputDialog(null,
						"Digite o codigo"));
				List<Pedido> p1 = controleDePedidos.pesquisaPedidosIncluindoProduto(codProduto1);
				JOptionPane.showMessageDialog(null, p1.toString());
				break;

			case 4:
				System.exit(0);
			}
		}
	}

}
