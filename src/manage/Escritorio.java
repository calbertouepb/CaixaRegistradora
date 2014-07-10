/**
 * File:Escritorio.java
 */
package manage;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import util.Garcon;
import util.ItemDoRestaurante;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Responsavel por gerenciar os funcionarios do restaurante.
 * 
 * @author carlos
 *
 */
public class Escritorio {

	//Entrada de dados
	private static Scanner entrada = new Scanner(System.in);

	/**
	 * Cadastra um garcon no restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garcons do restaurante
	 * 
	 * @return true caso a operacao seja realizada com sucesso. false caso o novo
	 * garcon a adicionar ja exista.
	 */
	public static boolean cadastrarGarcon(List<ItemDoRestaurante> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de cadastro de garcons

		System.out.println("Codigo do garcon: ");
		int codigo = entrada.nextInt();
		System.out.println("Nome do garcon: ");
		String nome = entrada.next();
		Garcon novoGarcon = new Garcon(codigo, nome);
		if(!listaDeGarconsDoRestaurante.contains(novoGarcon)){
			listaDeGarconsDoRestaurante.add(novoGarcon);
			return true;
		}
		return false;
	}

	/**
	 * Edita as informacoes de um garcon do restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garcons do restaurante
	 * 
	 * @return true caso a operacao seja realizada com sucesso. false caso o
	 * garcon a editar nao exista.
	 */
	public static boolean editarGarcon(List<ItemDoRestaurante> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de edicao de garcons

		System.out.println("Codigo do garcon: ");
		int codigo = entrada.nextInt();
		Garcon garcon = new Garcon(codigo,"");
		if(listaDeGarconsDoRestaurante.contains(garcon)){
			System.out.println("Novo nome do garcon: ");
			String novoNome = entrada.next();
			garcon = new Garcon(codigo, novoNome);
			listaDeGarconsDoRestaurante.set(listaDeGarconsDoRestaurante.indexOf(garcon), garcon);
			return true;
		}
		return false;
	}

	/**
	 * Remove um garcon do restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garcons do restaurante
	 * 
	 * @return true se a operacao foi realizada com sucesso. false caso o garcon
	 * a remover nao exista.
	 */
	public static boolean excluirGarcon(List<ItemDoRestaurante> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de remocao de garcons

		System.out.println("Codigo do garcon: ");
		int codigo = entrada.nextInt();
		Garcon garcon = new Garcon(codigo, "");
		if(listaDeGarconsDoRestaurante.contains(garcon)){
			listaDeGarconsDoRestaurante.remove(garcon);
			return true;
		}
		return false;
	}

	/**
	 * Lista todos os garcons do restaurante
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garcons do restaurante
	 */
	public static void listarGarcons(List<ItemDoRestaurante> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de listagem de garcons

		if(listaDeGarconsDoRestaurante.size() > 0){
			Iterator<ItemDoRestaurante> iterador = listaDeGarconsDoRestaurante.iterator();
			Garcon garcon = null;
			while(iterador.hasNext()){
				garcon = (Garcon) iterador.next();
				System.out.println(garcon.getCodigo() + " - " + garcon.getNome());
			}
		}
	}

}
