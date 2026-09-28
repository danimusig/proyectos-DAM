package boletinRepasoJava1_Ej5;

import java.util.Date;

/**
 * Clase que contiene los datos y acciones referentes a un libro.
 * @author danielms
 * @version 1.0
 * @see Date
 */
public class Libro {

    /**
     * El titulo del libro.
     */
    public String titulo;

    /**
     * El autor del libro.
     */
    public String autor;

    /**
     * La editorial del libro.
     */
    public String editorial;

    /**
     * El genero del libro.
     */
    public String genero;

    /**
     * El idioma del libro.
     */
    public String idioma;

    /**
     * La disponibilidad del libro.
     */
    public boolean disponible;

    /**
     * El año de publicacion del libro.
     */
    public Date anioPublicacion;

    /**
     * Constructor principal.
     * @param titulo El titulo del libro.
     * @param autor El autor del libro.
     * @param editorial La editorial del libro.
     * @param genero El genero del libro.
     * @param idioma El idioma del libro.
     * @param disponible La disponibilidad del libro.
     * @param anioPublicacion El año de publicacion del libro.
     */
    public Libro(String titulo, String autor, String editorial, String genero, String idioma, boolean disponible, Date anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.idioma = idioma;
        this.disponible = disponible;
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Obtiene el titulo del libro.
     * @return El titulo del libro.
     */
    public String obtenerTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor  del libro.
     * @return El autor del libro.
     */
    public String obtenerAutor() {
        return autor;
    }

    /**
     * Obtiene el anio de publicacion del libro.
     * @return El anio de publicacaion del libro.
     */
    public Date obtenerAnioPublicacion() {
        return anioPublicacion;
    }

    /**
     * Obtiene la editorial del libro.
     * @return La editorial del libro.
     */
    public String obtenerEditorial() {
        return editorial;
    }

    /**
     * Obtiene el genero del libro.
     * @return El genero del libro.
     */
    public String obtenerGenero() {
        return genero;
    }

    /**
     * Obtiene el idioma del libro.
     * @return El idioma del libro.
     */
    public String obtenerIdioma() {
        return idioma;
    }

    /**
     * Obtiene disponibilidad del libro.
     * @return La disponibilidad del libro.
     */
    public boolean estaDisponible() {
        return disponible;
    }

}
