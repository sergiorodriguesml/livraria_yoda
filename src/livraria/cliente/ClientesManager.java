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
				System.out.println(cs[0]+"#"+cs[1]+"#"+cs[2]+"#"+cs[3]);
				cliente.setCpf(cs[0]);
				cliente.setNome(cs[1]);
				cliente.setDtNascimento(cs[2]);
				cliente.setEndereco(cs[3]);
				clientes.put(cs[0], cliente);
				c = bufferReader.readLine();			
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
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
			System.out.println("::::: Clientes Salvos ::::");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printClientes(){
		HashMap<String, Cliente> clientes = loadClientes();
		if(clientes == null){
			System.out.println("::::: Não há Clientes cadastrados :::::");
		}
		else{
			for (String cpf : clientes.keySet()) {
				System.out.print("::: "+cpf+" :::");
				Cliente cliente = clientes.get(cpf);
				System.out.println(cliente.toString());
			}
		}
	}
	
	public Boolean addCliente(Cliente cliente){
		HashMap<String, Cliente> clientes = loadClientes();
		if(clientes == null){
			HashMap<String, Cliente> clientes2 = loadClientes();
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
	public Boolean rmCliente(Cliente cliente){
		HashMap<String, Cliente> clientes = loadClientes();
		if(cliente == null || !clientes.containsKey(cliente.getCpf())){
			return false;
		}else{
			clientes.remove(cliente.getCpf());
			saveClientes(clientes);
			return true;
		}
	}
}
