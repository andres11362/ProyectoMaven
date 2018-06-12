package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();

	public void save(Producto producto);
	
	public Producto findOne(Long id);
	
	public void delete(Long id);

}
