package pkg2026.pkg02.pkg28.pe09_ficheros;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author dmunsig
 */
public class Pelicula implements Serializable, Comparable<Pelicula> {
    
    private LocalDate fechaLanzamiento;
    private String titulo;
    private String resumen;
    private double popularidad;
    private int votos;
    private double puntuacionMedia;
    private String idiomaOriginal;
    private List<String> genero;
    private String urlCartel;

    public Pelicula(LocalDate fechaLanzamiento, String titulo, String resumen, double popularidad, int votos, double puntuacionMedia, String idiomaOriginal, List<String> genero, String urlCartel) {
        this.fechaLanzamiento = fechaLanzamiento;
        this.titulo = titulo;
        this.resumen = resumen;
        this.popularidad = popularidad;
        this.votos = votos;
        this.puntuacionMedia = puntuacionMedia;
        this.idiomaOriginal = idiomaOriginal;
        this.genero = genero;
        this.urlCartel = urlCartel;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public double getPuntuacionMedia() {
        return puntuacionMedia;
    }

    public void setPuntuacionMedia(double puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public String getUrlCartel() {
        return urlCartel;
    }

    public void setUrlCartel(String urlCartel) {
        this.urlCartel = urlCartel;
    }

    @Override
    public int compareTo(Pelicula p) {
         return Double.compare(p.getPuntuacionMedia(), this.puntuacionMedia);
    }
    
    @Override
    public String toString() {
        return "\t<-- Datos Pelicula --> \n Fecha Lanzamiento: " + this.fechaLanzamiento + " \n Titulo: " + this.titulo 
                + "\n Resumen: " + this.resumen + "\n Popularidad: " + this.popularidad + "\n Voto: " + this.votos 
                + "\n Puntuacion Media: " + this.puntuacionMedia + "\n Idioma: " + this.idiomaOriginal + "\n Genero/s: " + this.genero;
    }
    
}
