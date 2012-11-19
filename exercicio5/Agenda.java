package br.ufpb.exercicio5;

import java.util.ArrayList;
import java.util.List;

public class Agenda extends Contato implements AgendaIF {
	
	public List<Contato> contatos = new ArrayList <Contato>();

	@Override
	public void adicionarContato(String nome, String telefone) {
		Contato contato = new Contato(nome,telefone);
		contatos.add(contato);
	}

	@Override
	public boolean removerContato(String nomeContato) throws ContatoInexistenteException {
		boolean achou = false;
		for(Contato c:this.contatos){
			if(c.getNome().equals(nomeContato)){
				this.contatos.remove(c);
				achou = true;
				break;
			}else{
				throw new ContatoInexistenteException();
			}
		}
		return achou;	
	}

	@Override
	public Contato pesquisarContato(String nomeContato) throws ContatoInexistenteException {
		for(Contato c:this.contatos){
			if(c.getNome().equals(nomeContato)){
				return c;
			}
			throw new ContatoInexistenteException("A pessoa procurada não existe na agenda");
		}
		return null;
	}
}