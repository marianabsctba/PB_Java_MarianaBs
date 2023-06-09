package br.edu.infnet.donationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.donationapp.model.domain.Doador;
import br.edu.infnet.donationapp.model.domain.Endereco;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.DoadorService;

@Controller
public class DoadorController {
	
@Autowired	
	private DoadorService doadorService;
	

	private String msg;

	@GetMapping(value = "/doador")
	public String telaCadastro() {
		return "doador/cadastro";
	}

	@GetMapping(value = "/doador/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("doadores", doadorService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		msg = null;
		
		return "doador/lista";
	}

	@PostMapping(value = "/doador/incluir")
	public String incluir(Doador doador, Endereco endereco,  @SessionAttribute("user") Usuario usuario) {
		
		doador.setUsuario(usuario);
		doador.setEndereco(endereco);
		
		doadorService.incluir(doador);

		msg = "Doador " + doador.getNome() + " criado com sucesso!";


		return "redirect:/doador/lista";
	}
	
	@GetMapping(value = "/doador/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		try {
			doadorService.excluir(id);
			
			msg = "A exclusão do doador realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do doador!!!";
		}
		


		return "redirect:/doador/lista";
	}

}