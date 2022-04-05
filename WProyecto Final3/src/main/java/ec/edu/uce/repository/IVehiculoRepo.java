package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Vehiculo;

public interface IVehiculoRepo {

	public Vehiculo buscar(Integer id);
	
	public Vehiculo buscarPlaca(String placa);
	
	public List <Vehiculo> buscarModeloMarca(String modelo, String marca);
	
	public List<Vehiculo> buscarTodos();
	
	public void actualizar(Vehiculo vehiculo);
	
	public void insertar(Vehiculo vehiculo);
	
	public void borrar(Integer id);
	
}
