package br.ufpb.agenda;

import java.util.Collection;
import java.util.Iterator;

public interface AgendaIF {
	
	public void adicionarContato(String nome, String telefone);
	
	public boolean removerContato(String nomeContato) throws ContatoInexistenteException; 
	
	public Contato pesquisarContato(String nomeContato) throws ContatoInexistenteException;
	
	public Collection<Contato> getContato();
	
	public Iterator <Contato> getContatoOrdenados();
	
}
