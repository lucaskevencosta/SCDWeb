/**
 * 
 */
package br.com.SCDWeb.model.usuario;

/**
 * @author Lucas Keven C. de Souza
 *
 */
public class UsuarioRN {
	
	public Boolean validaLogin(String usuario, String senha) {
		/* O objeto "modelo" da classe Usuário traz quais os dados o usuário deve digitar para realizar login.
		 * Os atributos usuario e senha que o método recebe, são os dados digitados pelo usuário. 
		 */
		Usuario modelo = new Usuario();
		if (usuario.equals(modelo.getUSUARIO()) && senha.equals(modelo.getSENHA()))
			return true;
		else return false;
	}
}
