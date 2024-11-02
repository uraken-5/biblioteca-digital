package com.edutecno.biblioteca_digital.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {
	private Long id;
	private String titulo;
	private String autor;
	private String descripcion;
}
