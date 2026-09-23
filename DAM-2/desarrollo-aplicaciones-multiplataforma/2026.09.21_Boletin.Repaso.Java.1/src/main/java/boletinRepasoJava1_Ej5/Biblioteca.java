package boletinRepasoJava1_Ej5;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Biblioteca {
    String nombre;
    String direccion;
    int horario;
    int telefono;
    Set<Libro> libros = Collections.emptySet();
    List<Cliente> clientes = new ArrayList<>();
    List<Vendedor> vendedores = new ArrayList<>();

    public Biblioteca(String nombre, String direccion, int horario, int telefono, Set<Libro> libros, List<Cliente> clientes, List<Vendedor> vendedores) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.telefono = telefono;
        this.libros = libros;
        this.clientes = clientes;
        this.vendedores = vendedores;
    }

    public void registrarLibro(Libro libroARegistrar) {
        libros.add(libroARegistrar);
    }

    public void eliminarLibro(Libro libroAEliminar) {
        libros.remove(libroAEliminar);
    }

    public void registrarCliente(Cliente clienteARegistrar) {
        clientes.add(clienteARegistrar);
    }

    public void eliminarCliente(Cliente clienteAEliminar) {
        clientes.remove(clienteAEliminar);
    }

    public List<Cliente> obtenerCliente() {
        return clientes;
    }

    public void registrarVendedor(Vendedor vendedorARegistrar) {
        vendedores.add(vendedorARegistrar);
    }

    public void eliminarVendedor(Vendedor vendedorAEliminar) {
        vendedores.remove(vendedorAEliminar);
    }

    public Set<Libro> obtenerLibros() {
        return this.libros;
    }

}
