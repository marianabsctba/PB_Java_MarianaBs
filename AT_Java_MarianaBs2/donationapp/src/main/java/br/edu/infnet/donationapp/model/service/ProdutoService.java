package br.edu.infnet.donationapp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.donationapp.model.domain.Produto;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	
	private ProdutoRepository produtoRepository; 
	
	
	public void excluir(Integer id) {
		 produtoRepository.deleteById(id);
	}
	
	
	public Collection<Produto> obterLista() {
		return (Collection<Produto>) produtoRepository.findAll();
		
	}
	
	public Collection<Produto> obterLista(Usuario usuario) {
		return (Collection<Produto>) produtoRepository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "nome"));
		
	}
	
	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}


}