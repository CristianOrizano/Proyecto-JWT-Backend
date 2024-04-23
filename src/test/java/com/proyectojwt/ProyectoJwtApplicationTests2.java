package com.proyectojwt;

import com.proyectojwt.dto.categoria.CategoriaDto;
import com.proyectojwt.dto.categoria.CategoriaSaveDto;
import com.proyectojwt.dto.empleado.EmpleadoDTO;
import com.proyectojwt.entity.Categoria;
import com.proyectojwt.entity.Producto;
import com.proyectojwt.entity.Usuario;
import com.proyectojwt.repository.CategoriaRepository;
import com.proyectojwt.service.ICategoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProyectoJwtApplicationTests2 {

	@Autowired
	ICategoria categoriaService;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Test
	void contextLoads() {
		Categoria save = new Categoria();
		save.setCodigocate(22L);
		save.setNombre("Deportr");
		save.setDescripcion("para laptop");
		save.setState(true);

		//insertar en ambas tablas
		/*List<Producto> productos = new ArrayList<>();
		Producto productoNuevo = new Producto();
		productoNuevo.setDescripcion("nombre_del_producto");
		productoNuevo.setStock(10); // Ejemplo de un valor para el stock
		productoNuevo.setPrecio(20.0); // Ejemplo de un valor para el precio
		productoNuevo.setMarca("marca_del_producto");
		productoNuevo.setNimagen("imagen_del_producto");
		System.out.println("CONSOLA==========>"+ save.getCodigocate());
		productoNuevo.setCate(save);
		productos.add(productoNuevo);
		save.setListaCategorias(productos);
		categoriaRepository.save(save); */

		//eliminacion en cascada
		//categoriaRepository.deleteById(25L);

		System.out.println("CONSOLA==========>");
	}

}
