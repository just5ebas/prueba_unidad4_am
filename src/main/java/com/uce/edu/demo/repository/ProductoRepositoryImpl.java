package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM producto_u3 WHERE prod_codigo_barras = :codigoBarras", Producto.class);
		myQuery.setParameter("codigoBarras", codigoBarras);
		return (Producto) myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<String> consultarCodigosBarras() {
		// TODO Auto-generated method stub
		TypedQuery<String> myQuery = this.entityManager.createQuery("SELECT p.codigoBarras FROM Producto p",
				String.class);
		return myQuery.getResultList();
	}

}
