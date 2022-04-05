package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Reserva;

public interface IReservaRepo {

	public Reserva buscar(Integer id);
	
	public Reserva buscarNumero(String numero);
	
	public List<Reserva> buscarTodos();
	
	public void actualizar(Reserva reserva);
	
	public void insertar(Reserva reserva);
	
	public void borrar(String num);
	
}
