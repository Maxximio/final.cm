package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.ICobroRepo;
import ec.edu.uce.repository.modelo.Cobro;

@Service
public class CobroServiceImpl implements ICobroService{

	@Autowired
	private ICobroRepo cobroRepo;

	@Override
	public Cobro buscarService(Integer id) {
		return this.cobroRepo.buscar(id);
	}

	@Override
	public Cobro buscarTarjetaService(String tarjeta) {
		return this.cobroRepo.buscarTarjeta(tarjeta);
	}

	@Override
	public List<Cobro> buscarTodosService() {
		return this.cobroRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Cobro cobro) {
		this.cobroRepo.actualizar(cobro);
	}

	@Override
	public void insertarService(Cobro cobro) {
		this.cobroRepo.insertar(cobro);
	}

	@Override
	public void borrarService(String tarj) {
		this.cobroRepo.borrar(tarj);
	}
	
	
	
}
