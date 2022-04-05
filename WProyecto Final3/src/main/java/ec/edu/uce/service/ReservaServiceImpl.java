package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IReservaRepo;
import ec.edu.uce.repository.modelo.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaRepo reservaRepo;

	@Override
	public Reserva buscarService(Integer id) {
		return this.reservaRepo.buscar(id);
	}

	@Override
	public Reserva buscarNumeroService(String numero) {
		return this.reservaRepo.buscarNumero(numero);
	}

	@Override
	public List<Reserva> buscarTodosService() {
		return this.reservaRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Reserva reserva) {
		this.reservaRepo.actualizar(reserva);
	}

	@Override
	public void insertarService(Reserva reserva) {
		this.reservaRepo.insertar(reserva);
	}

	@Override
	public void borrarService(String num) {
		this.reservaRepo.borrar(num);
	}
	
}
