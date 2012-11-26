package br.ufpb.produto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class GravadorDePedidos {

	public void gravaPedidos(List<Pedido> pedidos) throws IOException{
		
		ObjectOutputStream oos = null;
		
		try{ // tenta executar as linhas que ele possui
			
			FileOutputStream re = new FileOutputStream("Pedidos.txt"); //manda criar o arquivo
			oos = new ObjectOutputStream(re); // abri o caminho p gravar o arquivo
			oos.writeObject(pedidos); // mandar gravar
		
		}catch(FileNotFoundException erro){ // captura o erro
			throw new IOException("Não foi encontrado o arquivo pedidos.txt"); //informa q n encontrou o arquivo
			
		}
		catch(IOException error){
			throw error;
			
		}
		finally{
			if(oos!=null)
				oos.close();
		}
		
	}
	
	public List<Pedido>lePedidos()throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("Pedidos.txt")); // encontrar o arquivo
			return(List<Pedido>) in.readObject(); // ler o arquivo encontrado
		
		}catch(FileNotFoundException erro){ // captura o erro
			throw new IOException("Não foi encontrado o arquivo pedidos.txt"); //informa q n encontrou o arquivo
		
		}
		catch(IOException error){
			throw error;		
		}
		catch(ClassNotFoundException erro){ // captura o erro
			throw new IOException("Não conseguiu ler.txt"); //informa q n conseguiu ler
		
		}
		finally{
			if(in!=null)
				in.close();
		}
	
	}
}
