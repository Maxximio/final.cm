package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Cliente;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> buscarTodos() {
		TypedQuery<Cliente> myQuery=(TypedQuery<Cliente>)
				this.entityManager.createQuery("SELECT c FROM Cliente c   ",
						Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Cliente paci) {
		this.entityManager.merge(paci);
	}

	@Override
	public void insertar(Cliente paci) {
		this.entityManager.persist(paci);
	}

	@Override
	public void borrar(Integer id) {
		Cliente paci=this.buscar(id);
		this.entityManager.remove(paci);
	}

	@Override
	public Cliente buscarCedula(String ced) {
		Query miQuery= this.entityManager.createNativeQuery("select * from cliente c where c.clie_cedula=:valor",Cliente.class);
		miQuery.setParameter("valor", ced);
		return (Cliente) miQuery.getSingleResult();
	}

}
