package com.uce.edu.demo.repository.modelo;

// Producto Sencillo para compra
public class ProductoCompra {

	private String codigoBarras;
	private Integer cantidad;
	private String cedula;
	private String numeroVenta;

	@Override
	public String toString() {
		return "ProductoCompra [codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + "]";
	}

	// GET & SET
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(String numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

}
