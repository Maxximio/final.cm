package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Reserva;

@Transactional
@Repository
public class ReservaRepoImpl implements IReservaRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Reserva buscar(Integer id) {
		return this.entityManager.find(Reserva.class, id);
	}

	@Override
	public Reserva buscarNumero(String numero) {
		Query miQuery= this.entityManager.createNativeQuery
				("select * from reserva r where r.res_numero_reserva=:valor",Reserva.class);
		miQuery.setParameter("valor", numero);
		return (Reserva) miQuery.getSingleResult();	
		}

	@Override
	public List<Reserva> buscarTodos() {
		TypedQuery<Reserva> myQuery=(TypedQuery<Reserva>)
				this.entityManager.createQuery("SELECT r FROM Reserva r   ",
						Reserva.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Reserva reserva) {
		this.entityManager.merge(reserva);
	}

	@Override
	public void insertar(Reserva reserva) {
		this.entityManager.persist(reserva);
	}

	@Override
	public void borrar(String num) {
		Reserva borrar=this.buscarNumero(num);
		this.entityManager.remove(borrar);
	}
	
}
