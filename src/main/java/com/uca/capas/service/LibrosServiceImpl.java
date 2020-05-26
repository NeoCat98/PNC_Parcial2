package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibrosDAO;
import com.uca.capas.domain.Libros;

@Service
public class LibrosServiceImpl implements LibrosService{

	@Autowired
	private LibrosDAO libroDAO;
	
	@Override
	public List<Libros> findAll() throws DataAccessException {
		return libroDAO.findAll();
	}

	@Override
	public Libros findOne(Integer id) throws DataAccessException {
		return libroDAO.findOne(id);
	}

	@Override
	public void insert(Libros libro) throws DataAccessException {
		libroDAO.insert(libro);
	}

}
