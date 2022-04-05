package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Cobro;

public interface ICobroService {

		public Cobro buscarService(Integer id);
		
		public Cobro buscarTarjetaService(String tarjeta);
		
		public List<Cobro> buscarTodosService();
		
		public void actualizarService(Cobro cobro);
		
		public void insertarService(Cobro cobro);
		
		public void borrarService(String tarj);
	
}
