/**
 * Pacote de classes gerenciais
 */
package manage;

import java.util.ArrayList;
import java.util.List;
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

	// Total de dinheiro disponível no Caixa.
	static double dinheiroEmCaixa = 0.0;
	
	// Estado do Caixa.
	static boolean caixaAberto = false;

	public static void main(String[] args){

		// Variáveis do programa
		List<Produto> listaDeProdutosCadastrados = new ArrayList<Produto>();
		List<Garcon> listaDeGarconsDoRestaurante = new ArrayList<Garcon>();
		final String PROMPT_GERAL = "\n"
				+ "Caixa de Restaurante\n"
				+ "|_ 1 - Gerenciar produtos;\n"
				+ "|_ 2 - Gerenciar garçons;\n"
				+ "|_ 3 - Abrir Caixa;\n"
				+ "|_ 4 - Movimentar Caixa;\n"
				+ "|_ 5 - Balanço;\n"
				+ "|_ 6 - Relatórios;\n"
				+ "|_ 7 - Fechar Caixa e Sair.\n"
				+ "Opção desejada: ";
		final String PROMPT_OPCAO_1 = "\n"
				+ "Gerenciar produto\n"
				+ "|_ 1 - Cadastrar produto;\n"
				+ "|_ 2 - Editar produto;\n"
				+ "|_ 3 - Excluir produto;\n"
				+ "|_ 4 - Voltar.\n"
				+ "Opção desejada: ";
		final String PROMPT_OPCAO_2 = "\n"
				+ "Gerenciar garçons\n"
				+ "|_ 1 - Cadastrar garçon;\n"
				+ "|_ 2 - Editar garçon;\n"
				+ "|_ 3 - Excluir garçon;\n"
				+ "|_ 4 - Voltar.\n"
				+ "Opção desejada: ";
		final String PROMPT_OPCAO_6 = "\n"
				+ "Relatórios\n"
				+ "|_ 1 - Listar produtos;\n"
				+ "|_ 2 - Listar Garçons;\n"
				+ "|_ 3 - Produtos mais/menos consumidos;\n"
				+ "|_ 4 - Gorjetas acumuladas;\n"
				+ "|_ 5 - Voltar.\n"
				+ "Opção desejada: ";
		Scanner entrada = new Scanner(System.in);

		// Menu principal
		System.out.println(PROMPT_GERAL);
		int opcao = entrada.nextInt();

		// Execução do programa
		while(opcao != 7){
			switch(opcao){
			case 1: // Gerenciar produtos
				
				// TODO Menu da janela
				
				// Submenu 1
				System.out.println(PROMPT_OPCAO_1);
				int opcao1 = entrada.nextInt();
				// Execução submenu 1
				while(opcao1 != 4){
					switch(opcao1){
					case 1: // Cadastrar
						Cozinha.cadastrarProduto(listaDeProdutosCadastrados);
						break;
					case 2: // Editar
						Cozinha.editarProduto(listaDeProdutosCadastrados);
						break;
					case 3: // Excluir
						Cozinha.excluirProduto(listaDeProdutosCadastrados);
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}// fim do switch
					System.out.println(PROMPT_OPCAO_1);
					opcao1 = entrada.nextInt();
				}// fim do while
				break;
			case 2: // Gerenciar garçons
				
				// TODO Menu da janela
				
				// Submenu 2
				System.out.println(PROMPT_OPCAO_2);
				int opcao2 = entrada.nextInt();
				// Execução submenu 2
				while(opcao2 != 4){
					switch(opcao2){
					case 1: // Cadastrar
						Escritorio.cadastrarGarcon(listaDeGarconsDoRestaurante);
						break;
					case 2: // Editar
						Escritorio.editarGarcon(listaDeGarconsDoRestaurante);
						break;
					case 3: // Excluir
						Escritorio.excluirGarcon(listaDeGarconsDoRestaurante);
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}// fim do switch
					System.out.println(PROMPT_OPCAO_2);
					opcao2 = entrada.nextInt();
				}// fim do while
				break;
			case 3: // Abrir caixa
				
				// TODO Substituir pela janela de abertura de caixa

				boolean sucesso = false;
				while(!sucesso){
					System.out.println("Abrindo Caixa...");
					System.out.println("Digite a quantidade de dinheiro no Caixa: ");
					double dinheiro = Double.parseDouble(entrada.next());
					if(dinheiro > 0.0){
						dinheiroEmCaixa = dinheiro;
						caixaAberto = true;
						sucesso = true;
					}
				}
				break;
			case 4: // Movimentar caixa
				
				// TODO Substituir pela janela de movimentação de caixa
				
				if(caixaAberto){
					// 
				}
				else
					System.out.println("Caixa fechado. Abra o Caixa antes de movimentá-lo.");
				break;
			case 5: // Balanço
				// TODO
				break;
			case 6: // Relatórios
				// Submenu 6
				System.out.println(PROMPT_OPCAO_6);
				int opcao6 = entrada.nextInt();
				// Execução do submenu 6
				while(opcao6 != 5){
					switch(opcao6){
					case 1: // Listar produtos
						Cozinha.listarProdutos(listaDeProdutosCadastrados);
						break;
					case 2: // Listar garçons
						Escritorio.listarGarcons(listaDeGarconsDoRestaurante);
						break;
					case 3: // Produtos mais/menos consumidos
						// TODO
						break;
					case 4: // Gorjetas acumuladas
						
						// TODO Substituir pela janela de gorjeta acumulada
						
						System.out.println("Código do garçon: ");
						int codigo = entrada.nextInt();
						Garcon garcon = new Garcon(codigo, "");
						if(listaDeGarconsDoRestaurante.contains(garcon)){
							garcon = listaDeGarconsDoRestaurante.get(listaDeGarconsDoRestaurante.indexOf(garcon));
							System.out.println(garcon.getCodigo() + " - " + garcon.getNome() + "\n"
									+ "Total de gorjetas acumuladas: " + garcon.getGorjeta());
						}
						else
							System.out.println("Código não existe.");
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}// fim do switch
					System.out.println(PROMPT_OPCAO_6);
					opcao6 = entrada.nextInt();
				}// fim do while
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}// fim do switch
			System.out.println(PROMPT_GERAL);
			opcao = entrada.nextInt();
		}// fim do while
		
		// TODO Fechar Caixa e sair.
		entrada.close();
	}
}
