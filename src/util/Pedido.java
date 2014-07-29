/**
 * File:Pedido.java
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Um pedido composto de produtos disponiveis no restaurante
 * 
 * @author carlos
 *
 */
public class Pedido {
	
	//Numero identificador do pedido
	private int numeroDoPedido;
	
	//Codigo do garcon que anotou o pedido
	private int codigoDoGarcon;
	
	//Listagem dos produtos consumidos
	private Produto[] produtosConsumidos;
	
	/**
	 * Pedido numerado e preenchido
	 * @param numero O numero do pedido
	 * @param garcon O codigo do garcon que anotou o pedido
	 * @param produtosConsumidos Uma lista com os produtos consumidos
	 */
	public Pedido(int numero, int garcon, Produto[] produtosConsumidos){
		this.setNumero(numero);
		this.setCodigoDoGarcon(garcon);
		this.setProdutosConsumidos(produtosConsumidos);
	}

	/**
	 * Retorna o numero do pedido
	 * @return O numero do pedido
	 */
	public int getNumero() {
		return numeroDoPedido;
	}

	/**
	 * Modifica o numero do pedido
	 * @param numero O novo numero do pedido
	 */
	public void setNumero(int numero) {
		this.numeroDoPedido = numero;
	}

	/**
	 * Retorna o codigo do garcon que anotou o pedido.
	 * @return O codigo do garcon que anotou o pedido
	 */
	public int getCodigoDoGarcon() {
		return codigoDoGarcon;
	}

	/**
	 * Modifica o codigo do garcon
	 * @param codigoDoGarcon O novo codigo do garcon
	 */
	public void setCodigoDoGarcon(int codigoDoGarcon) {
		this.codigoDoGarcon = codigoDoGarcon;
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
		return "Pedido Nº: " + this.getNumero() + System.lineSeparator() + "Garcon: " + this.getCodigoDoGarcon() + System.lineSeparator() + listagem;
	}
}
