package ec.edu.uce;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.repository.modelo.Cobro;
import ec.edu.uce.repository.modelo.Vehiculo;
import ec.edu.uce.service.IGestorService;
import ec.edu.uce.service.IVehiculoService;

@SpringBootTest
@Rollback(true)
@Transactional
class AplicativoTest {

	@Autowired
	private IGestorService gestorService;
	
	@Autowired
	private IVehiculoService vehiService;
	
	@Test
	void testTabla() {
		
		List<Vehiculo> v =this.vehiService.buscarModeloMarcaService("Aveo", "Chevrolet");
		
		assertEquals("[ec.edu.uce.repository.modelo.Vehiculo@47e70f54]", v);
	}
	
	@Test
	void testTabla2() {
		
		List<Vehiculo> v =this.gestorService.vehiculosDisponibles( "Aveo","Chevrolet");
		
		assertEquals("Chevrolet", v);
	}
	
//	@Test
//	void testTabla3() {
//		
//		List<Cobro> c =this.gestorService.reservar( );
//		
//		assertEquals("Chevrolet", c);
//	}
	
	
	@BeforeEach
	void datos() {
		Vehiculo veh=new Vehiculo();
		veh.setPlaca("ASD876");
		veh.setMarca("Chevrolet");
		veh.setModelo("Aveo");
		veh.setAnioFab(null);
		veh.setCilindraje("2000cc");
		veh.setAvaluo(new BigDecimal(10000.00));
		veh.setPais("China");
		veh.setEstado("D");
		veh.setValorDia(new BigDecimal(150.00));
		
		//gestorService.ingresarVehiculo(null, null, null, null, null, null, null, null);
		vehiService.insertarService(veh);
		
	}

}
