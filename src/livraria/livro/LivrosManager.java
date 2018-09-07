package livraria.livro;

import java.util.HashMap;

import javax.sound.midi.Synthesizer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LivrosManager{

	private FileInputStream fileIn;
	private ObjectInputStream in;
	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	
	public HashMap<Integer, Livro> loadLivros(){
		HashMap<Integer, Livro> livros = new HashMap<>();
		try {
			
			fileIn = new FileInputStream("livros.ser");
			in = new ObjectInputStream(fileIn);
			livros = (HashMap<Integer, Livro>) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(livros.isEmpty()){
			return null;
		}
		else{
			return livros;
		}
	}
	
	public void saveLivros(HashMap<Integer, Livro> livros){
		try {
			fileOut = new FileOutputStream("livros.ser");
			out = new ObjectOutputStream(fileOut);
			out.writeObject(livros);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public Boolean addLivro(Livro livro){
		HashMap<Integer, Livro> livros = loadLivros();
		if(livros == null){
			HashMap<Integer, Livro> livros2 = new HashMap<>();
			livros2.put(livro.getID(), livro);
			saveLivros(livros2);
			return true;
		}
		else{
			if(!livros.containsKey(livro.getID())){
				livros.put(livro.getID(), livro);
				saveLivros(livros);
				return true;
			}		
		}
		return false;		
	}

	public Boolean venderLivro(int id,int qtd){
		HashMap<Integer, Livro> livros = loadLivros();
		int quantidade = livros.get(id).getQuantidade() ;		
		if(quantidade > qtd){
			livros.get(id).setQuantidade(quantidade-qtd);
			saveLivros(livros);
			return true;
		}else if(quantidade - qtd == 0){
			livros.remove(id);
			saveLivros(livros);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void printLivros(){
		HashMap<Integer, Livro> livros = loadLivros();
		if(livros == null){
			System.out.println("::::: Não há livros cadastrados :::::");
		}
		else{
			System.out.println("::::: Livros Cadastrados :::::");
			for (Integer id : livros.keySet()) {
				Livro livro = livros.get(id);
				System.out.println(livro.toString());
			}
			System.out.println("::::::::::::::::::::::::::::::");
		}
	}
		
}
