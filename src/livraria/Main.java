package livraria;

import livraria.livro.*;

import java.io.Console;
import java.util.HashMap;
import java.util.Scanner;

import livraria.cliente.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Livro livro;
		HashMap<Integer, Livro> livros;
		Livros manager = new Livros();
		int opcao;
		// for(int i = 0;i<20;i++) System.out.println();
		System.out.println("\n");
		System.out.print("::::: Livraria do Yoda :::::\n" + ":: Bem Vindo ::\n" + "1 - Estoque de Livros\n"
				+ "2 - Adicionar Livro\n" + "3 - Vender Livro\n" + "4 - Adicionar Cliente\n" + "5 - Remover Cliente\n"
				+ "6 - Ver Clientes\n" + "\n:: Para Sair digite um número que não esteja no menu ::\n");
		System.out.println("Digite uma Opção numérica: ");
		opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("::::: Livros Cadastrados :::::");
			manager.printLivros();
			System.out.println("::::::::::::::::::::::::::::::");
			main(args);
			break;
		case 2:
			livro = new Livro();
			System.out.println("Digite um nome: ");
			sc.nextLine();
			livro.setNome(sc.nextLine());
			System.out.println("Digite o preço: ");
			livro.setValor(sc.nextDouble());
			System.out.println("Digite a quantidade: ");
			livro.setQuantidade(sc.nextInt());
			System.out.println("Digite a categoria (0 -> Aventura, 1 -> Comédia , 2 -> Drama): ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 0:
				livro.setCategoria(Livro.Tipo.AVENTURA);
				break;
			case 1:
				livro.setCategoria(Livro.Tipo.COMEDIA);
				break;
			case 2:
				livro.setCategoria(Livro.Tipo.DRAMA);
				break;
			default:
				System.out.println("Opção Inválida");
				main(args);
				break;
			}
			System.out.println("Digite um ID: ");
			livro.setID(sc.nextInt());
			while (!manager.addLivro(livro)) {
				System.out.print("\nID Inválido, digite um outro ID: ");
				livro.setID(sc.nextInt());
			}
			System.out.println(livro.toString());
			main(args);
			break;
		case 3:
			System.out.println("Digite o ID do livro: ");
			int id = sc.nextInt();
			if (manager.loadLivros().containsKey(id)) {
				System.out.println("Digite a quantidade: ");
				int qtd = sc.nextInt();
				if (manager.venderLivro(id, qtd)) {
					System.out.println("Livro vendido com sucesso");
				} else {
					System.out.println("\nNão foi possível vender o Livro, quantidade inválida");
				}
			}else{
				System.out.println("\n::::: ID inválido :::::");
			}
			main(args);
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			System.out.println("Obrigado, volte sempre!");
			break;
		}

	}

}
