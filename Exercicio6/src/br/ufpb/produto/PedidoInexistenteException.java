package br.ufpb.produto;

public class PedidoInexistenteException extends Exception{

	public PedidoInexistenteException(){
		super("Erro: Contato inexistente!!!");
	}
	
	public PedidoInexistenteException(String msg) {
		super(msg);
	}
	
}
