package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Cliente;

public interface IClienteRepo {

	public Cliente buscar(Integer id);
	
	public Cliente buscarCedula(String ced);
	
	public List<Cliente> buscarTodos();
	
	public void actualizar(Cliente clie);
	
	public void insertar(Cliente clie);
	
	public void borrar(Integer id);
	
}
