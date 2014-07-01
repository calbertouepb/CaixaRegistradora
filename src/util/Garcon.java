/**
 * Pacote de classes utilitárias
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Um garçon do restaurante
 * 
 * @author carlos
 *
 */
public class Garcon {
	
	/**
	 * O código de identificação do garçon
	 */
	private int codigo;
	
	/**
	 * O nome do garçon
	 */
	private String nome;
	
	/**
	 * Total de gorjeta acumulada pelo garçon
	 */
	private double gorjeta;
	
	/**
	 * Um garçon com seu código de identificação
	 * 
	 * @param codigo O código de identificação do garçon
	 * @param nome O nome do garçon
	 */
	public Garcon(int codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setGorjeta(0.0);
	}
	
	/**
	 * Retorna o código de identificação do garçon
	 * @return O código de identificação do garçon
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Modifica o código de identificação do garçon
	 * @param codigo O novo código de identificação do garçon
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna o nome do garçon
	 * @return O nome do garçon
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica o nome do garçon
	 * @param nome O novo nome do garçon
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o total de gorjeta acumulada pelo garçon durante o dia
	 * @return O total de gorjeta aculmulada
	 */
	public double getGorjeta(){
		return this.gorjeta;
	}
	
	/**
	 * Modifica o total de gorjetas acumuladas pelo garçon durante o dia
	 * @param novaGorjeta A nova gorjeta recebida pelo garçon
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
		return "" + getCodigo() + " - " + getNome();
	}	
}
