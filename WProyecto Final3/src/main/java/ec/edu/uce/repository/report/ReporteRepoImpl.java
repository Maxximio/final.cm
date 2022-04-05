package ec.edu.uce.repository.report;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;

@Transactional
@Repository
public class ReporteRepoImpl implements IReporteRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarReCli(ReportClientesVip cli) {
		this.entityManager.persist(cli);
	}

	@Override
	public void actualizarReCli(ReportClientesVip cli) {
		this.entityManager.merge(cli);
	}
	
	@Override
	public List<ReportClientesVip> buscarTodosCli() {
		TypedQuery<ReportClientesVip> myQuery=(TypedQuery<ReportClientesVip>)
				this.entityManager.createQuery("SELECT c FROM ReportClientesVip c   ",
						ReportClientesVip.class);
		return myQuery.getResultList();
	}
	

	@Override
	public void insertarReVe(ReportVehiculosVip veh) {
		this.entityManager.persist(veh);
	}

	@Override
	public void actualizarReVe(ReportVehiculosVip veh) {
		this.entityManager.merge(veh);
	}
	
	
	@Override
	public List<ReportVehiculosVip> buscarTodosVeh() {
		TypedQuery<ReportVehiculosVip> myQuery=(TypedQuery<ReportVehiculosVip>)
				this.entityManager.createQuery("SELECT c FROM ReportVehiculosVip c   ",
						ReportVehiculosVip.class);
		return myQuery.getResultList();
	}
	
}
