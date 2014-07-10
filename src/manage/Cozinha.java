/**
 * File:Cozinha.java
 */
package manage;

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
	
	//Entrada de dados
	private static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Cadastra um novo produto no restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos a inserir
	 * 
	 * @return true se a operacao foi realizada com sucesso. false caso o produto
	 * a adicionar já exista.
	 */
	public static boolean cadastrarProduto(List<ItemDoRestaurante> listaDeProdutosCadastrados) {

		// TODO Substituir pela janela de cadastro de produtos

		System.out.println("Codigo do produto: ");
		int codigo = entrada.nextInt();
		System.out.println("Descricao do produto: ");
		String descricao = entrada.next();
		System.out.println("Preco unitario: ");
		double precoUnitario = Double.parseDouble(entrada.next());
		Produto novoProduto = new Produto(codigo, descricao, precoUnitario);
		if(!listaDeProdutosCadastrados.contains(novoProduto)){
			listaDeProdutosCadastrados.add(novoProduto);
			return true;
		}
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

		// TODO Substituir pela janela de edição de produtos

		System.out.println("Codigo do produto: ");
		int codigo = entrada.nextInt();
		System.out.println("Nova descricao do produto: ");
		String novaDescricao = entrada.next();
		System.out.println("Novo preco unitario: ");
		double novoPreco = Double.parseDouble(entrada.next());
		Produto novoProduto = new Produto(codigo, novaDescricao, novoPreco);
		if(listaDeProdutosCadastrados.contains(novoProduto)){
			listaDeProdutosCadastrados.set(listaDeProdutosCadastrados.indexOf(novoProduto), novoProduto);
			return true;
		}
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

		// TODO Substituir pela janela de remoção de produtos

		System.out.println("Codigo do produto: ");
		int codigo = entrada.nextInt();
		Produto produto = new Produto(codigo, "", 0.0);
		if(listaDeProdutosCadastrados.contains(produto)){
			listaDeProdutosCadastrados.remove(produto);
			return true;
		}
		return false;
	}

	/**
	 * Lista todos os produtos disponiveis no restaurante.
	 * 
	 * @param listaDeProdutosCadastrados
	 */
	public static void listarProdutos(List<ItemDoRestaurante> listaDeProdutosCadastrados){

		// TODO Substituir pela janela de listagem de produtos

		if(listaDeProdutosCadastrados.size() > 0){
			Iterator<ItemDoRestaurante> iterador = listaDeProdutosCadastrados.iterator();
			Produto produto = null;
			while(iterador.hasNext()){
				produto = (Produto) iterador.next();
				System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + ": R$ " + produto.getPreco());
			}
		}
	}

}
