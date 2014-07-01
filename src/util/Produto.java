/**
 * Pacote de classes utilitárias
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Um produto disponível no restaurante
 * 
 * @author carlos
 *
 */
public class Produto {
	/**
	 * O código de identificação do produto
	 */
	private int codigo;
	
	/**
	 * A descrição do produto
	 */
	private String descricao;
	
	/**
	 * O preço unitário do produto
	 */
	private double preco;

	/**
	 * Um produto completamente caracterizado
	 * 
	 * @param codigo O código de identificação do produto
	 * @param descricao A descrição do produto
	 * @param preco O preço unitário do produto
	 */
	public Produto(int codigo, String descricao, double preco) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setPreco(preco);
	}
	
	/**
	 * Retorna o código de identificação do produto
	 * @return O código de identificação do produto
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Modifica o código de identificação do produto
	 * @param codigo O novo código de identificação do produto
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna a descrição do produto
	 * @return A descrição do produto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Modifica a descrição do produto
	 * @param descricao A nova descrição do produto
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Retorna o preço unitário do produto
	 * @return O preço unitário do produto
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Modifica o preço unitário do produto
	 * @param preco O novo preço unitário do produto
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public boolean equals(Object outro) {
		if(outro instanceof Produto){
			Produto novoProduto = (Produto) outro;
			return this.codigo == novoProduto.getCodigo();
		}
		return false;
	}

	@Override
	public String toString() {
		return "" + this.getCodigo() + " - " + this.getDescricao() + ": R$(und) " + this.getPreco();
	}
}
