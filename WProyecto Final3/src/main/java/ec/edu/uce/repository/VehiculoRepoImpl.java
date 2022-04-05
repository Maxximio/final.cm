package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Vehiculo;

@Transactional
@Repository
public class VehiculoRepoImpl implements IVehiculoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		TypedQuery<Vehiculo> myQuery=(TypedQuery<Vehiculo>)
				this.entityManager.createQuery("SELECT v FROM Vehiculo v   ",
						Vehiculo.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Vehiculo doc) {
		this.entityManager.merge(doc);
		
	}

	@Override
	public void insertar(Vehiculo doc) {
		this.entityManager.persist(doc);
	}

	@Override
	public void borrar(Integer id) {
		Vehiculo doc=this.buscar(id);
		this.entityManager.remove(doc);
	}

	@Override
	public Vehiculo buscarPlaca(String placa) {
		Query miQuery= this.entityManager.createNativeQuery("select * from vehiculo v where v.vehi_placa=:valor",Vehiculo.class);
		miQuery.setParameter("valor", placa);
		return (Vehiculo) miQuery.getSingleResult();
	}

	@Override
	public List <Vehiculo> buscarModeloMarca(String modelo, String marca) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Vehiculo> myQuery=myCriteria.createQuery(Vehiculo.class);
		
		Root<Vehiculo>myTabla=myQuery.from(Vehiculo.class);
		
		Predicate p1=myCriteria.equal(myTabla.get("modelo"),modelo);
		Predicate p2=myCriteria.equal(myTabla.get("marca"),marca);
		Predicate and=myCriteria.and(p1,p2);
		
		myQuery.select(myTabla).where(and);
		
		TypedQuery<Vehiculo> typedQuery=this.entityManager.createQuery(myQuery);
		
		return typedQuery.getResultList();
	}

}
