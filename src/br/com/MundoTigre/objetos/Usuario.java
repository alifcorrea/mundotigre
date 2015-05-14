package br.com.MundoTigre.objetos;

public class Usuario {
	
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String cpf;
	private String email;
	private String nome;
	private int dataNascimento;
	private String sexo;
	private int profissaoAtividade;
	private int tempoAtuacao;
	private Long telefone;
	private Long celular;
	
	
	//Dados Residenciais 
	private int cep;
	private String Endereco;
	private int numero;
	private String complemento;
	private int estado;
	private int cidade;
	private String bairro;
	
	
	//Empresa em que trabalha ou costuma comprar produtos Tigre
	private int estadoEmpresa;
	private int cidadeEmpresa;
	private int empresa;
	private int trabalhaEmpresa;
	
	
	//Atividade física/esportiva
	private int atividadeFisicaPreferida;
	private int tipoCoracao;
	
	
	//Informações complementares
	private int novidades;
	private int sms;
	private int areaDesejaReceberInfo;
	private String confirmaEmail;
	private String senha;
	private String confirmaSenha;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getProfissaoAtividade() {
		return profissaoAtividade;
	}
	public void setProfissaoAtividade(int profissaoAtividade) {
		this.profissaoAtividade = profissaoAtividade;
	}
	public int getTempoAtuacao() {
		return tempoAtuacao;
	}
	public void setTempoAtuacao(int tempoAtuacao) {
		this.tempoAtuacao = tempoAtuacao;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public Long getCelular() {
		return celular;
	}
	public void setCelular(Long celular) {
		this.celular = celular;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCidade() {
		return cidade;
	}
	public void setCidade(int cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getEstadoEmpresa() {
		return estadoEmpresa;
	}
	public void setEstadoEmpresa(int estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}
	public int getCidadeEmpresa() {
		return cidadeEmpresa;
	}
	public void setCidadeEmpresa(int cidadeEmpresa) {
		this.cidadeEmpresa = cidadeEmpresa;
	}
	public int getEmpresa() {
		return empresa;
	}
	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	public int getTrabalhaEmpresa() {
		return trabalhaEmpresa;
	}
	public void setTrabalhaEmpresa(int trabalhaEmpresa) {
		this.trabalhaEmpresa = trabalhaEmpresa;
	}
	public int getAtividadeFisicaPreferida() {
		return atividadeFisicaPreferida;
	}
	public void setAtividadeFisicaPreferida(int atividadeFisicaPreferida) {
		this.atividadeFisicaPreferida = atividadeFisicaPreferida;
	}
	public int getTipoCoracao() {
		return tipoCoracao;
	}
	public void setTipoCoracao(int tipoCoracao) {
		this.tipoCoracao = tipoCoracao;
	}
	public int getNovidades() {
		return novidades;
	}
	public void setNovidades(int novidades) {
		this.novidades = novidades;
	}
	public int getSms() {
		return sms;
	}
	public void setSms(int sms) {
		this.sms = sms;
	}
	public int getAreaDesejaReceberInfo() {
		return areaDesejaReceberInfo;
	}
	public void setAreaDesejaReceberInfo(int areaDesejaReceberInfo) {
		this.areaDesejaReceberInfo = areaDesejaReceberInfo;
	}
	public String getConfirmaEmail() {
		return confirmaEmail;
	}
	public void setConfirmaEmail(String confirmaEmail) {
		this.confirmaEmail = confirmaEmail;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	
	
}
