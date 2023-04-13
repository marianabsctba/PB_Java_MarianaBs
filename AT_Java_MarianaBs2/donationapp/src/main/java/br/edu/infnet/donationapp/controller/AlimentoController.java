package br.edu.infnet.donationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.donationapp.model.domain.Alimento;
import br.edu.infnet.donationapp.model.domain.Usuario;
import br.edu.infnet.donationapp.model.service.AlimentoService;

@Controller
public class AlimentoController {
	
	@Autowired	
	private AlimentoService alimentoService;


	private String msg;

	@GetMapping(value = "/alimento")
	public String telaCadastro() {
		return "produto/alimento/cadastro";
	}

	@GetMapping(value = "/alimento/lista")
	public String telaLista(Model model,  @SessionAttribute ("user") Usuario usuario) {

		model.addAttribute("alimentos", alimentoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		msg = null;

		return "produto/alimento/lista";
	}

	@PostMapping(value = "/alimento/incluir")
	public String incluir(Alimento alimento, @SessionAttribute ("user") Usuario usuario) {
		System.out.println("Cadastrado com sucesso!!" + alimento.toString());
		
		alimento.setUsuario(usuario);

		alimentoService.incluir(alimento);
		
		msg = "alimento " + alimento.getNome() + " criado com sucesso!";


		return "redirect:/alimento/lista";
	}

	@GetMapping(value = "/alimento/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Alimento alimento = alimentoService.obterPorId(id);

		try {
			alimentoService.excluir(id);
			
			msg = "A exclusão do item "+alimento.getNome()+" foi realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Impossível realizar a exclusão do produto "+alimento.getNome()+"!!!";
		}
		

		return "redirect:/alimento/lista";
	}

}
