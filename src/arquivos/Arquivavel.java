/**
 * File: Arquivavel.java
 */
package arquivos;

import java.util.List;

import util.ItemDoRestaurante;

/**
 * Prove metodos para a manipulacao de arquivos de texto.
 * 
 * @author talles
 *
 */
public interface Arquivavel {
	
	/**
	 * Salva os itens da lista recebida como parametro em arquivo.
	 * 
	 * @param lista A lista de itens do restaurante para salvar em arquivo
	 * @return true se for salvo com sucesso
	 */
	public abstract boolean salvaLista(List<ItemDoRestaurante> lista);
	
	/**
	 * Retorna as informacoes dos produtos do restaurante.
	 * 
	 * @return A lista de produtos para ser carregada na inicializacao do programa
	 */
	public abstract List<ItemDoRestaurante> carregaListaDeProdutos();
	
	/**
	 * Retorna as informacoes dos garcons do restaurante.
	 * 
	 * @return A lista de garcons para ser carregada no programa
	 */
	public abstract List<ItemDoRestaurante> carregaListaDeGarcons();

}
