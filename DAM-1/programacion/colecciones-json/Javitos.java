package dms.dam1._pe08_colleciones_json;

import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;

/**
 * Clase Javitos: Gestiona los clientes y los alojamientos del complejo.
 *
 * @author dmunsig
 * @version 2.0
 * @see String
 * @see Arrays
 * @see Alojamiento
 * @see Cliente
 */
public class Javitos {
    /**
     * Los alojamientos del complejo.
     */
    private ArrayList<Alojamiento> alojamientos ;

    /**
     * Los clientes que han usado las instalaciones.
     */
    private ArrayList<Cliente> clientes;

    /**
     * Constructor princiapal.
     */
    public Javitos() {
        this.alojamientos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    /**
     * Da de alta a un cliente en el sistema.
     * @param nuevoCliente El cliente a añadir al sistema.
     */
    public void altaCliente(Cliente nuevoCliente) {
        //Reemplazamos todo el codigo anterior con el metodo .add() de ArrayList.
        this.clientes.add(nuevoCliente);
        System.out.println("El cliente " + nuevoCliente.getDni() + " ha sido registrado");
    }

    /**
     * Da de baja a un cliente en el sistema.
     * @param dni El cliente a borrar al sistema.
     */
    public void bajaCliente(String dni) {
        //Control de errores.
        if (this.clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema");
            return;
        }
        
        //El metodo removeIf recorre el arraylist y comprueba que se cumpla la condicion devolviendo un booleano true si se elimina false si no se encuentra en el arraylist.
        boolean eliminado = this.clientes.removeIf(c -> c.getDni().equals(dni));
        
        if (eliminado) {
            System.out.println("El cliente con DNI: " + dni + " fue eliminado.");
        } else {
            System.out.println("No se encontró ningún cliente con ese DNI.");
        }
    }
    
    /**
     * Añade un alojamiento al sistema.
     * @param nuevoAlojamiento El alojamiento a añadir al sistema.
     */
    public void altaAlojamiento(Alojamiento nuevoAlojamiento) {
        //Reemplazamos todo el codigo anterior co el metodo .add() de ArrayList.
        this.alojamientos.add(nuevoAlojamiento);
        System.out.println("El alojamiento " + nuevoAlojamiento.getNombre() + " ha sido registrado.");
    }

    /**
     * Quita del sistema un alojamiento.
     * @param nombreAlojamiento El alojamiento a borrar del sistema.
     */
    public void bajaAlojamiento(String nombreAlojamiento) {
        //Control de errores
        if (this.alojamientos.isEmpty()) {
            System.out.println("No hay alojamientos registrados en el sistema.");
            return;
        }
        
        //El metodo removeIf recorre el arraylist y comprueba que se cumpla la condicion devolviendo un booleano true si se elimina false si no se encuentra en el arraylist.
        boolean eliminado = this.alojamientos.removeIf(a -> a.getNombre().equals(nombreAlojamiento));
        
        if (eliminado) {
            System.out.println("El alojamiento " + nombreAlojamiento + " fue eliminado.");
        } else {
            System.out.println("No se encontró ningún alojamiento con ese nombre.");
        }
    }
    
    /**
     * Lista los clientes ordenados alfabeticamente.
     */
    public void listadoClientes() {
        //Control de errores.
        if (this.clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema.");            
        } else {
            //Creo una lista nueva copiando la original.
            ArrayList<Cliente> clienteOrdenado = new ArrayList<>(this.clientes);
            //Ordeno solo la copia.
            Collections.sort(clienteOrdenado);
            //Recorro el arraylist de clientes
            System.out.println("    --- LISTADO DE CLIENTES ---");
            for (Cliente c : clienteOrdenado) {
                System.out.println(c.toString());
            }
        }
    }

    /**
     * Lista los alojamientos ordenados alfabeticamente.
     */
    public void listadoAlojamientos() {
        //Control de errores.
        if (this.alojamientos.isEmpty()) {
            System.out.println("No hay alojamientos registrados en el sistema.");
        } else {
            //Creo una lista nueva copiando la original.
            ArrayList<Alojamiento> alojamientoOrdenado = new ArrayList<>(this.alojamientos);
            //Ordeno solo la copia.
            Collections.sort(alojamientoOrdenado);
            //Recorro el arraylist de alojamientos.
            System.out.println("    --- LISTADO DE ALOJAMIENTOS ---");
            for (Alojamiento a : alojamientoOrdenado) {
                System.out.println(a.toString());
            }
        }
    }
    
    /**
     * LIsta los clientes ordenados por mayor cantidad de veces alojado.
     */
    public void topClientes() {    
        //Control de errores.
        if (this.clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema");
            return;
        } else {
            ArrayList<Cliente> topCliente = new ArrayList<>(this.clientes);
            //Lo adecuado seria usar un comparator pero no los hemos dado.
            //Uso el metodo de ordenacion BUbbleSort.
            for (int i = 0; i < topCliente.size() - 1; i++) {
                for (int j = 0; j < topCliente.size() - i - 1; j++) {
                    // Si el siguiente tiene mas hospedaciones que el actual, los intercambiamos.
                    if (topCliente.get(j).getVecesAlojado() < topCliente.get(j + 1).getVecesAlojado()) {
                        Cliente temp = topCliente.get(j);
                        topCliente.set(j, topCliente.get(j + 1));
                        topCliente.set(j + 1, temp);
                    }    
                }
            }
            
            System.out.println("\n--- RANKING TOP CLIENTES (POR ESTANCIAS) ---");
            for (Cliente c : topCliente) {
                System.out.println("Cliente: " + c.getNombre() + " | DNI: " + c.getDni() + " | Estancias: " + c.getVecesAlojado());
            }
        }    
    }
    
    /**
     * Lista los alojamientos ordenados por cantidad de veces alquilado.
     */
    public void topAlojamientos() {
        //Control de errores.
        if (this.alojamientos.isEmpty()) {
            System.out.println("No hay alojamientos registrados en el sistema");
            return;
        } else {
            ArrayList<Alojamiento> topAlojamiento = new ArrayList<>(this.alojamientos);
            //Lo adecuado seria usar un comparator pero no los hemos dado.
            //Uso el metodo de ordenacion BubbleSort.
            for (int i = 0; i < topAlojamiento.size() - 1; i++) {
                for (int j = 0; j < topAlojamiento.size() - i - 1; j++) {
                    // Si el siguiente tiene más alojamientos que el actual, los intercambiamos.
                    if (topAlojamiento.get(j).getVecesAlquilado() < topAlojamiento.get(j + 1).getVecesAlquilado()) {
                        Alojamiento temp = topAlojamiento.get(j);
                        topAlojamiento.set(j, topAlojamiento.get(j + 1));
                        topAlojamiento.set(j + 1, temp);
                    }    
                }
            }
            
            System.out.println("\n--- RANKING TOP ALOJAMIENTOS (POR VECES ALQUILADO) ---");
            for (Alojamiento a : topAlojamiento) {
                System.out.println("Alojamiento: " + a.getNombre() + " Veces alquilado: " + a.getVecesAlquilado());
            }
        }           
    }
    
    //Creo una variable con la ruta de cada archivo JSON.
    /**
     * La ruta del archivo JSON de clientes.
     */
    String rutaClientes = "clientes.json";
    
    /**
     * La ruta del archivo JSON de alojamientos.
     */
    String rutaAlojamientos = "alojamientos.json";
    
    /**
     * Importa clientes desde un archivo JSON y los añade a la lista actual.
     * @param rutaClientes ruta del archivo JSON.
     */
    public void importClientesFromJSON(String rutaClientes){
        try {
            //Leo todo el contenido del archivo como una cadena
            String contenidoClientes = new String(Files.readAllBytes(Paths.get(rutaClientes)));
            JSONArray jsonArray = new JSONArray(contenidoClientes);
                    
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                
                //Creo el objeto Cliente usando los datos del JSON.                
                Cliente c = new Cliente(
                        obj.getString("nombre"), 
                        obj.getString("dni"), 
                        obj.getString("email"), 
                        obj.getString("lugarResidencia")
                );
                
                //Si el JSON tiene el campo numVecesAlojado, lo asignamos ya que no es necesario en el constructor.
                if (obj.has("numVecesAlojado")) {
                    c.setVecesAlojado(obj.getInt("numVecesAlojado"));
                }
                
                this.clientes.add(c);
            }
            System.out.println("Clientes importados correctamente desde " + rutaClientes);
        } catch (Exception e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes.");
        }
    }
    
    /**
     * Exporta la lista actual de clientes a un archivo JSON.
     * @param rutaClientes ruta del archivo JSON de destino.
     */
    public void exportClientesToJSON(String rutaClientes) {
        //try se aegura de cerrar el programa se cierre al terminar.
        try {
            // Creo un conjunto de tipo JSONArray
            JSONArray jsonArray = new JSONArray();
            //Recorro la ArrayList de clientes y relaciono los atributos de Cliente a los paŕametros del JSON usando objetos JSON.
            for (Cliente c : this.clientes) {
                JSONObject obj = new JSONObject();
                obj.put("nombre", c.getNombre());
                obj.put("dni", c.getDni());
                obj.put("email", c.getEmail());
                obj.put("lugarResidencia", c.getLugarResidencia());
                obj.put("numVecesAlojado", c.getVecesAlojado());
                //Una vez el los atributos estan relacionados guardo el objeto en el jsonarray.
                jsonArray.put(obj);
            }
            //Intento escribir los datos en el archivo.
            try (FileWriter file = new FileWriter(rutaClientes)) {
                file.write(jsonArray.toString(4));
                System.out.println("Archivo de clientes exportado exitosamente.");
            }
        } catch (Exception e) {
            //Si el archivo es inaccesible saltamos aqui.
            System.out.println("ERROR: No se pudo exportar el archivo de clientes: " + e.getMessage());
        }
    }
    
    /**
     * Importa alojamientos desde un archivo JSON.
     * @param rutaAlojamientos ruta del archivo JSON.
     */
    public void importAlojamientosFromJSON(String rutaAlojamientos) {
        try {
            //Leo todo el contenido del archivo como una cadena
            String contenido = new String(Files.readAllBytes(Paths.get(rutaAlojamientos)));
            JSONArray jsonArray = new JSONArray(contenido);
                    
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                
                //Creo el objeto Alojamiento usando los datos del JSON.
                Alojamiento a = new Alojamiento(obj.getString("nombre"), obj.getInt("capacidad"), obj.getDouble("tarifa"), obj.getInt("tieneChimenea") == 1, obj.getInt("tieneJacuzzi") == 1);
            
                //Si el JSON tiene el campo numVecesAlquilado, lo asignamos ya que no es necesario en el constructor.
                if (obj.has("numVecesAlquilada")) {
                    a.setVecesAlquilado(obj.getInt("numVecesAlquilada"));
                }
                
                this.alojamientos.add(a);
            }
            System.out.println("Alojamientos importados correctamente desde " + rutaAlojamientos);
        } catch (Exception e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes.");
        }
    }
    
    /**
     * Exporta la lista de alojamientos a un archivo JSON.
     * @param rutaAlojamientos ruta del archivo JSON de destino.
     */
    public void exportAlojamientosToJSON(String rutaAlojamientos) {
        //try se aegura de cerrar el programa se cierre al terminar.        
        try {
            //Creo un conjunto de tipo JSONArray.
            JSONArray jsonArray = new JSONArray();
            //Recorro el ArrayList de alojamientos y relaciono los atributos de Alojamiento a los paŕametros del JSON usando objetos JSON. 
            for (Alojamiento a : this.alojamientos) {
                JSONObject obj = new JSONObject();
                obj.put("nombre", a.getNombre());
                obj.put("capacidad", a.getCapacidad());
                obj.put("tarifa", a.getTarifa());
                obj.put("tieneChimenea", a.getTieneChimenea() ? 1 : 0);
                obj.put("tieneJacuzzi", a.getTieneJacuzzi() ? 1 : 0);
                obj.put("numVecesAlquilada", a.getVecesAlquilado());
                //Una vez el los atributos estan relacionados guardo el objeto en el JSONArray.
                jsonArray.put(obj);
            }
            
            //Intento escribir los datos en el archivo.
            try (FileWriter file = new FileWriter(rutaAlojamientos)) {
                file.write(jsonArray.toString(4));
                System.out.println("Archivo de alojamientos exportado exitosamente.");
            }
        } catch (Exception e) {
            //Si el archivo es inaccesible saltamos aqui.
            System.out.println("ERROR: No se pudo exportar el archivo de alojamientos.");
        }        
    }
}
