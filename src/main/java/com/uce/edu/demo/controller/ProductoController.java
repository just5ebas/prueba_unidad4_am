package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoStock;
import com.uce.edu.demo.service.IGestorVentasService;
import com.uce.edu.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IGestorVentasService iGestorVentasService;

	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Producto> lista = this.iProductoService.buscarTodos();
		modelo.addAttribute("productos", lista);
		return "vistaListaProductos";
	}

	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		this.iGestorVentasService.insertarProducto(producto);
		return "redirect:/productos/buscar";
	}

	@GetMapping("/stock")
	public String consultarStock(ProductoStock producto, Model modelo) {
		this.iGestorVentasService.consultarStock(null);
		modelo.addAttribute(producto);
		return "vistaProducto";
	}

	// Metodos de redireccionamiento a paginas
	@GetMapping("/nuevoProducto")
	public String paginaNuevaProducto(Producto producto) {
		return "vistaNuevoProducto";
	}

	@GetMapping("/buscarProducto")
	public String paginaBuscarProducto(String codBarras) {
		return "vistaBuscarProducto";
	}

}
