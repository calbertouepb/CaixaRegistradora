/**
 * 
 */
package arquivos;

import java.util.List;

import util.ItemDoRestaurante;

/**
 * @author talles
 *
 */
public interface Arquivavel {
	
	public abstract boolean salvaLista(List<ItemDoRestaurante> lista);
	public abstract List<ItemDoRestaurante> carregaListaDeProdutos();
	public abstract List<ItemDoRestaurante> carregaListaDeGarcons();

}
