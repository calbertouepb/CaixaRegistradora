/**
 * Pacote de classes gerenciais
 */
package manage;

import java.util.Scanner;

import util.Garcon;
import util.Produto;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Gerente que controla o caixa do restaurante.
 * 
 * @author carlos
 *
 */
public class GerenteCaixa {

	public static void main(String[] args){
		Produto[] listaDeProdutosCadastrados = null;
		Garcon[] listaDeGarconsDoRestaurante = null;
		final String PROMPT_GERAL = "Caixa de Restaurante\n"
				+ "1 - Gerenciar produtos;\n2 - Gerenciar garçons;\n"
				+ "3 - Abrir Caixa;\n4 - Movimentar Caixa;\n5 - Balanço;\n"
				+ "6 - Relatórios;\n7 - Sair.\nOpção desejada: ";
		final String PROMPT_OPCAO_1 = "Gerenciar produto\n1 - Cadastrar produto;\n"
				+ "2 - Editar produto;\n3 - Excluir produto;\nOpção desejada: ";
		final String PROMPT_OPCAO_2 = "Gerenciar garçons\n1 - Cadastrar garçon;\n"
				+ "2 - Editar garçon;\n3 - Excluir garçon;\nOpção desejada: ";
		Scanner entrada = new Scanner(System.in);
		System.out.println(PROMPT_GERAL);
		int opcao = entrada.nextInt();
		while(opcao != 7){
			switch(opcao){
			case 1:
				System.out.println(PROMPT_OPCAO_1);
				int opcao1 = entrada.nextInt();
				switch(opcao1){
				case 1:
					Cozinha.cadastrarProduto(listaDeProdutosCadastrados);
					break;
				case 2:
					Cozinha.editarProduto(listaDeProdutosCadastrados);
					break;
				case 3:
					Cozinha.excluirProduto(listaDeProdutosCadastrados);
					break;
				default:
					System.out.println("Opção inválida.");
				}
				break;
			case 2:
				System.out.println(PROMPT_OPCAO_2);
				int opcao2 = entrada.nextInt();
				switch(opcao2){
				case 1:
					Escritorio.cadastrarGarcon(listaDeGarconsDoRestaurante);
					break;
				case 2:
					Escritorio.editarGarcon(listaDeGarconsDoRestaurante);
					break;
				case 3:
					Escritorio.excluirGarcon(listaDeGarconsDoRestaurante);
					break;
				default:
					System.out.println("Opção inválida.");
				}
				break;
			}
		}
		entrada.close();
	}
}
