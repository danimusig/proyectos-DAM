public class ProcesoPrincipal {
    public static void main(String[] args) {
        try {
            String[] infoProceso = {"java", "es.paraninfo.sincronizacion.ProcesoSecundario"};
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

