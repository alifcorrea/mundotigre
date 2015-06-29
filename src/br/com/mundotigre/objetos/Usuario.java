package br.com.mundotigre.objetos;

public class Usuario {
	
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String cpf;
	private String email;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String profissaoAtividade;
	private String profissaoDetalhe;
	private String tempoAtuacao;
	private String DDD;
	private String telefone;
	private String celular;
	
	//Dados Residenciais 
	private String cep;
	private String Endereco;
	private String numero;
	private String complemento;
	private int estado;
	private String cidade;
	private String bairro;
	
	
	//Empresa em que trabalha ou costuma comprar produtos Tigre
	private int estadoEmpresa;
	private int cidadeEmpresa;
	private String empresa;
	private int trabalhaEmpresa;
	
	//Atividade física/esportiva
	private String timeCoracao;
	
	
	//Informações complementares
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProfissaoAtividade() {
		return profissaoAtividade;
	}
	public void setProfissaoAtividade(String profissaoAtividade) {
		this.profissaoAtividade = profissaoAtividade;
	}
	public String getProfissaoDetalhe() {
		return profissaoDetalhe;
	}
	public void setProfissaoDetalhe(String profissaoDetalhe) {
		this.profissaoDetalhe = profissaoDetalhe;
	}
	public String getTempoAtuacao() {
		return tempoAtuacao;
	}
	public void setTempoAtuacao(String tempoAtuacao) {
		this.tempoAtuacao = tempoAtuacao;
	}
	public String getDDD() {
		return DDD;
	}
	public void setDDD(String dDD) {
		DDD = dDD;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
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
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getTrabalhaEmpresa() {
		return trabalhaEmpresa;
	}
	public void setTrabalhaEmpresa(int trabalhaEmpresa) {
		this.trabalhaEmpresa = trabalhaEmpresa;
	}
	public String getTimeCoracao() {
		return timeCoracao;
	}
	public void setTimeCoracao(String timeCoracao) {
		this.timeCoracao = timeCoracao;
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
