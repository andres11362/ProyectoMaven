package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="facturas")
public class Factura implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@ManyToMany(mappedBy="listaFactura")
	private List<Producto> listaProductos;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	public Factura() {
		super();
	}

	public Factura(Long id, String nombre, List<Producto> listaProductos, Cliente cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaProductos = listaProductos;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", nombre=" + nombre + ", listaProductos=" + listaProductos + ", cliente="
				+ cliente + "]";
	}
	
	public double Subtotal(List<Producto> listaProducto) {
		double suma = 0;
		
		for (int i = 0; i < listaProducto.size(); i++) {
			suma = suma + listaProducto.get(i).getPrecio();
		}
		return suma;
	}
	
	public double Iva(List<Producto> listaProducto, double valor) {
		double suma = 0;
		
		for (int i = 0; i < listaProducto.size(); i++) {
			suma = suma + (listaProducto.get(i).getPrecio()*valor);
		}
		
		return suma;
	}
	
	public double Total() {
		double total = Iva(getListaProductos(), 0.19) + Subtotal(getListaProductos());
		
		return total;
	}
	

}
