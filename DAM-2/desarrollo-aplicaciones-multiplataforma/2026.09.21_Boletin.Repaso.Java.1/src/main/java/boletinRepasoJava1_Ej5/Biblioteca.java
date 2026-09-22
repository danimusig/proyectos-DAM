package boletinRepasoJava1_Ej5;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    String nombre;
    String direccion;
    int horario;
    int telefono;
    Map<String, Libro> libros = new HashMap<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Vendedor> vendedores = new ArrayList<>();

    public Biblioteca(String nombre, String direccion, int horario, int telefono, Map<String, Libro> libros, List<Cliente> clientes, List<Vendedor> vendedores) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.telefono = telefono;
        this.libros = libros;
        this.clientes = clientes;
        this.vendedores = vendedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Map<String, Libro> getLibros() {
        return libros;
    }

    public void setLibros(Map<String, Libro> libros) {
        this.libros = libros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public void registrarLibro(Libro libroARegistrar) {

    }

    public void eliminarLibro(Libro libroAEliminar) {

    }

    public void registrarCliente(Cliente clienteARegistrar) {

    }

    public void eliminarCliente(Cliente clienteAEliminar) {

    }

    public Cliente[] obtenerCliente() {

        return listaClientes;
    }

    public void registrarVendedor(Vendedor vendedorARegistrar) {

    }

    public void eliminarVendedor(Vendedor vendedorAEliminar) {

    }
    public void registrarLibro(Libro libroARegistrar) {

    }
    public void registrarLibro(Libro libroARegistrar) {

    }

}
