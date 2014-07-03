/**
 * Pacote de classes gerenciais
 */
package manage;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import util.Produto;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Responsável por gerenciar os produtos disponíveis no restaurante.
 * 
 * @author carlos
 *
 */
public class Cozinha {
	private static Scanner entrada = new Scanner(System.in);
	/**
	 * Cadastra um novo produto no restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos a inserir
	 */
	public static void cadastrarProduto(List<Produto> listaDeProdutosCadastrados) {

		// TODO Substituir pela janela de cadastro de produtos

		System.out.println("Código do produto: ");
		int codigo = entrada.nextInt();
		System.out.println("Descrição do produto: ");
		String descricao = entrada.next();
		System.out.println("Preço unitário: ");
		double precoUnitario = Double.parseDouble(entrada.next());
		listaDeProdutosCadastrados.add(new Produto(codigo, descricao, precoUnitario));
	}

	/**
	 * Edita as informações de um produto do restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos cadastrados
	 */
	public static void editarProduto(List<Produto> listaDeProdutosCadastrados) {

		// TODO Substituir pela janela de edição de produtos

		System.out.println("Código do produto: ");
		int codigo = entrada.nextInt();
		System.out.println("Nova descrição do produto: ");
		String novaDescricao = entrada.next();
		System.out.println("Novo preço unitário: ");
		double novoPreco = Double.parseDouble(entrada.next());
		Produto novoProduto = new Produto(codigo, novaDescricao, novoPreco);
		if(listaDeProdutosCadastrados.contains(novoProduto)){
			listaDeProdutosCadastrados.set(listaDeProdutosCadastrados.indexOf(novoProduto), novoProduto);
		}
		else{
			System.out.println("Produto não cadastrado.");
		}
	}

	/**
	 * Remove um produto do restaurante.
	 * 
	 * @param listaDeProdutosCadastrados A lista de produtos cadastrados
	 */
	public static void excluirProduto(List<Produto> listaDeProdutosCadastrados) {

		// TODO Substituir pela janela de remoção de produtos

		System.out.println("Código do produto: ");
		int codigo = entrada.nextInt();
		Produto produto = new Produto(codigo, "", 0.0);
		if(listaDeProdutosCadastrados.contains(produto)){
			listaDeProdutosCadastrados.remove(produto);
		}
		else{
			System.out.println("Produto não cadastrado.");
		}
	}

	/**
	 * Lista todos os produtos disponíveis no restaurante.
	 * 
	 * @param listaDeProdutosCadastrados
	 */
	public static void listarProdutos(List<Produto> listaDeProdutosCadastrados){

		// TODO Substituir pela janela de listagem de produtos

		if(listaDeProdutosCadastrados.size() > 0){
			Iterator<Produto> iterador = listaDeProdutosCadastrados.iterator();
			Produto produto = null;
			while(iterador.hasNext()){
				produto = iterador.next();
				System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + ": R$ " + produto.getPreco());
			}
		}
		else
			System.out.println("Não há produtos a exibir.");
	}

}
