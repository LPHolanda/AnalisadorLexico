package br.usjt.transdutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.transdutor.entity.Transdutor;
import br.usjt.transdutor.service.TransdutorService;

@Controller
public class TransdutorController {
	
	@Autowired
	TransdutorService transdutorService;
	
	
	@RequestMapping("Test")
	public String test(Transdutor transdutor, Model model, BindingResult result, String entrada) {
		
		String[] intermediario = entrada.split(" ");
		transdutor = transdutorService.criarArrayAuxiliar(intermediario, transdutor);
		
		transdutor = transdutorService.organizaAuxParaVariaveis(transdutor);
		
		transdutor = transdutorService.organizaSaida(transdutor);
		
		model.addAttribute("transdutor", transdutor);
		
		//RETORNAR EM JSON
		
		return "";
	}

}
