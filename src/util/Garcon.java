/**
 * File:Garcon.java
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Um garcon do restaurante
 * 
 * @author carlos
 * 
 */
public class Garcon implements ItemDoRestaurante {
	
	//O codigo de identificação do garcon
	private int codigo;
	
	//O nome do garcon
	private String nome;
	
	//Total de gorjeta acumulada pelo garcon
	private double gorjeta;
	
	/**
	 * Um garcon com seu codigo de identificação
	 * 
	 * @param codigo O codigo de identificação do garcon
	 * @param nome O nome do garcon
	 */
	public Garcon(int codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setGorjeta(0.0);
	}
	
	/**
	 * Retorna o codigo de identificação do garcon
	 * @return O codigo de identificação do garcon
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Modifica o codigo de identificação do garcon
	 * @param codigo O novo codigo de identificação do garcon
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna o nome do garcon
	 * @return O nome do garcon
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica o nome do garcon
	 * @param nome O novo nome do garcon
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o total de gorjeta acumulada pelo garcon durante o dia
	 * @return O total de gorjeta aculmulada
	 */
	public double getGorjeta(){
		return this.gorjeta;
	}
	
	/**
	 * Modifica o total de gorjetas acumuladas pelo garcon durante o dia
	 * @param novaGorjeta A nova gorjeta recebida pelo garcon
	 */
	public void setGorjeta(double novaGorjeta){
		this.gorjeta += novaGorjeta;
	}

	@Override
	public boolean equals(Object outro) {
		if(outro instanceof Garcon){
			Garcon novoGarcon = (Garcon) outro;
			return this.getCodigo() == novoGarcon.getCodigo();
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + getCodigo() + "-" + getNome();
	}	
}
