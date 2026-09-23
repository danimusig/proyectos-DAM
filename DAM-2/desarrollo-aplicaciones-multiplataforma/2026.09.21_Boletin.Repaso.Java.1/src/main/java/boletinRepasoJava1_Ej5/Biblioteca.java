package boletinRepasoJava1_Ej5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Clase que contiene los datos y accciones  básicas referentes a una biblioteca.
 * @author danielms
 * @version 1.0
 * @see ArrayList
 * @see Collections
 * @see List
 * @see Set
 */
public class Biblioteca {
    /**
     * El nombre de la biblioteca.
     */
    public String nombre;

    /**
     * La direccion de la biblioteca.
     */
    public String direccion;

    /**
     * El horario de la biblioteca.
     */
    public int horario;

    /**
     * El telefono de la biblioteca.
     */
    public int telefono;

    /**
     * Los libros de la biblioteca.
     */
    public Set<Libro> libros = Collections.emptySet();

    /**
     * Los clientes de la biblioteca.
     */
    public List<Cliente> clientes = new ArrayList<>();

    /**
     * Los vendedores de la biblioteca.
     */
    public List<Vendedor> vendedores = new ArrayList<>();


    /**
     * Constructor Principal.
     * @param nombre El nombre de la biblioteca.
     * @param direccion La direccion de la biblioteca.
     * @param horario El horario de la biblioteca.
     * @param telefono El telefono de la biblioteca.
     * @param libros Los libros  de la biblioteca.
     * @param clientes Los clientes  de la biblioteca.
     * @param vendedores Los  vendedores de la biblioteca.
     */
    public Biblioteca(String nombre, String direccion, int horario, int telefono, Set<Libro> libros, List<Cliente> clientes, List<Vendedor> vendedores) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.telefono = telefono;
        this.libros = libros;
        this.clientes = clientes;
        this.vendedores = vendedores;
    }

    /**
     * Añade un libro a la biblioteca.
     * @param libroARegistrar El libro a añadir a la biblioteca.
     */
    public void registrarLibro(Libro libroARegistrar) {
        libros.add(libroARegistrar);
    }

    /**
     * Elimina un libro de la biblioteca.
     * @param libroAEliminar El libro a eliminar de la biblioteca.
     */
    public void eliminarLibro(Libro libroAEliminar) {
        libros.remove(libroAEliminar);
    }

    /**
     * Añade un cliente a la biblioteca.
     * @param clienteARegistrar El cliente a aeliminar de la biblioteca.
     */
    public void registrarCliente(Cliente clienteARegistrar) {
        clientes.add(clienteARegistrar);
    }

    /**
     * Elimina un libro de la biblioteca.
     * @param clienteAEliminar El cliente a eliminar de la biblioteca.
     */
    public void eliminarCliente(Cliente clienteAEliminar) {
        clientes.remove(clienteAEliminar);
    }

    /**
     * Obtiene la lista de clientes de la biblioteca.
     * @return La lista de clientes de la biblioteca.
     */
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    /**
     * Añade a un vendedor a la biblioteca.
     * @param vendedorARegistrar El vendedor a añadir de la biblioteca.
     */
    public void registrarVendedor(Vendedor vendedorARegistrar) {
        vendedores.add(vendedorARegistrar);
    }

    /**
     * Elimina a un vendedor de la bblioteca.
     * @param vendedorAEliminar El vendedor a eliminar de la bibioteca.
     */
    public void eliminarVendedor(Vendedor vendedorAEliminar) {
        vendedores.remove(vendedorAEliminar);
    }

    /**
     * Obtiene los vendedores de la biblioteca.
     * @return Los vendedores de la biblioteca.
     */
    public List<Vendedor> obtenerVendedores() {
        return vendedores;
    }

    /**
     * Obtiene los libros de la biblioteca.
     * @return Los libros de la biblioteca.
     */
    public Set<Libro> obtenerLibros() {
        return libros;
    }
}
