package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Cobro;

@Transactional
@Repository
public class CobroRepoImpl implements ICobroRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cobro buscar(Integer id) {
		return this.entityManager.find(Cobro.class, id);
	}

	@Override
	public Cobro buscarTarjeta(String tarjeta) {
		Query miQuery= this.entityManager.createNativeQuery
				("select * from cobro c where c.cobro_tarjeta=:valor",Cobro.class);
		miQuery.setParameter("valor", tarjeta);
		return (Cobro) miQuery.getSingleResult();
	}

	@Override
	public List<Cobro> buscarTodos() {
		TypedQuery<Cobro> myQuery=(TypedQuery<Cobro>)
				this.entityManager.createQuery("SELECT c FROM Cobro c   ",
						Cobro.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Cobro cobro) {
		this.entityManager.merge(cobro);
	}

	@Override
	public void insertar(Cobro cobro) {
		this.entityManager.persist(cobro);
	}

	@Override
	public void borrar(String tarj) {
		Cobro borrar=this.buscarTarjeta(tarj);
		this.entityManager.remove(borrar);
	}
	
	
	
}
