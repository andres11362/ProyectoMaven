package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Factura;

public interface IFacturaService {
	
	public List<Factura> findAll();

	public void save(Factura factura);
	
	public Factura findOne(Long id);
	
	public void delete(Long id);
}
