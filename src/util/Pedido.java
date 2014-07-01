/**
 * Pacote de classes utilitárias
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Um pedido ao garçon, composto de produtos disponíveis no restaurante
 * 
 * @author carlos
 *
 */
public class Pedido {
	/**
	 * Número identificador do pedido
	 */
	private int numeroDoPedido;
	
	/**
	 * Listagem dos produtos consumidos
	 */
	private Produto[] produtosConsumidos;
	
	/**
	 * Pedido numerado e preenchido
	 * @param numero O número do pedido
	 * @param produtosConsumidos Uma lista com os produtos consumidos
	 */
	public Pedido(int numero, Produto[] produtosConsumidos){
		this.setNumero(numero);
		this.setProdutosConsumidos(produtosConsumidos);
	}

	/**
	 * Retorna o número do pedido
	 * @return O número do pedido
	 */
	public int getNumero() {
		return numeroDoPedido;
	}

	/**
	 * Modifica o número do pedido
	 * @param numero O novo número do pedido
	 */
	public void setNumero(int numero) {
		this.numeroDoPedido = numero;
	}

	/**
	 * Retorna a lista de produtos consumidos
	 * @return A lista de produtos consumidos
	 */
	public Produto[] getProdutosConsumidos() {
		return produtosConsumidos;
	}

	/**
	 * Modifica a lista de produtos consumidos
	 * @param produtosConsumidos A nova lista de produtos consumidos
	 */
	public void setProdutosConsumidos(Produto[] produtosConsumidos) {
		this.produtosConsumidos = produtosConsumidos;
	}

	@Override
	public boolean equals(Object outro) {
		if(outro instanceof Pedido){
			Pedido outroPedido = (Pedido) outro;
			return this.getNumero() == outroPedido.getNumero();
		}
		return false;
	}

	@Override
	public String toString() {
		String listagem = "";
		for(int i = 0; i < produtosConsumidos.length; i++){
			listagem += produtosConsumidos[i].toString() + "\n";
		}
		return "Pedido Nº: " + this.getNumero() + "\n" + listagem;
	}
}
