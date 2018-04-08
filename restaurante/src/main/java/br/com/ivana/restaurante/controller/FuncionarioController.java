package br.com.ivana.restaurante.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.ivana.restaurante.model.Funcionario;
import br.com.ivana.restaurante.repository.FuncionarioRepository;


@Controller
public class FuncionarioController {

	@Autowired
	FuncionarioRepository repoFunc;
	
	@RequestMapping(value="/func", method=RequestMethod.GET)
	public String form() {		
		return "funcionario";
	}
	
	@RequestMapping(value="/func", method=RequestMethod.POST)
	public String form(@Valid Funcionario f,BindingResult result,RedirectAttributes attributes ) {		
				
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Check the camps");
			return  "redirect:/cadastraEvento";
		}
		attributes.addFlashAttribute("mensagem", "Employee save with sucess!");
		repoFunc.save(f);
		return "redirect:/func";
		
	}
	@RequestMapping(value="/listFunc", method=RequestMethod.GET)
	public ModelAndView listaEventos() {
		ModelAndView mv= new ModelAndView("listFunc");
		Iterable<Funcionario> funcionarios= repoFunc.findAll();
		System.out.println("Funcionarios: "+ funcionarios.toString());
		mv.addObject("func", funcionarios);
		return mv;
	}
	

}
