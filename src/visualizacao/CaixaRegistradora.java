/**
 * File: CaixaRegistradora.java
 */
package visualizacao;

import manage.GerenteCaixa;

/* Aluno: Carlos Alberto de Amorim Porto - 121085031  */

/**
 * Caixa registradora de restaurante.
 * 
 * @author carlos
 *
 */
public class CaixaRegistradora {

	/**
	 * Metodo principal que executa o caixa.
	 * 
	 * @param args Argumentos da linha de comando.
	 */
	public static void main(String[] args) {
		GerenteCaixa gerente = new GerenteCaixa();
		gerente.run();
	}
}
