package br.com.ivana.restaurante.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.ivana.restaurante.model.Restaurante;

import br.com.ivana.restaurante.repository.RestauranteRepository;

@Controller
public class RestauranteController {

	@Autowired
	RestauranteRepository repoRest;

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String newFunc() {
		return "restaurante";
	}

	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String form(@Valid Restaurante r, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Check the camps");
			System.out.println("Erro: "+result.toString());
			return "redirect:/rest";
		}
		attributes.addFlashAttribute("mensagem", "Restaurant save with sucess!");
		repoRest.save(r);
		return "redirect:/rest";

	}

	@RequestMapping(value = "/listRest", method = RequestMethod.GET)
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("listRest");
		Iterable<Restaurante> restaurantes = repoRest.findAll();
		mv.addObject("rest", restaurantes);
		return mv;
	}
}
