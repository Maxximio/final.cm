package ec.edu.uce.service.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;
import ec.edu.uce.repository.report.IReporteRepo;

@Service
public class ReporteServiceImpl implements IReportService{

	@Autowired
	private IReporteRepo reporRepo;
	
	@Override
	public void insertarReCliService(ReportClientesVip cli) {
		this.reporRepo.insertarReCli(cli);
	}

	@Override
	public void actualizarReCliService(ReportClientesVip cli) {
		this.reporRepo.actualizarReCli(cli);
	}

	@Override
	public void insertarReVeService(ReportVehiculosVip veh) {
		this.reporRepo.insertarReVe(veh);
	}

	@Override
	public void actualizarReVeService(ReportVehiculosVip veh) {
		this.reporRepo.actualizarReVe(veh);
	}

	@Override
	public List<ReportClientesVip> buscarTodosCliService() {
		return this.reporRepo.buscarTodosCli();
	}

	@Override
	public List<ReportVehiculosVip> buscarTodosVehService() {
		return this.reporRepo.buscarTodosVeh();
	}

}
