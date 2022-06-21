package com.example.rbenitec.springbootapp.entities;

public class Categoria {
	
	private long id;
	private String nombre;
	private Integer orden;
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", orden=" + orden + "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
	

}
