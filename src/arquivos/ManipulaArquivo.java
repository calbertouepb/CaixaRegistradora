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
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import util.Garcon;
import util.ItemDoRestaurante;
import util.Produto;

public class ManipulaArquivo implements Arquivavel{

	private String arquivoGarcon = "garcons.txt";
	private String arquivoProduto = "Produto.txt";
	
	File fileGarcon = new File(arquivoGarcon);
	File fileProduto = new File(arquivoProduto);

	/* (non-Javadoc)
	 * @see arquivos.Arquivavel#salvaLista(java.util.List)
	 */
	@Override
	public boolean salvaLista(List<ItemDoRestaurante> lista) {
		
		//Verifica se a lista é maior que zero
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
		
		List <ItemDoRestaurante> lista= new ArrayList<ItemDoRestaurante>();
		ItemDoRestaurante produto;
		
		File arquivo = new File("Produto.txt");
		Scanner input;
		try {
			input = new Scanner(arquivo).useDelimiter("\\-");
			
			while(input.hasNext()){
				
				String [] dados = input.nextLine().split("-");
				
				produto = new Produto(Integer.parseInt(dados[0]), dados[1],Double.parseDouble(dados[2]));
				lista.add(produto);			
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
		
	}

	/**
	 * @return
	 */
	public List<ItemDoRestaurante> carregaListaDeGarcons() {
		
			List <ItemDoRestaurante> lista= new ArrayList<ItemDoRestaurante>();
			ItemDoRestaurante garcon;
			
			File arquivo = new File("Garcons.txt");
			Scanner input;
			try {
				input = new Scanner(arquivo).useDelimiter("\\-");
				while(input.hasNext()){
					
					garcon = new Garcon(Integer.parseInt(input.next()), input.nextLine().replace("-",""));
					lista.add(garcon);
				}
				
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lista;
		
	}
}
