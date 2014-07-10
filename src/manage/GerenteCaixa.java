/**
 * File:Gerente.java
 */
package manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import arquivos.ManipulaArquivo;
import util.Garcon;
import util.ItemDoRestaurante;
import util.Produto;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Gerente que controla o caixa do restaurante.
 * 
 * @author carlos
 *
 */
public class GerenteCaixa {

	// Total de dinheiro disponivel no Caixa.
	static double dinheiroEmCaixa = 0.0;
	
	// Estado do Caixa.
	static boolean caixaAberto = false;

	public static void main(String[] args){

		// Variaveis do programa
		ManipulaArquivo arquivador = new ManipulaArquivo();
		List<ItemDoRestaurante> listaDeProdutosCadastrados = arquivador.carregaListaDeProdutos();
		List<ItemDoRestaurante> listaDeGarconsDoRestaurante = arquivador.carregaListaDeGarcons();
		
		final String PROMPT_GERAL = "\n"
				+ "Caixa de Restaurante\n"
				+ "|_ 1 - Gerenciar produtos;\n"
				+ "|_ 2 - Gerenciar garcons;\n"
				+ "|_ 3 - Abrir Caixa;\n"
				+ "|_ 4 - Movimentar Caixa;\n"
				+ "|_ 5 - Balanco;\n"
				+ "|_ 6 - Relatorios;\n"
				+ "|_ 7 - Fechar Caixa e Sair.\n"
				+ "Opcao desejada: ";
		final String PROMPT_OPCAO_1 = "\n"
				+ "Gerenciar produto\n"
				+ "|_ 1 - Cadastrar produto;\n"
				+ "|_ 2 - Editar produto;\n"
				+ "|_ 3 - Excluir produto;\n"
				+ "|_ 4 - Voltar.\n"
				+ "Opcao desejada: ";
		final String PROMPT_OPCAO_2 = "\n"
				+ "Gerenciar garcons\n"
				+ "|_ 1 - Cadastrar garcon;\n"
				+ "|_ 2 - Editar garcon;\n"
				+ "|_ 3 - Excluir garcon;\n"
				+ "|_ 4 - Voltar.\n"
				+ "Opcao desejada: ";
		final String PROMPT_OPCAO_6 = "\n"
				+ "Relatorios\n"
				+ "|_ 1 - Listar produtos;\n"
				+ "|_ 2 - Listar Garcons;\n"
				+ "|_ 3 - Produtos mais/menos consumidos;\n"
				+ "|_ 4 - Gorjetas acumuladas;\n"
				+ "|_ 5 - Voltar.\n"
				+ "Opcao desejada: ";
		Scanner entrada = new Scanner(System.in);

		// Menu principal
		System.out.println(PROMPT_GERAL);
		int opcao = entrada.nextInt();

		// Execucao do programa
		while(opcao != 7){
			switch(opcao){
			case 1: // Gerenciar produtos
				
				// TODO Menu da janela
				
				// Submenu 1
				System.out.println(PROMPT_OPCAO_1);
				int opcao1 = entrada.nextInt();
				// Execucao submenu 1
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
						System.out.println("Opcao invalida.");
						break;
					}// fim do switch
					System.out.println(PROMPT_OPCAO_1);
					opcao1 = entrada.nextInt();
				}// fim do while
				break;
			case 2: // Gerenciar garcons
				
				// TODO Menu da janela
				
				// Submenu 2
				System.out.println(PROMPT_OPCAO_2);
				int opcao2 = entrada.nextInt();
				// Execucao submenu 2
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
						System.out.println("Opcao invalida.");
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
					System.out.println("Caixa fechado. Abra o Caixa antes de movimenta-lo.");
				break;
			case 5: // Balanço
				// TODO
				break;
			case 6: // Relatorios
				// Submenu 6
				System.out.println(PROMPT_OPCAO_6);
				int opcao6 = entrada.nextInt();
				// Execucao do submenu 6
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
						
						System.out.println("Codigo do garcon: ");
						int codigo = entrada.nextInt();
						ItemDoRestaurante garcon = new Garcon(codigo, "");
						if(listaDeGarconsDoRestaurante.contains(garcon)){
							garcon = listaDeGarconsDoRestaurante.get(listaDeGarconsDoRestaurante.indexOf(garcon));
							System.out.println(((Garcon) garcon).getCodigo() + " - " + ((Garcon) garcon).getNome() + "\n"
									+ "Total de gorjetas acumuladas: " + ((Garcon) garcon).getGorjeta());
						}
						else
							System.out.println("Codigo nao existe.");
						break;
					default:
						System.out.println("Opcao invalida.");
						break;
					}// fim do switch
					System.out.println(PROMPT_OPCAO_6);
					opcao6 = entrada.nextInt();
				}// fim do while
				break;
			default:
				System.out.println("Opcao invalida.");
				break;
			}// fim do switch
			System.out.println(PROMPT_GERAL);
			opcao = entrada.nextInt();
		}// fim do while
		
		// TODO Fechar Caixa e sair.
		arquivador.salvaLista(listaDeProdutosCadastrados);
		arquivador.salvaLista(listaDeGarconsDoRestaurante);
		entrada.close();
	}
}
