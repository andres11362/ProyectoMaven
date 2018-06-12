package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.entity.Producto;

@Repository
public class ProductoDaoImpl implements IProductoDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList();
	}

	@Override
	public void save(Producto producto) {
		if(producto.getId() != null && producto.getId() >0) {
			em.merge(producto);
		}else {
			em.persist(producto);
		}
		
	}

	@Override
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Producto.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

	

}
