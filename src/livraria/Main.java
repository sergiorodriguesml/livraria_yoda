package livraria;

import livraria.livro.*;

import java.io.Console;
import java.util.Scanner;

import livraria.cliente.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Livro livro;
		Livros livros = new Livros();
		int opcao;
		
//		livro1.setID(1);
//		livro1.setNome("livro1");
//		livro1.setQuantidade(10);
//		livro1.setCategoria(Livro.Tipo.AVENTURA);
//		livro1.setValor(100);
//		
//		livro2.setID(2);
//		livro2.setNome("livro2");
//		livro2.setQuantidade(10);
//		livro2.setCategoria(Livro.Tipo.COMEDIA);
//		livro2.setValor(150);
//		
//		livros.addLivro(livro1);
//		livros.addLivro(livro2);
//		livros.rmLivro(1);
//		livros.loadLivros();
//		System.out.println(livros.toString());
		
		for(int i = 0;i<100;i++) System.out.println();
		System.out.print("::::: Livraria do Yoda :::::\n"
						+":: Bem Vindo ::\n"
						+"1 - Estoque de Livros\n"
						+"2 - Adicionar Livro\n"
						+"3 - Vender Livro\n"
						+"4 - Adicionar Cliente\n"
						+"5 - Remover Cliente\n"
						+"6 - Ver Clientes\n"
						+"\n:: Para Sair digite um número que não esteja no menu ::\n");
		System.out.print("\nDigite uma Opção numérica: ");
		opcao = sc.nextInt();
		switch(opcao){
		case 1:
			livros.getLivros();
			System.out.println(livros.toString());
			System.out.println("terminou");
			break;
		case 2:
			System.out.println();
			livro = new Livro();
			System.out.println("Digite um nome: ");			
			livro.setNome(sc.next());
			System.out.println("Digite o preço: ");
			livro.setValor(sc.nextDouble());
			System.out.println("Digite a quantidade: ");
			livro.setQuantidade(sc.nextInt());
			System.out.println("Digite a categoria (0 -> Aventura, 1 -> Comédia , 2 -> Drama)");
			opcao = sc.nextInt();
			switch(opcao){
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
				break;
			}
			System.out.println("Digite um ID: ");
			livro.setID(sc.nextInt());
			System.out.println(livro.toString());
			livros.addLivro(livro);
			livros.getLivros();
			System.out.println(livros.toString());
			main(args);
			
			break;
		case 3:
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
