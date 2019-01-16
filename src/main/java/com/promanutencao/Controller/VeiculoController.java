package com.promanutencao.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.promanutencao.Repository.*;
import com.promanutencao.Model.*;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("veiculos/listar");
		modelAndView.addObject("veiculos", veiculoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/novo")
	//@RequestMapping(method = {RequestMethod.GET}, value="/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("/veiculos/novo");
		mv.addObject("dados_veiculo", new Veiculo()); //Tenho que passar um objeto vazio para não dá problema na edição
		return mv;
	}
	
	@GetMapping("salvar")
	//@RequestMapping(method = {RequestMethod.GET}, value="/salvar")
	public String salvar(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
		return "redirect:/veiculos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		veiculoRepository.deleteById(id);;
		attributes.addFlashAttribute("removido", "Veiculo removido com sucesso!"); //addFlashAttribute atribui uma mensagem na tela.
		return "redirect:/veiculos";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id); //Pega os dados do veiculo
		ModelAndView mv = new ModelAndView("/veiculos/novo");
		mv.addObject("dados_veiculo", veiculo.get());
		return mv;
	}
	
}
