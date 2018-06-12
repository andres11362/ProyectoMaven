package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.entity.Factura;

@Repository
public class FacturaDaoImpl implements IFacturaDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Factura").getResultList();
	}

	@Override
	public void save(Factura factura) {
		// TODO Auto-generated method stub
		if(factura.getId() != null && factura.getId() >0) {
			em.merge(factura);
		}else {
			em.persist(factura);
		}
	}

	@Override
	public Factura findOne(Long id) {
		// TODO Auto-generated method stub	
		return em.find(Factura.class, id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}

}
