package arquivos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import manage.Cozinha;
import manage.Escritorio;
import util.Garcon;
import util.ItemDoRestaurante;
import util.Produto;

/**
 * Salva e recupera as informacoes persistentes do programa em arquivos de texto.
 * 
 * @author Talles Henrique
 *
 */
public class ManipulaArquivo implements Arquivavel{

	private String arquivoGarcon = "Garcons.txt";
	private String arquivoProduto = "Produto.txt";
	
	File fileGarcon = new File(arquivoGarcon);
	File fileProduto = new File(arquivoProduto);

	/**
	 * Salva os itens da lista recebida como parametro em arquivo.
	 * 
	 * @param lista A lista de itens do restaurante para salvar em arquivo
	 * @return true se for salvo com sucesso
	 */
	@Override
	public boolean salvaLista(List<ItemDoRestaurante> lista) {
		
		//Verifica se a lista e maior que zero
		if(!lista.isEmpty()){	
			
			//verifica se e instancia de garcon ou de Produto e retorna o resultado
			if(lista.get(0) instanceof Garcon){
				return arquiva(lista, fileGarcon);
			}else if(lista.get(0) instanceof Produto){
				return arquiva(lista, fileProduto);			
			}
		}//fim do if
		
		return false;
			
	}//fim do metodo salva lista
	
	/**
	 * Escreve as informacoes da lista no arquivo especificado.
	 * 
	 * @param lista A lista de ItemDoRestaurante para arquivar
	 * @param arquivo O nome do arquivo que vai gerenciar
	 * @return true se der tudo certo
	 */
	private boolean arquiva(List<ItemDoRestaurante> lista, File arquivo) {
		
		FileWriter escreverNoArquivo;
		try {
			//Cria o arquivo e abre ele para que possa ser escrito
			escreverNoArquivo = new FileWriter(arquivo); 
			BufferedWriter bufferDeGravacao = new BufferedWriter(escreverNoArquivo);
			
			//percorre a lista recebida e escreve cada registro no arquivo
			for(int i = 0; i<lista.size() ;i++){
					bufferDeGravacao.write(lista.get(i).toString() + System.lineSeparator());//escreve do arquivo
			}
			
			bufferDeGravacao.close();
			escreverNoArquivo.close();
			
			
		} catch (IOException e) {
			return false;
		}
		
		return true;	
			
	}//Fim do metodo arquiva

	/**
	 * Retorna as informacoes dos produtos do restaurante.
	 * 
	 * @return A lista de produtos para ser carregada na inicializacao do programa
	 */
	public List<ItemDoRestaurante> carregaListaDeProdutos() {
		
		List <ItemDoRestaurante> lista= new ArrayList<ItemDoRestaurante>();
		ItemDoRestaurante produto;
		
		try {
			File arquivo = new File("Produto.txt");//abre o arquivo
			
			Scanner input = new Scanner(arquivo).useDelimiter("\\-");//instancia o scanner para leitura do arquivo separado pelo delimitador -
			
			while(input.hasNext()){
				
				String [] dados = input.nextLine().split("-");//salva a linha de string num array separado pelo delimitador -
				
				produto = new Produto(Integer.parseInt(dados[0]), dados[1],Double.parseDouble(dados[2])); //cria um novo objeto produto
				lista.add(produto);	//adiciona o produto criado a lista de Produtos
				Cozinha.produtosCadastrados.add(Integer.parseInt(dados[0]));
			}
			input.close();
			
		} catch (FileNotFoundException fileNotFoundException) {
			JOptionPane.showMessageDialog(null, "Arquivo nao encontrado!");
			return null;
		} catch(InputMismatchException inputMismatchException){
			JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo");
			return null;
		}
		
		
		return lista;
		
	}//fim do metodo carrega lista de produtos

	/**
	 * Retorna as informacoes dos garcons do restaurante.
	 * 
	 * @return A lista de garcons para ser carregada no programa
	 */
	public List<ItemDoRestaurante> carregaListaDeGarcons() {
		
			List <ItemDoRestaurante> lista= new ArrayList<ItemDoRestaurante>();
			ItemDoRestaurante garcon;
			
			File arquivo = new File("Garcons.txt");//abre o arquivo
			Scanner input;
			try {
				input = new Scanner(arquivo).useDelimiter("\\-");//le o arquivo com scanner
				while(input.hasNext()){
					
					garcon = new Garcon(Integer.parseInt(input.next()), input.nextLine().replace("-",""));//cria um novo objeto garcon
					lista.add(garcon);//adiciona o objeto garcon a lista
					Escritorio.garconsCadastrados.add(((Garcon) garcon).getCodigo());
				}
				
				input.close();
			}catch (FileNotFoundException fileNotFoundException) {
				JOptionPane.showMessageDialog(null, "Arquivo nao encontrado!");
				return null;
			} catch(InputMismatchException inputMismatchException){
				JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo");
				return null;
			}
			
			return lista;
		
	}//fim do metodo carregaListaDeGarcon
}
