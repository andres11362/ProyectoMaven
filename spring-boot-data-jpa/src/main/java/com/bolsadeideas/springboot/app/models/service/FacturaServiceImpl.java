package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IFacturaDao;
import com.bolsadeideas.springboot.app.models.entity.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaDao facturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return facturaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Factura factura) {
		// TODO Auto-generated method stub
		facturaDao.save(factura);
	}

	@Override
	public Factura findOne(Long id) {
		// TODO Auto-generated method stub
		return facturaDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		facturaDao.delete(id);
	}

}
