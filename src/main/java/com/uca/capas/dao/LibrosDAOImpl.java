package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libros;

@Repository
public class LibrosDAOImpl implements LibrosDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Libros> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libros.class);
		List<Libros> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public Libros findOne(Integer id) throws DataAccessException {
		Libros libro = entityManager.find(Libros.class, id);
		return libro;
	}
	
	@Transactional
	@Override
	public void insert(Libros libro) throws DataAccessException {
		entityManager.persist(libro);
	}

}
