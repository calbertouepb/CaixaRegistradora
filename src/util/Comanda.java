/**
 * Pacote de classes utilitárias
 * 
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Comanda de restaurante
 * 
 * @author carlos
 *
 */
public class Comanda {
	/**
	 * Número da comanda
	 */
	private int numero;
	
	/**
	 * Garçon que anotou o pedido
	 */
	private Garcon garcon;
	
	/**
	 * Lista de pedidos da comanda
	 */
	private Pedido[] pedidosDaComanda;
	
	/**
	 * Comanda numerada com o respectivo garçon e os pedidos anotados
	 * @param numero O número da comanda
	 * @param garcon O garçon que anotou a comanda
	 * @param listaDePedidos A lista de pedidos da comanda
	 */
	public Comanda(int numero, Garcon garcon, Pedido[] listaDePedidos){
		this.setNumero(numero);
		this.setGarcon(garcon);
		this.setPedidosDaComanda(listaDePedidos);
	}
	
	/**
	 * Retorna o número da comanda
	 * @return O número da comanda
	 */
	public int getNumero(){
		return this.numero;
	}
	
	/**
	 * Modifica o número da comanda
	 * @param numero O novo número da comanda
	 */
	public void setNumero(int numero){
		this.numero = numero;
	}

	/**
	 * Retorna o garçon que anotou a comanda
	 * @return O garçon que anotou a comanda
	 */
	public Garcon getGarcon() {
		return garcon;
	}

	/**
	 * Modifica o garçon que anotou a comanda
	 * @param garcon O novo garçon
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object outro) {
		if(outro instanceof Comanda){
			Comanda outraComanda = (Comanda) outro;
			return this.getNumero() == outraComanda.getNumero();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String numeroDosPedidos = "";
		for(int i = 0; i < pedidosDaComanda.length; i++){
			numeroDosPedidos += pedidosDaComanda[i].getNumero() + "\n";
		}
		return "Comanda Nº: " + this.getNumero() + "\nGarçon: " + this.getGarcon().getCodigo() + 
				"\nPedidos Nº: \n" + numeroDosPedidos;
	}	
}
