package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {

	public Producto buscarPorCodigoBarras(String codigoBarras);
	
	public List<Producto> buscarTodos();

}
