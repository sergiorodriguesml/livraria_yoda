package livraria.cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import livraria.livro.Livro;


public class ClientesManager {
	private InputStream input;
	private InputStreamReader inputSR;
	private BufferedReader bufferReader;
	private OutputStream output;
	private OutputStreamWriter outputSW;
	private BufferedWriter bufferOut;

	public HashMap<String, Cliente> loadClientes(){
		HashMap<String, Cliente> clientes = new HashMap<>();
		Cliente cliente = new Cliente();
		try {
			input = new FileInputStream("clientes.csv");
			inputSR = new InputStreamReader(input);
			bufferReader = new BufferedReader(inputSR);
			String c = bufferReader.readLine();
			String cs [];
			while(c != null){
				cs = c.split(",");
				//System.out.println(cs[0]+"#"+cs[1]+"#"+cs[2]+"#"+cs[3]);
				cliente.setCpf(cs[0]);
				cliente.setNome(cs[1]);
				cliente.setDtNascimento(cs[2]);
				cliente.setEndereco(cs[3]);
				clientes.put(cliente.getCpf(), cliente);
				//System.out.println(clientes.keySet().toString());
				c = bufferReader.readLine();		
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(clientes.isEmpty()){
			return null;
		}
		else{
			return clientes;
		}
	}
	
	public void saveClientes(HashMap<String, Cliente> clientes){
		try {
			output = new FileOutputStream("clientes.csv");
			outputSW = new OutputStreamWriter(output);
			bufferOut = new BufferedWriter(outputSW);
			for(String cpf:clientes.keySet()){
				bufferOut.write(cpf+","
							+clientes.get(cpf).getNome()+","
							+clientes.get(cpf).getDtNascimento()+","
							+clientes.get(cpf).getEndereco()
							);
				bufferOut.newLine();
			}
			bufferOut.close();
			outputSW.close();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printClientes(){
//		HashMap<String, Cliente> clientes = loadClientes();
//		if(clientes == null){
//		}
//		else{
//			System.out.println("\n::::: Clientes Cadastrados :::::");
////			for (String cpf : clientes.keySet()) {
////				Cliente cliente = clientes.get(cpf);
////				//System.out.println(cliente.getCpf()+"--"+cliente.getNome());
////			}
//			Iterator it = clientes.entrySet().iterator();
//			for(Entry<String, Cliente> entrada:clientes.entrySet()){
//				System.out.println(entrada.getKey()+"--"+entrada.getValue());
//			}
//		}
		Cliente cliente = new Cliente();
		try {
			input = new FileInputStream("clientes.csv");
			inputSR = new InputStreamReader(input);
			bufferReader = new BufferedReader(inputSR);
			String c = bufferReader.readLine();
			String cs [];
			System.out.println("::::: Não há Clientes cadastrados :::::");
			while(c != null){
				cs = c.split(",");
				//System.out.println(cs[0]+"#"+cs[1]+"#"+cs[2]+"#"+cs[3]);
				cliente.setCpf(cs[0]);
				cliente.setNome(cs[1]);
				cliente.setDtNascimento(cs[2]);
				cliente.setEndereco(cs[3]);
				System.out.println(cliente.toString());
				c = bufferReader.readLine();		
			}
			System.out.println("::::::::::::::::::::::::::::::\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean addCliente(Cliente cliente){
		HashMap<String, Cliente> clientes = loadClientes();
		if(clientes == null){
			HashMap<String, Cliente> clientes2 = new HashMap<>();
			clientes2.put(cliente.getCpf(), cliente);
			saveClientes(clientes2);
			return true;
		}
		else{
			if(!clientes.containsKey(cliente.getCpf())){
				clientes.put(cliente.getCpf(), cliente);
				saveClientes(clientes);
				return true;
			}		
		}
		return false;
	}
	public Boolean rmCliente(String cpf){
		HashMap<String, Cliente> clientes = loadClientes();
		if(!clientes.containsKey(cpf)){
			return false;
		}else{
			String nome = clientes.get(cpf).getNome();
			clientes.remove(cpf);
			saveClientes(clientes);
			System.out.println("::::: Cliente "+nome+" removido com Sucesso :::::\n");
			return true;
		}
	}
}
