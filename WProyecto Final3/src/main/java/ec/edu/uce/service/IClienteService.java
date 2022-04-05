package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Cliente;

public interface IClienteService {
	
	public Cliente buscarService(Integer id);
	
	public Cliente buscarCedulaService(String ced);
	
	public List<Cliente> buscarTodosService();
	
	public void actualizarService(Cliente clie);
	
	public void insertarService(Cliente clie);
	
	public void borrarService(Integer id);
	
}
