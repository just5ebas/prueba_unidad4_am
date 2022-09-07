package com.uce.edu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.ProductoCompra;
import com.uce.edu.demo.service.IGestorVentasService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IGestorVentasService iGestorVentasService;

	@PostMapping("/comprar")
	public String comprarProducto(ProductoCompra productoCompra) {
		List<ProductoCompra> lista = new ArrayList<>();
		lista.add(productoCompra);
		this.iGestorVentasService.realizarVenta(lista, productoCompra.getCedula(), productoCompra.getNumeroVenta());
		return "redirect:/productos/buscar";
	}

	// Metodos de redireccionamiento a paginas
	@GetMapping("/comprarProducto")
	public String paginaComprarProducto(ProductoCompra productoCompra) {
		return "vistaComprarProducto";
	}

}
