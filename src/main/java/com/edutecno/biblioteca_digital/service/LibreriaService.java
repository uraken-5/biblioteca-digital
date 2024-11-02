package com.edutecno.biblioteca_digital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edutecno.biblioteca_digital.modelo.Libro;

@Service
public class LibreriaService {
	private List<Libro> libros = new ArrayList<>();
	private AtomicLong contadorId = new AtomicLong();
	private static final Logger logger = LoggerFactory.getLogger(LibreriaService.class);
	
	public List<Libro> obtenerLibros(){
		logger.info("Ingresando al metodo obtenerLibros - linea 18 LibreriaServices");
		return libros;
	}
	
	//guardar libros
	public Libro guardarLibro(String titulo, String autor, String descripcion) {
		Libro libroNuevo = new Libro(contadorId.getAndIncrement(), titulo, autor, descripcion);
		libros.add(libroNuevo);
		logger.info("Se a agregado el libro " + titulo);
		return libroNuevo;
	}
	
	//obtener libro por su ID
	public Libro obtenerLibroPorId(Long id) {
		return libros.stream()
				.filter(libro -> libro.getId().equals(id))
				.findFirst().orElse(null);
	}
	
}
