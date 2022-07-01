package com.example.rbenitec.springbootapp.repository;

import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.rbenitec.springbootapp.entities.Categoria;
import com.example.rbenitec.springbootapp.entities.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository{

	private static Logger log = LoggerFactory.getLogger(ProductoRepositoryImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//Metodo para listar productos
	@Override
	public List<Producto> listar() throws Exception {
		
		String query="SELECT p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio, p.creado, p.estado FROM productos p INNER JOIN categorias c ON c.id=p.categorias_id WHERE estado=1 ORDER BY id";
		
		List<Producto> productos = jdbcTemplate.query(query, new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Producto p = new Producto();
				p.setId(rs.getLong("id"));
				p.setCategorias_id(rs.getLong("categorias_id"));
				
				Categoria categoria = new Categoria();
				categoria.setId(rs.getLong("categorias_id"));
				categoria.setNombre(rs.getString("categorias_nombre"));
				p.setCategoria(categoria);
				
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				
				p.setPrecio(rs.getDouble("precio"));
				if(rs.wasNull()) p.setPrecio(null);
				
				p.setStock(rs.getInt("stock"));
				p.setImagen_nombre(rs.getString("imagen_nombre"));
				p.setImagen_tipo(rs.getString("imagen_tipo"));
				
				p.setImagen_tamanio(rs.getLong("imagen_tamanio"));
				if(rs.wasNull()) p.setImagen_tamanio(null);
				
				p.setEstado(rs.getInt("estado"));
				
				return p;
			}
			
		});
		log.info("Productos: " + productos);
		return productos;
	}
	
	//Metodo para Registrar un Producto
	
	@Override
	public void registrar(Producto producto) throws Exception {
		
		log.info("Call registrar: (Producto: "+producto+")");
		
		String query="INSERT INTO productos (categorias_id, nombre, descripcion, precio, stock, imagen_nombre, imagen_tipo, imagen_tamanio) VALUES(?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(query, producto.getCategorias_id(),
								   producto.getNombre(),
								   producto.getDescripcion(),
								   producto.getPrecio(),
								   producto.getStock(),
								   producto.getImagen_nombre(),
								   producto.getImagen_tipo(),
								   producto.getImagen_tamanio());
	}
	
	//Metodo para Modificar el nombre de un producto.

	@Override
	public void modificar(Long id, String nombreProducto) throws Exception {
		log.info("Call Update name: (with id:"+id+")");
		
		String query= "UPDATE productos SET nombre=? where id=?";
		
		jdbcTemplate.update(query,nombreProducto, id);
		
	}

	//Metodo para Eliminar un producto
	@Override
	public void eliminar(Long id) throws Exception {
		
		log.info("Call Eliminar: (El id: "+id+")");
		
		String query="SELECT p.id, p.categorias_id, c.nombre AS categorias_nombre, p.nombre, p.descripcion, p.precio, p.stock, p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio, p.creado, p.estado FROM productos p INNER JOIN categorias c ON c.id=p.categorias_id WHERE estado=1 and p.nombre=? ORDER BY id";
		
		jdbcTemplate.update(query, id);
		
	}

	//Encontrar un producto por nombre.
	
	@Override
	public List<Producto> findByName(String nombre) throws Exception {
		log.info("Call findByNombre: (Nombre: "+nombre+")");
		String query = "select * from productos where nombre=?";
		
		List<Producto> listFind = jdbcTemplate.query(query, new Object[] {nombre}, new RowMapper<Producto>() {

			@Override
			public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Producto p = new Producto();
				p.setId(rs.getLong("id"));
				p.setCategorias_id(rs.getLong("categorias_id"));
				
				Categoria categoria = new Categoria();
				categoria.setId(rs.getLong("categorias_id"));
				categoria.setNombre(rs.getString("categorias_nombre"));
				p.setCategoria(categoria);
				
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				
				p.setPrecio(rs.getDouble("precio"));
				if(rs.wasNull()) p.setPrecio(null);
				
				p.setStock(rs.getInt("stock"));
				p.setImagen_nombre(rs.getString("imagen_nombre"));
				p.setImagen_tipo(rs.getString("imagen_tipo"));
				
				p.setImagen_tamanio(rs.getLong("imagen_tamanio"));
				if(rs.wasNull()) p.setImagen_tamanio(null);
				
				p.setEstado(rs.getInt("estado"));
				
				return p;
			}
			
		});
		
		return null;
	}

}
