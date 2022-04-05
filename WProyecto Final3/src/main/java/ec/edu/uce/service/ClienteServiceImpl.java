package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IClienteRepo;
import ec.edu.uce.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo clieRepo;

	@Override
	public Cliente buscarService(Integer id) {
		return this.clieRepo.buscar(id);
	}

	@Override
	public Cliente buscarCedulaService(String ced) {
		return this.clieRepo.buscarCedula(ced);
	}

	@Override
	public List<Cliente> buscarTodosService() {
		return this.clieRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Cliente clie) {
		this.clieRepo.actualizar(clie);
	}

	@Override
	public void insertarService(Cliente clie) {
		this.clieRepo.insertar(clie);
	}

	@Override
	public void borrarService(Integer id) {
		this.clieRepo.borrar(id);
	}


}
