package br.com.mundotigre.objetos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.mundotigre.funcoesprincipais.cadastro.CasoCEP;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoCPF;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoCidade;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoComplemento;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoConfirmaSenha;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoConfirmeEmail;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoDDD;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoDataNascimento;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoEmail;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoEmpresa;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoEndereco;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoEstado;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoNome;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoNovidades;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoNumero;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoProfissaoAtividade;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoProfissaoDetalhe;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoSenha;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoSexo;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoTelefone;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoTelefoneCelular;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoTempoAtuacao;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoTimeCoracao;
import br.com.mundotigre.funcoesprincipais.cadastro.CasoTrabalhaEmpresa;
import br.com.mundotigre.scripts.FuncoesCadastro;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class Principal {
	
public static WebDriver driver;
public static InteracoesNavegador interacoesNavegador;
public static FuncoesCadastro funcoesCadastro;
private static final long serialVersionUID = 1L;

public static long getSerialversionuid() {
	return serialVersionUID;
}

	public static void main(String[] args){		
			
		//###############Criar Objetos################//
		driver = new FirefoxDriver();
		interacoesNavegador = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();
		//###########################################//
		
		
		//##########Variáveis de Controle############//
		long tempoInicio = System.currentTimeMillis(); 
		String email = funcoesCadastro.caracteresAleatorios();
		String cpf = funcoesCadastro.numerosAleatorios();
		//###########################################//
		
		
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
		usuario.setEstado("24"); 
		usuario.setCidade("420910"); 
		usuario.setBairro("Parque Guarani");
		usuario.setEmpresa("0030946290001");
		usuario.setTrabalhaEmpresa("1");
		usuario.setTimeCoracao("100");
		usuario.setConfirmaEmail(email); 
		usuario.setSenha("alif");
		usuario.setConfirmaSenha("alif");			
		
		
		CasoCPF casoCPF = new CasoCPF();	

		casoCPF.testarCPF(driver, usuario, interacoesNavegador, funcoesCadastro);
		
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
			
		CasoEmail casoEmail = new CasoEmail();
		
		casoEmail.testarEmail(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
	
		CasoNome casoNome = new CasoNome();		
		
		casoNome.testarNome(driver, usuario, interacoesNavegador, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		usuario.setNome("Teste");
		
		CasoDataNascimento casoDataNascimento = new CasoDataNascimento();		
		
		casoDataNascimento.testarDataNascimento(driver, usuario, interacoesNavegador, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoSexo casoSexo = new CasoSexo();		
		
		casoSexo.testarSexo(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
	
		
		CasoProfissaoAtividade casoProfissao = new CasoProfissaoAtividade();		

		casoProfissao.testarProfissaoAtividade(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 	
		
		
		CasoProfissaoDetalhe casoProfissaoDetalhe = new CasoProfissaoDetalhe();		
		
		casoProfissaoDetalhe.testarProfissaoDetalhe(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		CasoTempoAtuacao casoTempoAtuacao = new CasoTempoAtuacao();		
		
		casoTempoAtuacao.testarTempoAtuacao(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoDDD casoDDD = new CasoDDD();
		
		casoDDD.testarDDD(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoTelefone casoTelefone = new CasoTelefone();
		
		casoTelefone.testarTelefone(driver, usuario, interacoesNavegador, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoTelefoneCelular casoTelefoneCelular = new CasoTelefoneCelular();

		casoTelefoneCelular.testarTelefoneCelular(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);


		CasoCEP casoCEP = new CasoCEP();
		
		casoCEP.testarCEP(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoEndereco casoEndereco = new CasoEndereco();
		
		casoEndereco.testarEndereco(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoNumero casoNumero = new CasoNumero();
		
		casoNumero.testarNumero(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoComplemento casoComplemento = new CasoComplemento();
		
		casoComplemento.testarComplemento(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setNome("Teste");
		usuario.setConfirmaEmail(email);
		
		
		CasoEstado casoEstado = new CasoEstado();
		
		casoEstado.testarEstado(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoCidade casoCidade = new CasoCidade();
		
		casoCidade.testarCidade(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoEmpresa casoEmpresa = new CasoEmpresa();
		
		casoEmpresa.testarEmpresa(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoTrabalhaEmpresa casoTrabalhaEmpresa = new CasoTrabalhaEmpresa();
		
		casoTrabalhaEmpresa.testarTrabalhaEmpresa(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		/*#############################################################################################
		CasoAtividadeFisicaPreferida casoAtividadeFisicaPreferida = new CasoAtividadeFisicaPreferida();
		casoAtividadeFisicaPreferida.testarAtividadeFisicaPreferida(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		###############################################################################################*/
		
		CasoTimeCoracao casoTimeCoracao = new CasoTimeCoracao();
		casoTimeCoracao.testarTimeCoracao(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoNovidades casoNovidades = new CasoNovidades();
		casoNovidades.testarNovidades(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		/*#############################################################################################
		CasoAreaDesejaReceberInfo casoAreaDesejaReceberInfo = new CasoAreaDesejaReceberInfo();
		casoAreaDesejaReceberInfo.testarCasoAreaDesejaReceberInfo(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		###############################################################################################*/
		
		
		CasoConfirmeEmail casoConfirmeEmail = new CasoConfirmeEmail();
		casoConfirmeEmail.testarConfirmeEmail(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoSenha casoSenha = new CasoSenha();
		casoSenha.testarSenha(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoConfirmaSenha casoConfirmaSenha = new CasoConfirmaSenha();
		casoConfirmaSenha.testarConfirmaSenha(driver, usuario, interacoesNavegador, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		driver.close();
		
		long tempoFim = System.currentTimeMillis(); 		
		Date dataExecucao = GregorianCalendar.getInstance().getTime();  
        SimpleDateFormat format = new SimpleDateFormat();        
		System.out.println("\nData da execução: "+ format.format(dataExecucao) +"\n"
							+"Tempo total de execução de todos os testes: " + new SimpleDateFormat("mm:ss").format(new Date(tempoFim - tempoInicio))+"\n");		
	}
}
