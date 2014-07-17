package arquivos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import util.Garcon;
import util.ItemDoRestaurante;
import util.Produto;

public class ManipulaArquivo implements Arquivavel{

	private String arquivoGarcon = "garcons.txt";
	private String arquivoProduto = "Produto.txt";
	
	File fileGarcon = new File(arquivoGarcon);
	File fileProduto = new File(arquivoProduto);

	//metodo construtor
//	public ManipulaArquivo(String nomeDoArquivo){
//		this.nomeDoArquivo = nomeDoArquivo;
//	}

	//Metodo para inserir registros no arquivo
	/*public void InserirRegistro(String dados){

		try{
			File arquivo = new File(this.nomeDoArquivo);
			FileWriter escreverNoArquivo;

			if(arquivo.exists()){
				escreverNoArquivo = new FileWriter(arquivo,true);
			}else{
				escreverNoArquivo = new FileWriter(arquivo);
			}

			BufferedWriter bufferDeGravacao = new BufferedWriter(escreverNoArquivo);
			bufferDeGravacao.write(dados + System.lineSeparator());
			JOptionPane.showMessageDialog(null,"dados inseridos com sucesso");

			bufferDeGravacao.close();
			escreverNoArquivo.close();

		}catch(IOException ioException){
			JOptionPane.showMessageDialog(null,"ERRO AO INSERIR DADOS. TENTE NOVAMENTE");		
		}

	}//fim do metodo inserir registro

	public String RecuperarDado(int codigo){

		try{
			File arquivo = new File(this.nomeDoArquivo);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(arquivo);

			while(input.hasNext()){

				int numero = input.nextInt();
				if(numero == codigo){
					return input.nextLine();
				}else{
					input.nextLine();
				}	

			}
		}catch(FileNotFoundException fileNotFoundException){
			JOptionPane.showMessageDialog(null, "REGISTRO OU ARQUIVO NAO ENCONTRADO");
		}
		return "Registro nao encontrado";
	}

	public void editaRegistro(int codigo, String novoRegistro){

		File arquivo;
		Scanner leArquivo;
		ArrayList<String> registros;
		//Copia os registro para array de String para nao perder os dados quando editar
		try{
			arquivo = new File(this.nomeDoArquivo);
			leArquivo = new Scanner(arquivo);
			registros = new ArrayList<String>();

			while(leArquivo.hasNext()){
				registros.add(leArquivo.nextLine());
			}

			registros.add(registros.indexOf(codigo + RecuperarDado(codigo)), codigo + novoRegistro);

			System.out.println(Arrays.toString(registros.toArray()));

		}catch(FileNotFoundException fileNotFoundException){
			System.err.println("Arquivo nao encontrado");
		}
	}*/

	/* (non-Javadoc)
	 * @see arquivos.Arquivavel#salvaLista(java.util.List)
	 */
	@Override
	public boolean salvaLista(List<ItemDoRestaurante> lista) {
		
		//Verifica se a lista � maior que zero
		if(!lista.isEmpty()){	
			
			
			if(lista.get(0) instanceof Garcon){
				return arquiva(lista, fileGarcon);
			}else if(lista.get(0) instanceof Produto){
				return arquiva(lista, fileProduto);			}
		}
		
		return false;
			
	}
	
	
	private boolean arquiva(List<ItemDoRestaurante> lista, File arquivo) {
		
		FileWriter escreverNoArquivo;
		try {
			escreverNoArquivo = new FileWriter(arquivo);
			BufferedWriter bufferDeGravacao = new BufferedWriter(escreverNoArquivo);
			for(int i = 0; i<lista.size() ;i++){
					bufferDeGravacao.write(lista.get(i).toString() + System.lineSeparator());
			}
			bufferDeGravacao.close();
			escreverNoArquivo.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;	
			
	}

	/**
	 * @return
	 */
	public List<ItemDoRestaurante> carregaListaDeProdutos() {
		// TODO Auto-generated method stub
		List <ItemDoRestaurante> lista= new ArrayList<ItemDoRestaurante>();
		return lista;
	}

	/**
	 * @return
	 */
	public List<ItemDoRestaurante> carregaListaDeGarcons() {
		// TODO Auto-generated method stub
		List <ItemDoRestaurante> lista= new ArrayList<ItemDoRestaurante>();
		return lista;
	}
}
