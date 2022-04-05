package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Reserva;

public interface IReservaService {

	public Reserva buscarService(Integer id);
	
	public Reserva buscarNumeroService(String numero);
	
	public List<Reserva> buscarTodosService();
	
	public void actualizarService(Reserva reserva);
	
	public void insertarService(Reserva reserva);
	
	public void borrarService(String num);
	
}
