package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Cobro;

	public interface ICobroRepo {

	public Cobro buscar(Integer id);
	
	public Cobro buscarTarjeta(String tarjeta);
	
	public List<Cobro> buscarTodos();
	
	public void actualizar(Cobro cobro);
	
	public void insertar(Cobro cobro);
	
	public void borrar(String tarjeta);
	
}
