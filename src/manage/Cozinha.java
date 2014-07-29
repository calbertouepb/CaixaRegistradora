/**
 * File:Cozinha.java
 */
package manage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import util.ItemDoRestaurante;
import util.Produto;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Responsavel por gerenciar os produtos disponiveis no restaurante.
 * 
 * @author carlos
 *
 */
public class Cozinha {
	
	// Scanners de entrada de dados
	private static Scanner entradaInteiro = new Scanner(System.in);
	private static Scanner entradaTexto = new Scanner(System.in);
	private static Scanner entradaDouble = new Scanner(System.in);
	
	public static List<Integer> produtosCadastrados = new ArrayList<Integer>();
	
	/**
	 * Cadastra um novo produto no restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos a inserir
	 * 
	 * @return true se a operacao foi realizada com sucesso. false caso o produto
	 * a adicionar já exista.
	 */
	public static boolean cadastrarProduto(List<ItemDoRestaurante> listaDeProdutosCadastrados) {
		
		System.out.println("Codigo do produto: ");
		int codigo = entradaInteiro.nextInt();
		System.out.println("Descricao do produto: ");
		String descricao = entradaTexto.nextLine();
		System.out.println("Preco unitario: ");
		double precoUnitario = entradaDouble.nextDouble();
		Produto novoProduto = new Produto(codigo, descricao, precoUnitario);
		if(!listaDeProdutosCadastrados.contains(novoProduto)){
			listaDeProdutosCadastrados.add(novoProduto);
			produtosCadastrados.add(codigo);
			return true;
		}
		System.out.println("Ja existe produto cadastrado com esse codigo.");
		return false;
	}

	/**
	 * Edita as informacoes de um produto do restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos cadastrados
	 * 
	 * @return true caso a operacao foi realizada com sucesso. false caso o
	 * produto a editar nao exista.
	 */
	public static boolean editarProduto(List<ItemDoRestaurante> listaDeProdutosCadastrados) {

		System.out.println("Codigo do produto: ");
		int codigo = entradaInteiro.nextInt();
		System.out.println("Nova descricao do produto: ");
		String novaDescricao = entradaTexto.nextLine();
		System.out.println("Novo preco unitario: ");
		double novoPreco = entradaDouble.nextDouble();
		Produto novoProduto = new Produto(codigo, novaDescricao, novoPreco);
		if(listaDeProdutosCadastrados.contains(novoProduto)){
			listaDeProdutosCadastrados.set(listaDeProdutosCadastrados.indexOf(novoProduto), novoProduto);
			return true;
		}
		System.out.println("Nao existe produto cadastrado com esse codigo.");
		return false;
	}

	/**
	 * Remove um produto do restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos cadastrados
	 * 
	 * @return true se a operacao foi realizada com sucesso. false caso o
	 * produto a remover nao exista.
	 */
	public static boolean excluirProduto(List<ItemDoRestaurante> listaDeProdutosCadastrados) {

		System.out.println("Codigo do produto: ");
		int codigo = entradaInteiro.nextInt();
		Produto produto = new Produto(codigo, "", 0.0);
		if(listaDeProdutosCadastrados.contains(produto)){
			listaDeProdutosCadastrados.remove(produto);
			produtosCadastrados.remove(codigo);
			return true;
		}
		System.out.println("Nao existe produto cadastrado com esse codigo.");
		return false;
	}

	/**
	 * Lista todos os produtos disponiveis no restaurante.
	 * 
	 * @param listaDeProdutosCadastrados
	 */
	public static void listarProdutos(List<ItemDoRestaurante> listaDeProdutosCadastrados){

		if(listaDeProdutosCadastrados.size() > 0){
			Iterator<ItemDoRestaurante> iterador = listaDeProdutosCadastrados.iterator();
			Produto produto = null;
			while(iterador.hasNext()){
				produto = (Produto) iterador.next();
				System.out.printf("%03d - %s: R$ %.2f%n", produto.getCodigo(), produto.getDescricao(), produto.getPreco());
			}
		}
		else
			System.out.println("Nao existem produtos a serem exibidos.");
	}
}
