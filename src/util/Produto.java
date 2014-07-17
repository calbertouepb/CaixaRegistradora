/**
 * File:Produto.java
 */
package util;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * 
 * Um produto disponivel no restaurante
 * 
 * @author carlos
 *
 */
public class Produto implements ItemDoRestaurante {
	
	//O codigo de identificacao do produto
	private int codigo;
	
	//A descricao do produto
	private String descricao;
	
	//O preco unitario do produto
	private double preco;

	/**
	 * Um produto completamente caracterizado
	 * 
	 * @param codigo O codigo de identificacao do produto
	 * @param descricao A descricao do produto
	 * @param preco O preco unitario do produto
	 */
	public Produto(int codigo, String descricao, double preco) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setPreco(preco);
	}
	
	/**
	 * Retorna o codigo de identificacao do produto
	 * @return O codigo de identificacao do produto
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Modifica o codigo de identificacao do produto
	 * @param codigo O novo codigo de identificacao do produto
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Retorna a descricao do produto
	 * @return A descricao do produto
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Modifica a descricao do produto
	 * @param descricao A nova descricao do produto
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Retorna o preco unitario do produto
	 * @return O preco unitario do produto
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * Modifica o preco unitario do produto
	 * @param preco O novo preco unitario do produto
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
		return "" + this.getCodigo() + "-" + this.getDescricao() + "-" + this.getPreco();
	}
}
