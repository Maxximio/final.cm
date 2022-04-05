package ec.edu.uce.repository.report;

import java.util.List;

import ec.edu.uce.repository.modelo.report.ReportClientesVip;
import ec.edu.uce.repository.modelo.report.ReportVehiculosVip;

public interface IReporteRepo {

	public void insertarReCli(ReportClientesVip cli);
	
	public void actualizarReCli(ReportClientesVip cli);
	
	
	
	public void insertarReVe(ReportVehiculosVip veh);
	
	public void actualizarReVe(ReportVehiculosVip veh);

	public List<ReportClientesVip> buscarTodosCli();

	public List<ReportVehiculosVip> buscarTodosVeh();
	
}
