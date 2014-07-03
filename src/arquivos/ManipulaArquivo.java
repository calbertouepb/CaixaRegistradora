package arquivos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ManipulaArquivo {


	private String nomeDoArquivo;
	
	//método construtor
	public void ManipulaArquivo(String nomeDoArquivo){
		this.nomeDoArquivo = nomeDoArquivo;
	}
	
	
	//Método para inserir registros no arquivo
	public void InserirRegistro(String dados){
		
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
		
	}//fim do método inserir registro
	
	public String RecuperarDado(int codigo){
		
		Scanner input;
		File arquivo;
		
		try{
			
			arquivo = new File(nomeDoArquivo);
			input = new Scanner(arquivo);
			
			while(input.hasNext()){
				
				int numero = input.nextInt();
				if(numero == codigo){
					return input.nextLine();
				}else{
					input.nextLine();
				}	
				
			}
			
			
			input.close();
			
		
		}catch(FileNotFoundException fileNotFoundException){
			JOptionPane.showMessageDialog(null, "REGISTRO OU ARQUIVO NÃO ENCONTRADO");
		}
		return "Registro não encontrado";
	}
	
	public void editaRegistro(int codigo, String novoRegistro){
		
		File arquivo;
		Scanner leArquivo;
		ArrayList<String> registros;
		int contador = 0;
		
		//Copia os registro para array de String para não perder os dados quando editar
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
			System.err.println("Arquivo não encontrado");
		}
		
		
		
		
	}
}
