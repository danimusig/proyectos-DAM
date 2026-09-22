package pe11_bbdd_relacionales_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;  
/**
 *
 * @author dmunsig
 */

/////////////////////////////////////////////////////////////////////////////////////////////
//EJERCICIO NO REALIZADO ESTO ES SOLO EL EJEMPLO DE UNO DE LOS LINKS PARA PROBARLO AL MENOS//
/////////////////////////////////////////////////////////////////////////////////////////////


public class GenerarPdf {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/Javitos";
//            Class.forName("org.mariadb.jdbc.Driver");
//            String url = "jdbc:mariadb://localhost:3306/Javitos";
            Connection con = DriverManager.getConnection(url, "root", "232431");
            Statement stmt = con.createStatement();
            /// CREAR DOCUMENTO
            PDDocument document = new PDDocument();
            /// CREAR PAGINA
            PDPage page = new PDPage();
            /// AGREGAR LA PAGINA AL DOCUMENTO
            document.addPage(page);
            /// CREAR UN STREAM PARA AGREGAR TEXTO
            PDPageContentStream stream = new PDPageContentStream(document, page);
            /// CREAR UN OBJETO CON LA FUENTE QUE VAMOS A USAR PARA EL TEXTO
            PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);            /// INICIAMOS EL STREAM DE TEXTO
            stream.beginText();
            /// DEFINIMOS LA FUENTE Y EL TAMA~O PARA EL TITULO
            stream.setFont(font, 24);
            /// DEFINIMOS LAS COORDENADAS PARA INICIAR EL TEXTO
            stream.newLineAtOffset(10,760 );   
            /// MOSTRAMOS EL TEXTO/ TITULO
            stream.showText("Crear PDF con PDFBox en Java");
            /// DEFINIMOS EL LA FUENTE Y TAMA~O PARA LOS PARRAFOS
            stream.setFont(font, 12);
            /// DEFINIMOS LAS COORDENADAS EN REFERENCIA A LA DEFINICION DE COORDENADAS ANTERIOR
            stream.newLineAtOffset(0, -10);
            /// MOSTRAMOS EL TEXTO DE UN PARRAFO
            stream.showText("Hola Mundo !!!");
            /// DEFINIMOS LAS COORDENADAS EN REFERENCIA A LA DEFINICION DE COORDENADAS ANTERIOR
            stream.newLineAtOffset(0, -10);
            /// MOSTRAMOS EL TEXTO DE OTRO PARRAFO
            stream.showText("Linea 3!");
            /// FINALIZAMOS EL STREAM DE TEXTO
            stream.endText();
            /// CERRAMOS EL STREAM
            stream.close();
            /// GUARDAMOS EL DOCUMENTO
            document.save("hola.pdf");
            /// CERRAMOS EL DOCUMENTO
            document.close();
            
        } catch(Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
