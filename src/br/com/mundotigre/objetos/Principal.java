package br.com.mundotigre.objetos;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
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
import br.com.mundotigre.scripts.FuncoesMT;
import br.com.mundotigre.scripts.GravarExecucao;
import br.com.mundotigre.scripts.InteracoesNavegador;

public class Principal {

public static WebDriver driver;
public static InteracoesNavegador interacoesNavegador;
public static FuncoesCadastro funcoesCadastro;
public static FuncoesMT funcoesMT;
public static GravarExecucao gravarExecucao;
static final Logger logger = LogManager.getLogger(Principal.class.getName());
private static final long serialVersionUID = 1L;


public static long getSerialversionuid() {
	return serialVersionUID;
}


//############################################################################################## CONFIGURACOES INICIAIS #################################################################################//
		
	public static void main(String[] args) throws Exception{		
		
		Long tempoInicio = System.currentTimeMillis(); 
		
		driver = new FirefoxDriver();
		interacoesNavegador = new InteracoesNavegador();
		funcoesCadastro = new FuncoesCadastro();
		funcoesMT = new FuncoesMT();
		//gravarExecucao = new GravarExecucao();
		
		String link = "http://extranet.a2c.com.br/karol_braga/tigre-mundotigre/web/cadastro/new";	
		String email = funcoesMT.caracteresAleatorios();
		String cpf = funcoesMT.numerosAleatorios();
		
		DOMConfigurator.configure("log4j.xml");
		
		//gravarExecucao.iniciarGravacao(driver, logger);
		
		
//################################################################################################ INICIO DA EXECUCAO ###################################################################################//	
		
        logger.info("################################################################################# MUNDO TIGRE ########################################################################################################################");
		logger.info("");	        		
		
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
		
//################################################################################################### TESTES DO CADASTRO #################################################################################//			

		CasoCPF casoCPF = new CasoCPF();	
			
		casoCPF.testarCPF(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoEmail casoEmail = new CasoEmail();
		
		casoEmail.testarEmail(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
	
	
		CasoNome casoNome = new CasoNome();		
		
		casoNome.testarNome(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		usuario.setNome("Teste");
	
	
		CasoDataNascimento casoDataNascimento = new CasoDataNascimento();		
		
		casoDataNascimento.testarDataNascimento(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoSexo casoSexo = new CasoSexo();		
		
		casoSexo.testarSexo(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoProfissaoAtividade casoProfissao = new CasoProfissaoAtividade();		

		casoProfissao.testarProfissaoAtividade(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 	
		
		
		CasoProfissaoDetalhe casoProfissaoDetalhe = new CasoProfissaoDetalhe();		
		
		casoProfissaoDetalhe.testarProfissaoDetalhe(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoTempoAtuacao casoTempoAtuacao = new CasoTempoAtuacao();		
		
		casoTempoAtuacao.testarTempoAtuacao(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email); 
		
		
		CasoDDD casoDDD = new CasoDDD();
		
		casoDDD.testarDDD(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoTelefone casoTelefone = new CasoTelefone();
		
		casoTelefone.testarTelefone(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);	
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoTelefoneCelular casoTelefoneCelular = new CasoTelefoneCelular();
		
		casoTelefoneCelular.testarTelefoneCelular(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoCEP casoCEP = new CasoCEP();
		
		casoCEP.testarCEP(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoEndereco casoEndereco = new CasoEndereco();
		
		casoEndereco.testarEndereco(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoNumero casoNumero = new CasoNumero();
		
		casoNumero.testarNumero(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoComplemento casoComplemento = new CasoComplemento();
		
		casoComplemento.testarComplemento(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setNome("Teste");
		usuario.setConfirmaEmail(email);
		
		
		CasoEstado casoEstado = new CasoEstado();
		
		casoEstado.testarEstado(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoCidade casoCidade = new CasoCidade();
		
		casoCidade.testarCidade(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoEmpresa casoEmpresa = new CasoEmpresa();
		
		casoEmpresa.testarEmpresa(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoTrabalhaEmpresa casoTrabalhaEmpresa = new CasoTrabalhaEmpresa();
		
		casoTrabalhaEmpresa.testarTrabalhaEmpresa(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		/*#############################################################################################
		CasoAtividadeFisicaPreferida casoAtividadeFisicaPreferida = new CasoAtividadeFisicaPreferida();
		
		casoAtividadeFisicaPreferida.testarAtividadeFisicaPreferida(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		###############################################################################################*/
		
		CasoTimeCoracao casoTimeCoracao = new CasoTimeCoracao();
		casoTimeCoracao.testarTimeCoracao(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoNovidades casoNovidades = new CasoNovidades();
		casoNovidades.testarNovidades(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		/*#############################################################################################
		CasoAreaDesejaReceberInfo casoAreaDesejaReceberInfo = new CasoAreaDesejaReceberInfo();
		casoAreaDesejaReceberInfo.testarCasoAreaDesejaReceberInfo(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		###############################################################################################*/
		
		
		CasoConfirmeEmail casoConfirmeEmail = new CasoConfirmeEmail();
		casoConfirmeEmail.testarConfirmeEmail(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoSenha casoSenha = new CasoSenha();
		casoSenha.testarSenha(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
		
		
		CasoConfirmaSenha casoConfirmaSenha = new CasoConfirmaSenha();
		casoConfirmaSenha.testarConfirmaSenha(driver, logger, usuario, link, interacoesNavegador, funcoesMT, funcoesCadastro);
		usuario.setCpf(cpf); 
		usuario.setEmail(email); 
		usuario.setConfirmaEmail(email);
	
		
		driver.close();
		
		FuncoesMT.relatorioFinal(driver, logger, tempoInicio);
		gravarExecucao.finalizarGravacao(driver, logger);
		
	}
}
