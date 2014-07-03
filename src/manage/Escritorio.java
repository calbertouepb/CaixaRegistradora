/**
 * Pacote de classes gerenciais
 */
package manage;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import util.Garcon;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Responsável por gerenciar os funcionários do restaurante.
 * @author carlos
 *
 */
public class Escritorio {
	private static Scanner entrada = new Scanner(System.in);

	/**
	 * Cadastra um garçon no restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garçons do restaurante
	 */
	public static void cadastrarGarcon(List<Garcon> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de cadastro de garçons

		System.out.println("Código do garçon: ");
		int codigo = entrada.nextInt();
		System.out.println("Nome do garçon: ");
		String nome = entrada.next();
		listaDeGarconsDoRestaurante.add(new Garcon(codigo, nome));
	}
	
	
	/**
	 * Edita as informações de um garçon do restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garçons do restaurante
	 */
	public static void editarGarcon(List<Garcon> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de edição de garçons

		System.out.println("Código do garçon: ");
		int codigo = entrada.nextInt();
		System.out.println("Novo nome do garçon: ");
		String novoNome = entrada.next();
		Garcon garcon = new Garcon(codigo, novoNome);
		if(listaDeGarconsDoRestaurante.contains(garcon)){
			listaDeGarconsDoRestaurante.set(listaDeGarconsDoRestaurante.indexOf(garcon), garcon);
		}
		else{
			System.out.println("Garçon não cadastrado.");
		}
	}
	
	/**
	 * Remove um garçon do restaurante.
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garçons do restaurante
	 */
	public static void excluirGarcon(List<Garcon> listaDeGarconsDoRestaurante) {

		// TODO Substituir pela janela de remoção de garçons

		System.out.println("Código do garçon: ");
		int codigo = entrada.nextInt();
		Garcon garcon = new Garcon(codigo, "");
		if(listaDeGarconsDoRestaurante.contains(garcon)){
			listaDeGarconsDoRestaurante.remove(garcon);
		}
		else{
			System.out.println("Garçon não cadastrado.");
		}
	}

	/**
	 * Lista todos os garçons do restaurante
	 * 
	 * @param listaDeGarconsDoRestaurante A lista de garçons do restaurante
	 */
	public static void listarGarcons(List<Garcon> listaDeGarconsDoRestaurante) {
		
		// TODO Substituir pela janela de listagem de garçons
		
		if(listaDeGarconsDoRestaurante.size() > 0){
			Iterator<Garcon> iterador = listaDeGarconsDoRestaurante.iterator();
			Garcon garcon = null;
			while(iterador.hasNext()){
				garcon = iterador.next();
				System.out.println(garcon.getCodigo() + " - " + garcon.getNome());
			}
		}
		else
			System.out.println("Não há garçons cadastrados.");
		
	}

}
