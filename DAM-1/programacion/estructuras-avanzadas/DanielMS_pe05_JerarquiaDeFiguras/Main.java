package DAM1.DanielMS_pe05_JerarquiaDeFiguras;

/**
 * Clase Principal para probar los constructores y metodos de las otras clases
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Cuadrado
 * @see Triangulo
 * @see Circulo
 * @see Pizarra
 */
public class Main {

    public static void main(String[] args) {
        
        //Creo las figuras
        Cuadrado cuadrado1 = new Cuadrado(7);
        Triangulo triangulo1 = new Triangulo(5,7,2);
        Circulo circulo1 = new Circulo(6);
        
        //Creo la pizarra y uso los objetos anteriores como parametro,
        //aunque Pizarra necesite 3 objetos figura funcionan ya que estas clases heredan de figura que es abstracta.
        Pizarra pizarra1 = new Pizarra(cuadrado1, triangulo1, circulo1);
        
        //Enseño la pizarra
        System.out.print(pizarra1.toString());
        
        //Pruebo el metodo dibujar y borrar
        pizarra1.getFigura1().dibujar();
        pizarra1.getFigura2().dibujar();
        pizarra1.getFigura3().dibujar();
        pizarra1.getFigura1().borrar();
        pizarra1.getFigura2().borrar();
        pizarra1.getFigura3().borrar();
        
        //Pruebo el metodo borrarFigura();
        pizarra1.borrarFigura1();
        
        //Enseño el estado actual de la pizarra.
        System.out.print(pizarra1.toString());
        
        //Pruebo un setter
        Circulo circulo2 = new Circulo(12);
        pizarra1.setFigura1(circulo2);
        
        System.out.print(pizarra1.toString());
    }
}
