package br.com.ivana.restaurante.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.ivana.restaurante.model.Funcionario;
import br.com.ivana.restaurante.model.Restaurante;
import br.com.ivana.restaurante.model.VotoFuncionario;
import br.com.ivana.restaurante.repository.FuncionarioRepository;
import br.com.ivana.restaurante.repository.RestauranteRepository;
import br.com.ivana.restaurante.repository.VotoFuncionarioRepository;

@Controller
public class VotoFuncionarioController {

	@Autowired
	VotoFuncionarioRepository repoVotoFunc;
	@Autowired
	FuncionarioRepository repoFunc;
	@Autowired
	RestauranteRepository repoRest;
	
	@RequestMapping(value="/votoFunc",  method = RequestMethod.GET)
	public ModelAndView newVotoFunc() {
	
		ModelAndView mv = new ModelAndView("votoFunc");
		Iterable<Funcionario> func = repoFunc.findAll();
		Iterable<Restaurante> rest= repoRest.findAll();
		mv.addObject("func", func);
		mv.addObject("rest",rest);		
		return mv;	
	}
	
	@RequestMapping(value = "/votoFunc", method = RequestMethod.POST)
	public String votoFunc( @Valid VotoFuncionario v, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Check the camps");
			System.out.println("Erro: "+result.toString());
			return "redirect:/votoFunc";
		}
		attributes.addFlashAttribute("mensagem", "Vote save with sucess!");	
		
		repoVotoFunc.save(v);
		return "redirect:/votoFunc";

	}
	
	
}
