package br.edu.infnet.donationapp.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String tipo;
	private int idade;
	private boolean admin;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private List<Doador> doadores;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private List<Produto> produtos;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idUsuario")
	private List<Transacao> transacoes;
	@OneToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;

	public Usuario() {
	}

	public Usuario(String email, String senha) {
		this();
		this.setEmail(email);
		this.setSenha(senha);
	}

	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.setNome(nome);
	}

	@Override
	public String toString() {

		return String.format("O usu�rio %s tem as credenciais %s e %s, %d anos. " + "� um usu�rio do tipo %s", nome,
				email, senha, idade, tipo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Doador> getDoadores() {
		return doadores;
	}

	public void setDoadores(List<Doador> doadores) {
		this.doadores = doadores;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
	
}
