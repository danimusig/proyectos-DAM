public class ProcesoPrincipal {
    public static void main(String[] args) {
        try {
            String[] infoProceso = {"java", "/mnt/kingP-1TB/Proyects/proyectos-dam/DAM-2/programacion-servicios-y-procesos/Unidad 1/Extractos de código/Sincronizacion Procesos/src/main/java/ProcesoSecundario.java"};
            Process proceso = Runtime.getRuntime().exec(infoProceso);

            int valorRetorno = proceso.waitFor();

            if (valorRetorno == 0) {
                System.out.println("El proceso se ha completado satisfactoriamente");
            } else {
                System.out.println("El proceso ha fallado. Código de error: " + valorRetorno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

