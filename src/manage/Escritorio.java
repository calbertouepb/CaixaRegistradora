/**
 * File:Escritorio.java
 */
package manage;

import java.util.ArrayList;
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

	// Scanner de entrada de dados
	private static Scanner entradaInteiro = new Scanner(System.in);
	private static Scanner entradaTexto = new Scanner(System.in);
	
	public static List<Integer> garconsCadastrados = new ArrayList<Integer>();

	/**
	 * Cadastra um garcon no restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garcons do restaurante
	 * 
	 * @return true caso a operacao seja realizada com sucesso. false caso o novo
	 * garcon a adicionar ja exista.
	 */
	public static boolean cadastrarGarcon(List<ItemDoRestaurante> listaDeGarconsDoRestaurante) {

		System.out.println("Codigo do garcon: ");
		int codigo = entradaInteiro.nextInt();
		System.out.println("Nome do garcon: ");
		String nome = entradaTexto.nextLine();
		Garcon novoGarcon = new Garcon(codigo, nome);
		if(!listaDeGarconsDoRestaurante.contains(novoGarcon)){
			listaDeGarconsDoRestaurante.add(novoGarcon);
			garconsCadastrados.add(codigo);
			return true;
		}
		System.out.println("Ja existe garcon cadastrado com esse codigo.");
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

		System.out.println("Codigo do garcon: ");
		int codigo = entradaInteiro.nextInt();
		Garcon garcon = new Garcon(codigo,"");
		if(listaDeGarconsDoRestaurante.contains(garcon)){
			System.out.println("Novo nome do garcon: ");
			String novoNome = entradaTexto.nextLine();
			garcon = new Garcon(codigo, novoNome);
			listaDeGarconsDoRestaurante.set(listaDeGarconsDoRestaurante.indexOf(garcon), garcon);
			return true;
		}
		System.out.println("Nao existe garcon cadastrado com esse codigo.");
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

		System.out.println("Codigo do garcon: ");
		int codigo = entradaInteiro.nextInt();
		Garcon garcon = new Garcon(codigo, "");
		if(listaDeGarconsDoRestaurante.contains(garcon)){
			listaDeGarconsDoRestaurante.remove(garcon);
			garconsCadastrados.remove(codigo);
			return true;
		}
		System.out.println("Nao existe garcon cadastrado com esse codigo.");
		return false;
	}

	/**
	 * Lista todos os garcons do restaurante
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garcons do restaurante
	 */
	public static void listarGarcons(List<ItemDoRestaurante> listaDeGarconsDoRestaurante) {

		if(listaDeGarconsDoRestaurante.size() > 0){
			Iterator<ItemDoRestaurante> iterador = listaDeGarconsDoRestaurante.iterator();
			Garcon garcon = null;
			while(iterador.hasNext()){
				garcon = (Garcon) iterador.next();
				System.out.printf("%03d - %s%n", garcon.getCodigo(), garcon.getNome());
			}
		}
		else
			System.out.println("Nao existem garcons a serem exibidos.");
	}
}
