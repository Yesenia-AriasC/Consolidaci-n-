package com.mintic.lagenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="db_consolidado")
public class Consolidacion {
	@Id
	private Long id;
	private String ciudad; 
	private Double total_venta;
	
	//métodos 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}
	
	
	
}
