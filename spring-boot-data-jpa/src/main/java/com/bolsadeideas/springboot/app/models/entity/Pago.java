/**
 * 
 */
package com.bolsadeideas.springboot.app.models.entity;

import java.util.Calendar;

/**
 * @author Usuario
 *
 */
public class Pago {
	private Factura fact;
	private double total;
	private Cliente client;
	private Calendar fecha;
	private String observacion;
	/**
	 * @param fact
	 * @param total
	 * @param client
	 * @param fecha
	 * @param observacion
	 */
	public Pago(Factura fact, double total, Cliente client, Calendar fecha, String observacion) {
		super();
		this.fact = fact;
		this.total = total;
		this.client = client;
		this.fecha = fecha;
		this.observacion = observacion;
	}
	public Factura getFact() {
		return fact;
	}
	public void setFact(Factura fact) {
		this.fact = fact;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Cliente getClient() {
		return client;
	}
	public void setClient(Cliente client) {
		this.client = client;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "Pago [fact=" + fact + ", total=" + total + ", client=" + client + ", fecha=" + fecha + ", observacion="
				+ observacion + "]";
	}
	
	
	
		

}