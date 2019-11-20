package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Previsao;
import br.usjt.hellospringboot.service.PrevisaoService;

@Controller
public class PrevisaoController {
	@Autowired
	private PrevisaoService previsaoService;

	@GetMapping ("/previsoes")
	public ModelAndView listarDados () {
		//passe o nome da página ao construtor
		ModelAndView mv = new ModelAndView ("lista_previsoes");
		//Busque a coleção com o repositório
		List <Previsao> temp = previsaoService.listarTodos();
		//adicione a coleção ao objeto ModelAndView
		mv.addObject("previsoes", temp);
		mv.addObject(new Previsao());
		//devolva o ModelAndView
		return mv;
	}

	@PostMapping
	public String salvar (Previsao temp) {
		previsaoService.salvar(temp);
		return "redirect:/previsoes";
	}
}





