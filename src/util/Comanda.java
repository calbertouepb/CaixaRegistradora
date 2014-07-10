/**
 * File: Comanda.java
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Comanda de restaurante
 * 
 * @author carlos
 *
 */
public class Comanda {
	
	//Numero da comanda
	private int numero;
	
	//Garcon que anotou o pedido
	private Garcon garcon;
	
	//Lista de pedidos da comanda
	private Pedido[] pedidosDaComanda;
	
	/**
	 * Comanda numerada com o respectivo garcon e os pedidos anotados
	 * @param numero O numero da comanda
	 * @param garcon O garcon que anotou a comanda
	 * @param listaDePedidos A lista de pedidos da comanda
	 */
	public Comanda(int numero, Garcon garcon, Pedido[] listaDePedidos){
		this.setNumero(numero);
		this.setGarcon(garcon);
		this.setPedidosDaComanda(listaDePedidos);
	}
	
	/**
	 * Retorna o numero da comanda
	 * @return O numero da comanda
	 */
	public int getNumero(){
		return this.numero;
	}
	
	/**
	 * Modifica o numero da comanda
	 * @param numero O novo numero da comanda
	 */
	public void setNumero(int numero){
		this.numero = numero;
	}

	/**
	 * Retorna o garcon que anotou a comanda
	 * @return O garcon que anotou a comanda
	 */
	public Garcon getGarcon() {
		return garcon;
	}

	/**
	 * Modifica o garcon que anotou a comanda
	 * @param garcon O novo garcon
	 */
	public void setGarcon(Garcon garcon) {
		this.garcon = garcon;
	}

	/**
	 * Retorna a lista de pedidos da comanda
	 * @return A lista de pedidos da comanda
	 */
	public Pedido[] getPedidosDaComanda() {
		return pedidosDaComanda;
	}

	/**
	 * Modifica a lista de pedidos da comanda
	 * @param pedidosDaComanda A nova lista de pedidos da comanda
	 */
	public void setPedidosDaComanda(Pedido[] pedidosDaComanda) {
		this.pedidosDaComanda = pedidosDaComanda;
	}

	@Override
	public boolean equals(Object outro) {
		if(outro instanceof Comanda){
			Comanda outraComanda = (Comanda) outro;
			return this.getNumero() == outraComanda.getNumero();
		}
		return false;
	}

	@Override
	public String toString() {
		String numeroDosPedidos = "";
		for(int i = 0; i < pedidosDaComanda.length; i++){
			numeroDosPedidos += pedidosDaComanda[i].getNumero() + "\n";
		}
		return "Comanda Nº: " + this.getNumero() + "\ngarcon: " + this.getGarcon().getCodigo() + 
				"\nPedidos Nº: \n" + numeroDosPedidos;
	}	
}
