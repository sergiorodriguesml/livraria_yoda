package livraria.livro;

import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Livros{

	private HashMap<Integer, Livro> livros;
	private FileInputStream fileIn;
	private ObjectInputStream in;
	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	
	public HashMap<Integer, Livro> loadLivros(){
		HashMap<Integer, Livro> livros_ = new HashMap<>();
		try {
			
			fileIn = new FileInputStream("livros.ser");
			in = new ObjectInputStream(fileIn);
			livros_ = (HashMap<Integer, Livro>) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(livros_.isEmpty()){
			System.out.println("retornou nullo");
			return null;
		}
		else{
			System.out.println("retornou livros");
			return livros_;
		}
	}
	
	public void addLivro(Livro livro){
		this.livros = loadLivros();
		if(!livros.containsKey(livro.getID())){
			this.livros.put(livro.getID(), livro);
		}		
		try {
			fileOut = new FileOutputStream("livros.ser");
			out = new ObjectOutputStream(fileOut);
			out.writeObject(this.livros);
			out.close();
			fileOut.close();
			System.out.println(":::: Adicionado com Sucesso ::::");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void rmLivro(int id){
		this.livros = loadLivros();
		this.livros.remove(id);
		try {
			fileOut = new FileOutputStream("livros.ser");
			out = new ObjectOutputStream(fileOut);
			out.writeObject(this.livros);
			out.close();
			fileOut.close();
			System.out.println(":::: Removido com Sucesso ::::");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void getLivros(){
		/*try {
			
			fileIn = new FileInputStream("livros.ser");
			in = new ObjectInputStream(fileIn);
			livros = (HashMap<Integer, Livro>) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.livros = loadLivros();
	}

	@Override
	public String toString() {
		return "Livros [livros=" + livros + "]";
	}
	
	
	
	
}
