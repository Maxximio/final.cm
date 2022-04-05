package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IVehiculoRepo;
import ec.edu.uce.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepo vehiRepo;

	@Override
	public Vehiculo buscarService(Integer id) {
		return this.vehiRepo.buscar(id);
	}

	@Override
	public Vehiculo buscarPlacaService(String placa) {
		return this.vehiRepo.buscarPlaca(placa);
	}

	@Override
	public List<Vehiculo> buscarTodosService() {
		return this.vehiRepo.buscarTodos();
	}

	@Override
	public void actualizarService(Vehiculo vehiculo) {
		this.vehiRepo.actualizar(vehiculo);
	}

	@Override
	public void insertarService(Vehiculo vehiculo) {
		this.vehiRepo.insertar(vehiculo);
	}

	@Override
	public void borrarService(Integer id) {
		this.vehiRepo.borrar(id);
	}

	@Override
	public List<Vehiculo> buscarModeloMarcaService(String modelo, String marca) {
		return this.vehiRepo.buscarModeloMarca(modelo, marca);
	}

}
