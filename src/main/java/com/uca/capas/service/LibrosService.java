package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libros;

public interface LibrosService {
	public List<Libros> findAll() throws DataAccessException;
	public Libros findOne(Integer id) throws DataAccessException;
	public void insert(Libros libro) throws DataAccessException;
}
