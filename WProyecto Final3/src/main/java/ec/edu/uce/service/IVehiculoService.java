package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Vehiculo;

public interface IVehiculoService {
	
	public Vehiculo buscarService(Integer id);
	
	public Vehiculo buscarPlacaService(String placa);
	
	public List<Vehiculo> buscarTodosService();
	
	public void actualizarService(Vehiculo vehiculo);
	
	public void insertarService(Vehiculo vehiculo);
	
	public void borrarService(Integer id);
	
	public List <Vehiculo> buscarModeloMarcaService(String modelo, String marca);
	
}
