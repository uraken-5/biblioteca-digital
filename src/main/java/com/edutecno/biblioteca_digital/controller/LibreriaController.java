package com.edutecno.biblioteca_digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.biblioteca_digital.modelo.Libro;
import com.edutecno.biblioteca_digital.service.LibreriaService;

@Controller
public class LibreriaController {
	
	@Autowired
	private LibreriaService libreriaService;
	
	@GetMapping("/")
	public String obtenerLibros(Model model) {
		model.addAttribute("libros", libreriaService.obtenerLibros());
		return "book_list";
	}
	
	@GetMapping("/guardarLibro")
	public String mostrarFormulario() {
		return "book_form";
	}
	
	@PostMapping("/guardarLibro")
	public String guardarLibro(@RequestParam("titulo") String titulo, @RequestParam("autor") String autor,@RequestParam("descripcion") String descripcion,Model model) {
		if(titulo.isEmpty() || autor.isEmpty()) {
			model.addAttribute("error","El titulo y el autor son obligatorios");
			return "book_form";
		}
		libreriaService.guardarLibro(titulo, autor, descripcion);
		return "redirect:/";	
	}
	
	@GetMapping("/libro")
	public String obtenerDetalle(@RequestParam("id") Long id, Model model) {
		Libro libro = libreriaService.obtenerLibroPorId(id);
		if(libro == null) {
			model.addAttribute("error","Libro no encontrado");
			return "book_list";
		}
		model.addAttribute("libro", libro);
		return "book_details";
	}
}
