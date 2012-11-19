package br.ufpb.exercicio5;

public class MeuPrograma {
	public static void main(String[] args) {
		
		Agenda agenda = new Agenda();
		
		agenda.adicionarContato("Maria","XXXX-XXXX");
		
		try{
			agenda.pesquisarContato("Maria");
			agenda.pesquisarContato("Maria Jos�");
		}catch(ContatoInexistenteException e){	
			System.err.println("O contato n�o existe na agenda: "+e);
		}
		
	}

}
