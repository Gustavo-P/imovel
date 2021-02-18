package model.bean;

public class Imoveis {
	private int idImovel;
	private String endereco;
	private String nbairro;
	private String cidade;   
	private String cep;
	private boolean locavenda;
	private String valor;
	
	public int getIdImovel() {
		return idImovel;
	}
	public void setIdImovel(int idImovel) {
		this.idImovel= idImovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNbairro() {
		return nbairro;
	}
	public void setNbairro(String nbairro) {
		this.nbairro = nbairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public boolean isLocavenda() {
		return locavenda;
	}
	public void setLocavenda(boolean locavenda) {
		this.locavenda = locavenda;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	}
