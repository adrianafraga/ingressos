package com.qintess.ingressos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.ingressos.dao.Dao;
import com.qintess.ingressos.entidade.Evento;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private Dao dao;
	
	
	@RequestMapping("")
	public String carrega (Model model) {
		
		model.addAttribute("eventos", dao.buscaTodos(Evento.class));
		model.addAttribute("evento", new Evento());
		return "evento";
			
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Evento evento) {
		if(evento.getId()==0) {
		dao.salva(evento);
		}else {
			dao.altera(evento);
		}
		return "redirect:/evento";
		
	}
	@RequestMapping("/deleta/{id}")
	public String deleta(@PathVariable(name="id")int id) {
		Evento evento = dao.buscaPorId(Evento.class, id);
		dao.deleta(evento);
		return "redirect:/evento";
	}
	
	@RequestMapping("/altera/{id}")
	public String carregaAlterar(@PathVariable(name="id")int id, Model model) {
		
		model.addAttribute("eventos", dao.buscaTodos(Evento.class));
		model.addAttribute("evento", dao.buscaPorId(Evento.class, id));
		return "evento";
	}

}
