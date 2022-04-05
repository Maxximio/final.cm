package ec.edu.uce.service.report;

import java.util.List;

import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;

public interface IReportService {

	public void insertarReCliService(ReportClientesVip cli);
	
	public void actualizarReCliService(ReportClientesVip cli);
	
	
	
	public void insertarReVeService(ReportVehiculosVip veh);
	
	public void actualizarReVeService(ReportVehiculosVip veh);
	
	

	public List<ReportClientesVip> buscarTodosCliService();

	public List<ReportVehiculosVip> buscarTodosVehService();
}
