package br.com.mundotigre.objetos;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.mundotigre.funcoesprincipais.cadastro.CasoDataNascimento;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoNome;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoProfissaoAtividade;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoProfissaoDetalhe;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoSexo;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoTempoAtuacao;

public class Principal {
	
public static WebDriver driver;
	
	public static void main(String[] args){		
		
		driver = new FirefoxDriver();
		long tempoInicio = System.currentTimeMillis(); 	
		
		int i= 67;
		
		String cpf = "2136727258";
		String email = "seis";
		
		Usuario usuario = new Usuario();			
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setNome("vovo");
		usuario.setDataNascimento("22/11/1994");
		usuario.setSexo("M"); 
		usuario.setProfissaoAtividade("61");
		usuario.setTempoAtuacao("2"); 
		usuario.setDDD("047");
		usuario.setTelefone("988091642"); 
		usuario.setCelular("987654321");
		usuario.setCep("89235735222"); 	
		usuario.setEndereco("Rua cidade de Maracajá"); 
		usuario.setNumero("155");
		usuario.setComplemento("Próximo ao mercado Renascer");
		usuario.setEstado(24); 
		usuario.setCidade("420910"); 
		usuario.setBairro("Parque Guarani");
		usuario.setEmpresa("0030946290001");
		usuario.setTrabalhaEmpresa(1);
		usuario.setTimeCoracao("100");
		usuario.setConfirmaEmail(email); 
		usuario.setSenha("alif");
		usuario.setConfirmaSenha("alif");			
		
		
		/*CasoCPF casoCPF = new CasoCPF();		
		casoCPF.Inicio();
		casoCPF.testarCPF(driver, usuario);	
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
			
		CasoEmail casoEmail = new CasoEmail();
		casoEmail.Inicio();
		casoEmail.testarEmail(driver, usuario);
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		*/
		
	/*	CasoNome casoNome = new CasoNome();		
		casoNome.Inicio();
		casoNome.testarNome(driver, usuario);
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoDataNascimento casoDataNascimento = new CasoDataNascimento();		
		casoDataNascimento.Inicio();
		casoDataNascimento.testarDataNascimento(driver, usuario);	
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoSexo casoSexo = new CasoSexo();		
		casoSexo.Inicio();
		casoSexo.testarSexo(driver, usuario);
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 	
	
		
		CasoProfissaoAtividade casoProfissao = new CasoProfissaoAtividade();		
		casoProfissao.Inicio();
		casoProfissao.testarProfissaoAtividade(driver, usuario);
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 	
		
		
		CasoProfissaoDetalhe casoProfissaoDetalhe = new CasoProfissaoDetalhe();		
		casoProfissaoDetalhe.Inicio();
		casoProfissaoDetalhe.testarProfissaoAtividade(driver, usuario);
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); */
		
		CasoTempoAtuacao casoTempoAtuacao = new CasoTempoAtuacao();		
		casoTempoAtuacao.Inicio();
		casoTempoAtuacao.testarTempoAtuacao(driver, usuario);
		i++;	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		long tempoFim = System.currentTimeMillis(); 
		System.out.println("\nTempo total de execução de todos os testes: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio))+"\n");		
	}
}
