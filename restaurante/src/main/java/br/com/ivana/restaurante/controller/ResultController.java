package br.com.ivana.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ivana.restaurante.repository.VotoFuncionarioRepository;

@Controller
public class ResultController {

	
	@Autowired
	VotoFuncionarioRepository repoVoto;
	
	@RequestMapping(value="/result", method= RequestMethod.GET)
	
	public ModelAndView result() {
		ModelAndView mv= new ModelAndView("result");
		
	}
}
