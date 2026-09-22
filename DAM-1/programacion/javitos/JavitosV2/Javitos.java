package javitos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.json.JSONException;

/**
 * Clase Javitos: Gestiona los clientes y los alojamientos del complejo.
 *
 * @author dmunsig
 * @version 3.0
 * @see String
 * @see Integer
 * @see Double
 * @see Boolean
 * @see Alojamiento
 * @see Cliente
 * @see JSONObject
 * @see JSONArray
 * @see ArrayList
 * @see FileWriter
 * @see FileReader
 * @see BufferedWriter 
 * @see BufferedReader
 * @see FileInputStream
 * @see ObjectInputStream
 * @see FileOutputStream
 * @see ObjectOutputStream
 * @throws ClienteExistenteException
 * @throws AlojamientoExistenteException
 * @throws DniNoValidaException
 * @throws EmailNoValidaException
 * @throws IOException
 * @throws FileNotFoundException
 * @throws EndOfFileException
 * @throws ClassNotFoundException
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
    public void altaCliente(Cliente nuevoCliente) throws ClienteExistenteException {
        
        boolean clienteRepe = false;
        for (Cliente c : this.clientes) {
            if (c.getDni().equals(nuevoCliente.getDni())) {
                clienteRepe = true;
                break;
            }
        }
        
        if (clienteRepe) {
            throw new ClienteExistenteException("Ya existe un cliente con ese DNI en el sistema.");
        }
        
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
    public void altaAlojamiento(Alojamiento nuevoAlojamiento) throws AlojamientoExistenteException {
        
        boolean alojamientoRepe = false;
        for (Alojamiento a : this.alojamientos) {
            if (a.getNombre().equals(nuevoAlojamiento.getNombre())) {
                alojamientoRepe = true;
                break;
            }
        }
        
        if (alojamientoRepe) {
            throw new AlojamientoExistenteException("Ya existe un alojamiento con ese nombre en el sistema.");
        }
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
    public void importClientesFromJSON(String rutaClientes) throws DniNoValidaException, EmailNoValidaException{
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
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());
        } catch (JSONException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());            
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
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());
        } catch (JSONException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());            
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
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());
        } catch (JSONException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());            
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
        } catch (IOException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());
        } catch (JSONException e) {
            System.out.println("ERROR: No se pudo importar el archivo de clientes." + e.getMessage());            
        }      
    }
    
    /**
     * Exporta la lista de clientes a un archivo TXT.
     * @param ruta La ruta del archivo de texto.
     * @throws IOException Excepcion de Entrada/Salida.
     */
    public void exportClientesToFicheroTexto(String ruta) throws IOException {
        FileWriter fw = new FileWriter(ruta);
        BufferedWriter bw = new BufferedWriter(fw);     
        
        for(Cliente c : this.clientes) {
            String linea = c.getNombre() + ";" + c.getDni() + ";" + c.getEmail() + ";" + c.getLugarResidencia() + ";" + c.getVecesAlojado();
            bw.write(linea);
            bw.newLine();
        }
        bw.close();
        fw.close();
        
        System.out.println("Se ha generado el archivo TXT de Clientes correctamente.");
    } 
    
    /**
     * Exporta la lista de alojamientos a un archivo TXT.
     * @param ruta La ruta del archivo de texto.
     * @throws IOException Excepcion de entrada y salida.
     */
    public void exportAlojamientosToFicheroTexto(String ruta) throws IOException {
        FileWriter fw = new FileWriter(ruta);
        BufferedWriter bw = new BufferedWriter(fw);     
        
        for(Alojamiento a : this.alojamientos) {
            int jacuzzi = (a.getTieneJacuzzi() == true) ? 1 : 0;
            int chimenea = (a.getTieneChimenea() == true) ? 1 : 0;
            int alquiladaAhora = (a.getAlquiladaAhora() == true) ? 1 : 0;
            String linea = a.getNombre() + ";" + a.getCapacidad() + ";" + a.getTarifa() + ";" 
                        + chimenea + ";" + jacuzzi + ";" + alquiladaAhora + "" + a.getVecesAlquilado();
            bw.write(linea);
            bw.newLine();
        }
        bw.close();
        fw.close();
        
        System.out.println("Se ha generado el archivo TXT de Alojamientos correctamente.");
    } 
    
    /**
     * Importa uno o varios clientes desde un archivo de texto.
     * @param ruta La ruta del archivo
     * @throws FileNotFoundException Excepcion cuando el archivo no se encuentra.
     * @throws IOException Excepcion de entrada y salida.
     * @throws DniNoValidaException Excepcion cuando el dni no tiene el formato adecuado.
     * @throws EmailNoValidaException Excepcion cuando el email no tiene el formato adecuado.
     */
    public void addClientesFromFicheroTexto(String ruta) throws FileNotFoundException, IOException, DniNoValidaException, EmailNoValidaException, ClienteExistenteException {
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
       
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datosCliente = linea.split(";");
            int numVecesAlojado = Integer.parseInt(datosCliente[4]);
           
            Cliente c = new Cliente(datosCliente[0],datosCliente[1], datosCliente[2], datosCliente[3]);
            c.setVecesAlojado(numVecesAlojado);
            for(Cliente a : this.clientes) {
                if (a.getDni().equals(c.getDni())) {
                    throw new ClienteExistenteException(" El cliente ya existe en el sistema.");
                }
            }
        }
        br.close();
        fr.close();
        System.out.println("Se han importado los Clientes desde el archivo TXT correctamente.");
    }
    
    /**
     * Importa uno o varios alojamientos desde un archivo de texto.
     * @param ruta La ruta del archivo.
     * @throws FileNotFoundException Excepcion cuando el archivo no se encuentra.
     * @throws IOException Excepcion de entrada y salida.
     */
    public void addAlojamientosFromFicheroTexto(String ruta) throws FileNotFoundException, IOException, AlojamientoExistenteException {
       FileReader fr = new FileReader(ruta);
       BufferedReader br = new BufferedReader(fr);
       
       String linea;
       while ((linea = br.readLine()) != null) {
           String[] datosAlojamiento = linea.split(";");
           int capacidad = Integer.parseInt(datosAlojamiento[1]);
           double tarifa = Double.parseDouble(datosAlojamiento[2]);
           boolean tieneChimenea = (datosAlojamiento[3].equals("1")) ? true : false;
           boolean tieneJacuzzi = (datosAlojamiento[4].equals("1")) ? true : false;
           boolean alquiladaAhora = (datosAlojamiento[5].equals("1")) ? true : false;
           int numVecesAlquilado = Integer.parseInt(datosAlojamiento[6]);
           
           Alojamiento alo = new Alojamiento(datosAlojamiento[0], capacidad, tarifa, tieneChimenea, tieneJacuzzi);
           alo.setVecesAlquilado(numVecesAlquilado);
           for(Alojamiento a : this.alojamientos) {
                if (a.getNombre().equals(alo.getNombre())) {
                    throw new AlojamientoExistenteException(" El alojamiento ya existe en el sistema.");
                }
            }
           this.alojamientos.add(alo);
       }
       br.close();
       fr.close();
       
       System.out.println("Se han importado los Alojamientos desde el archivo TXT correctamente.");
    }    
    
    /**
     * Exporta la lista de objetos Cliente a un fichero binario.
     * @param ruta La ruta del archivo.
     * @throws FileNotFoundException Excepcion para cuando no se encuentra un archivo.
     * @throws IOException Excepcion de entrada/salida.
     */
    public void exportClientesToFicheroBinario(String ruta) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for(Cliente c : this.clientes) {
            oos.writeObject(c);
        }
        
        System.out.println("Se han generado el archivo binario de Clientes se ha generado correctamente.");        
    }
    
    /**
     * Exporta los alojamientos a un archivo binario.
     * @param ruta La ruta de un archivo.
     * @throws FileNotFoundException Excepcion para cuando no se encuentra el archivo.
     * @throws IOException Excepcion de entrada/salida.
     */
    public void exportAlojamientosToFicheroBinario(String ruta) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(ruta);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for(Alojamiento a : this.alojamientos) {
            oos.writeObject(a);
        }
        
        System.out.println("Se han generado el archivo binario de Alojamientos se ha generado correctamente.");        
    }
    
    /**
     * Importa uno o varios clientes desde un archivo binario.
     * @param ruta La ruta del archivo.
     * @throws FileNotFoundException Excepcion para cuando no se encuentra el archivo.
     * @throws IOException Excepcion de entrada/salida.
     * @throws ClassNotFoundException Excepcion cuando el ois no encuentra la clase.
     * @throws javitos.DniNoValidaException El formato del dni no es valido.
     * @throws javitos.EmailNoValidaException El formato del email no es valido.
     */
    public void addClientesFromFicheroBinario(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException, DniNoValidaException, EmailNoValidaException {
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        System.out.println("Importando clientes desde el archivo binario...");
        try {
        while(true) {
            Cliente c = (Cliente) ois.readObject();
            this.clientes.add(c);
            }
        } catch(EOFException eofe) {
            System.out.println(eofe.getMessage());
        }
        ois.close();
        fis.close();
    }
    
    /**
     * Exporta uno o varios alojamientos desde un archivo binario.
     * @param ruta La ruta del archivo.
     * @throws FileNotFoundException Excepcion para cuando no se encuentra el archivo.
     * @throws IOException Excepcion de entrada/salida.
     * @throws ClassNotFoundException Excepcion cuando el ois no encuentra la clase.
     */
    public void addAlojamientosFromFicheroBinario(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        System.out.println("Importando alojamientos desde el archivo binario...");
        try {
            while(true) {
                Alojamiento a = (Alojamiento) ois.readObject();
                this.alojamientos.add(a);     
            }
        } catch(EOFException eofe) {
            System.out.println(eofe.getMessage());
        }
    }    
}

