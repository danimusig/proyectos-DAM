package com.mycompany._dms_estructurasselectivas;

import java.util.Scanner;

/** Práctica evaluable sobre condicionales (if, else if, else y switch)
 *
 * @author danielms
 * @version 1.0
 * @see Scanner
 * @see System
 * @see String
 */

public class EstructurasSelectivas__DMS {

    public static void main(String[] args) {
        
        //Declaro el scanner aquí para poder usarlo en todos los ejercicios sin tener que declararlo cada vez
        Scanner sc = new Scanner(System.in);
        
        
        /*Ejercicio 1: Escribir un programa que pida al usuario un número entero y muestre por pantalla si es par o
        impar. Recuerda que un número para es aquél que al dividirlo entre 2, el resto es 0.*/
        
        /*
        //Variables
        int num;
        
        //Le pido al usuario que introduzca el número.
        System.out.print("Por favor, introduzca un numero:  ");
        num = sc.nextInt();
        
        //Compruebo si el número es par o impar con un if.
        if (num%2==0) {
            System.out.print("El numero es par");
        }else{
            System.out.print("El numero es impar");
        }
        */
        
        
        
        //Ejercicio 2: Realizar un programa que solicite dos números distintos y muestre por pantalla el mayor de ellos.
        
        /*
        //Variables
        int num1, num2;
        
        //Le pido al usuario que introduzca el valor de num1 y num2.
        System.out.print("Por favor, introduzca el primer valor:  ");
        num1=sc.nextInt();
        
        System.out.print("Introduzca el segundo valor:  ");
        num2=sc.nextInt();
        
        //Compruebo cual es el mayor de los números introducidos.
        if (num1>num2) {
            System.out.print(num1 + " es mayor que " + num2);
        }else{
            System.out.print(num2 + " es mayor que " + num1);
        }
        */
        
        
        
        /*Ejercicio 3: Escriba un programa que pida dos números enteros y que calcule su división, escribiendo si la
        división es exacta o no.*/
        
        /*
        //Variables
        int num1, num2;
        
        //Le pido al usuario el valor de num1 y num2.
        System.out.print("Por favor introduzca el primer numero:  ");
        num1 = sc.nextInt();
        
        System.out.print("Por favor, introduzca el segundo numero:   ");
        num2 = sc.nextInt();
        
        //Compruebo que el resto es igual a 0 despues de dividirlos
        if (num1%num2==0) {
            System.out.print("La division es exacta");
        }else{
            System.out.print("La división no es exacta");
        }
        */
        
        
        
        /*Ejercicio 4: Implementa un programa que solicite al usuario un número y muestre un mensaje indicando
        si un número introducido por teclado tiene un dígito, o tiene dos o más dígitos.*/
        
        /*
        //Variables
        int num1;
        
        //Le pido al usuario que introduzca el numero
        System.out.print("Introduzca un número:  ");
        num1 = sc.nextInt();
        
        //Si el numero está entre 0 y 9 será de una cifra, de 10 a 99 de 2 y de 100 a 999 de 3...
        if (num1>=0 && num1<10) {
            System.out.print("El número tiene 1 digito");
        }else if (num1>10 && num1<100) {
            System.out.print("El número tiene 2 digitos");
        }else{
            System.out.print("El número tiene más de 2 dígitos");
        }
        */
        
        
        
        /*Ejercicio 5: Escriba un programa que pida el año actual y un año cualquiera y que escriba cuántos años
        han pasado desde ese año o cuántos años faltan para llegar a ese año.*/
        
        /*
        //Variables
        int anyoActual, anyoRandom;
        
        //Le pido al usuario los años.
        System.out.print("Por favor introduzca el anyo actual:   ");
        anyoActual = sc.nextInt();
        
        System.out.print("Introduzca un anyo cualquiera para ver cuanto falta:   ");
        anyoRandom = sc.nextInt();
        
        //Compruebo que el año introducido es mayor al actual y muestro los años faltantes
        if (anyoRandom<anyoActual) {
            System.out.print("Han pasado " + (anyoActual-anyoRandom) + " anyos desde " + anyoRandom);
        }else{
            System.out.print("Quedan " + (anyoRandom-anyoActual) + " anyos para llegar a " + anyoRandom);
        }
        */
        
        
        
        /*Ejercicio 6: Realizar un programa que solicite al usuario un número “a” que se corresponde con la nota
        de un examen, y un número “b” que se corresponde con la nota del portfolio de actividades
        (a y b serán números comprendidos entre 0 y 10), y el programa devuelva la nota media de
        ambas. Si la nota media es menor que 5, devuelve el mensaje “asignatura suspendida, debe
        estudiar más”, y si la nota media es mayor o igual que 5 devuelve el mensaje “enhorabuena,
        asignatura aprobada”.*/
        
        /*
        //Variables
        int notaExamen, notaActividades, notaMedia;
        
        //Le pido al usuario la nota del examen y las actividades
        System.out.print("Por favor introduzca la nota del examen:  ");
        notaExamen = sc.nextInt();
        
        System.out.print("Ahora introduzca la nota de las actividades:  ");
        notaActividades = sc.nextInt();
        
        //Hago la media, compruebo que los valores introducidos estén entre 0 y 10 y digo si está aprobado o suspenso.
        notaMedia=(notaExamen+notaActividades)/2;
        
        if (notaExamen > 10 || notaActividades > 10) {
            System.out.print("ERROR: Por favor introduzca una nota del 0 al 10");
        }else if (notaMedia >= 5) {
            System.out.print("Tiene un " + notaMedia + " de media: enhorabuena, asignatura aprobada.");
        }else{
            System.out.print("Tiene un " + notaMedia + " de media: asignatura suspendida debe estudiar más.");
        }
        */
        
        
        
        /*Ejercicio 7: Para tributar un determinado impuesto se debe ser mayor de 16 años y tener unos ingresos
        iguales o superiores a 1000 € mensuales. Escribir un programa que pregunte al usuario su
        edad y sus ingresos mensuales y muestre por pantalla si el usuario tiene que tributar o no.*/
        
        /*
        //Variables
        int edad;
        double ingresoMensual;
        
        //Le pido los valores al usuario.
        System.out.print("Por favor introduzca su edad: ");
        edad = sc.nextInt();
        
        System.out.print("Por favor, introduzca sus ingresos mensuales: ");
        ingresoMensual = sc.nextInt();
        
        //Le digo 
        if (edad > 16 && ingresoMensual >= 1000) {
            System.out.print("Usted debe tributar");
        }else{
            System.out.print("Usted no debe tributar");
        }
        */
        
        
        
        /*Ejercicio 8: Confeccionar un programa que pida por teclado tres notas de un alumno, calcule el
        promedio e imprima alguno de estos mensajes:
            a. Si el promedio es >=7 mostrar "Notable".         
            b. Si el promedio es >=4 y <7 mostrar "Regular".
            c. Si el promedio es <4 mostrar "Suspendido".*/
        
        /*
        //Variables
        int nota1, nota2, nota3, notaMedia;
        
        //Le pido al usuario que introduzca las notas.
        System.out.print("Por favor introduzca la primera nota");
        nota1 = sc.nextInt();
        
        System.out.print("Por favor introduzca la segunda nota");
        nota2 = sc.nextInt();
        
        System.out.print("Por favor introduzca la tercera nota");
        nota3 = sc.nextInt();
        
        //Hago el promedio y le indico la nota
        notaMedia = (nota1+nota2+nota3)/3;
        
        if (notaMedia >= 7) {
            System.out.print("Notable");
        }else if (notaMedia >4 && notaMedia < 7) {
            System.out.print("Regular");
        }else{
            System.out.print("Suspenso");
        }
        */
        
        
        
        /*Ejercicio 9: Implementa un programa que solicite al usuario 3 números (d, m y a) que se corresponde con
        el día, mes y año. El programa devuelve la estación que se corresponde con esa fecha:
        a. Primavera: inicia el 20 de marzo al 21 de junio.
        b. Verano: inicia el 21 de junio y finaliza el 23 de septiembre.
        c. Otoño: inicia el 23 de septiembre y finaliza el 21 de diciembre.
        d. Invierno: inicia el 21 de diciembre y finaliza el 20 de marzo.*/
        
        /*
        //Variables
        int d, m, a;
        
        //Le pido al usuario el día, mes y año.
        System.out.print("Por favor introduzca el dia");
        d = sc.nextInt();
        
        System.out.print("Por favor introduzca el mes");
        m = sc.nextInt();
        
        System.out.print("Por favor introduzca el anyo");
        a = sc.nextInt();
        
        
        //Compruebo en que estación cae la fecha introducida.
        if (d >= 20 && m==4 || m==5 || m==6 && d<=21) {
            System.out.print("Es primavera");
        }else if (d >= 21 && m==6 || m==7 || m==8 || m==9 && d<=23){
            System.out.print("Es verano");
        }else if (d >= 23 && m==9 || m== 10 || m==11 || m==12 && d<=21) {
            System.out.print("Es otoño");
        }else{
            System.out.print("Es invierno");
        }
        */
        
        
        
        /*Ejercicio 10: Modifica el programa anterior para, en caso de que el usuario introduzca un número de día
        incorrecto (32, -4…) o un número de mes incorrecto (-2, 13…) muestre un mensaje por
        pantalla indicando que el valor introducido es incorrecto.)*/
        
        /*
         //Variables
        int d, m, a;
        
        //Le pido al usuario el día, mes y año.
        System.out.print("Por favor introduzca el dia");
        d = sc.nextInt();
        
        System.out.print("Por favor introduzca el mes");
        m = sc.nextInt();
        
        System.out.print("Por favor introduzca el anyo");
        a = sc.nextInt();
        
        
        //Compruebo en que estación cae la fecha introducida y evito que se pueda meter una fecha errónea.
        if ((d < 0 || d > 31) || (m==2 && d>28) || (m > 12) || (m<=0)) {
            System.out.print("Fecha con formato incorrecto, por favor introduzca la fecha de nuevo");
        }else if ((d >= 20 && m==4) || (m==5) || (m==6 && d<=21)) {
            System.out.print("Es primavera");
        }else if ((d >= 21) && (m==6) || (m==7) || (m==8) || (m==9 && d<=23)) {
            System.out.print("Es verano");
        }else if ((d >= 23 && m==9) || (m== 10) || (m==11) || (m==12 && d<=21)) {
            System.out.print("Es otoño");
        }else{
            System.out.print("Es invierno");
        }
        */
        
        
        
        /*Ejercicio 11: Escribir un programa que pregunte al usuario su renta anual y muestre por pantalla el tipo
        impositivo que le corresponde.*/
        
        /*
        //Variables
        int rentaAnual;
        
        //Le pido la renta al usuario
        System.out.print("Indica cual es tu renta anual");
        rentaAnual = sc.nextInt();
        
        //Le indico el tipo impositivo condicionado por su renta
        if (rentaAnual<10000){
            System.out.print("Tipo impositivo del 5%");
        }else if (rentaAnual>=10000 && rentaAnual<20000) {
            System.out.print("Tipo impositivo del 15%");
        }else if (rentaAnual>=20000 && rentaAnual<35000) {
            System.out.print("Tipo impositivo del 20%");
        }else if (rentaAnual>=35000 && rentaAnual<60000) {
            System.out.print("Tipo impositivo del 30%");
        }else if (rentaAnual>=60000) {
            System.out.print("Tipo impositico del 45%");
        }
        */
        
        
        
        /*Ejercicio 12: Realizar un programa que pregunte al usuario el momento del día con una letra (m- mañana,
        t-tarde, n-noche), el sexo con otra letra (m-masculino, f-femenino). El programa dirá: buenos
        días, tardes, o noches (según el momento) señor o señora según el sexo.*/
        
        /*
        //Variables
        char momentoDia, sexo;
        
        //Le pido al usuario un momento del día y su sexo.
        //Se que lo siguiente no lo hemos dado pero después de mucho rato intentando cosas para poder guardar un char  y usarlo en la condición desistí y busqué en internet
        //que si uso el método .charAt() de la clase String puedo cojer el caracter indicado por el número dentro del paréntesis que representa 
        //la posición de la letra dentro de la String. Fuente:https://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner 
        System.out.print("Por favor introduzca un momento en el dia; m-manyana, t-tarde, n-noche:  ");
        momentoDia = sc.next().charAt(0);
        
        System.out.print("Por favor introduzca su sexo; m-masculino, f-femenino:  ");
        sexo = sc.next().charAt(0);
        
        //Uso para el momento del día y una condicion if para el sexo
        if ((momentoDia=='m') && (sexo=='f')) {
            System.out.print("Buenos dias senyora");
            
        }else if ((momentoDia=='t') && (sexo == 'f')){
            System.out.print("Buenas tardes senyora");
            
        }else if ((momentoDia=='n') && (sexo == 'f')){
            System.out.print("Buenas noches senyora");
            
        }else if ((momentoDia=='m') && (sexo == 'm')){
            System.out.print("Buenos dias senyor");
            
        }else if ((momentoDia=='t') && (sexo == 'm')){
            System.out.print("Buenas tardes senyor");
            
        }else if ((momentoDia == 'n') && (sexo == 'm')){
            System.out.print("Buenas noches senyor");    
        }       
        */
        
        
        
        /*Ejercicio 13: Escribir un programa para una empresa que tiene salas de juegos para todas las edades y
        quiere calcular de forma automática el precio que debe cobrar a sus clientes por entrar. El
        programa debe preguntar al usuario la edad del cliente y mostrar el precio de la entrada. Si el
        cliente es menor de 4 años puede entrar gratis, si tiene entre 4 y 18 años debe pagar 5€ y si
        es mayor de 18 años, 10€.*/
        
        /*
        //Variables
        int edad;
        
        //Le pregunto la edad al usuario
        System.out.print("Por favor, introduzca su edad");
        edad = sc.nextInt();
        
        //Comprueblo la edad y le digo el precio de la entrada
        if (edad < 4) {
            System.out.print("Puedes entrar gratis");
            
        } else if ((edad <= 4) && (edad < 18)) {
            System.out.print("Tu entrada cuesta 5€");
            
        } else {
            System.out.print("Tu entrada cuesta 10€");
        }
        */
        
        
        
        /*Ejercicio 14: Escriba un programa que pida dos números enteros y que escriba si el mayor es múltiplo del
        menor. El mayor puede ser el primero o el segundo número introducido (no se sabe a priori).
        Recuerda que b es múltiplo de a si a%b==0, es decir, el resto de dividir a entre b es 0.*/
        
        /*
        //Variables
        int num1, num2, resto = 0;
        
        //Le pido al usuaraio los dos números
        System.out.print("Por favor introduzca el primer numero:    ");
        num1 = sc.nextInt();
        
        System.out.print("Ahora introduzca el segundo:    ");
        num2 = sc.nextInt();
        
        //Comparo los dos número para ver cual es el mayor y ver si es múltiplo del menor
        if (num1 > num2) {
            resto = num1%num2; 
        } else if (resto == 0) {
            System.out.print("El numero " + num1 + " es multiplo de " + num2);
        } else {
            System.out.print("El numero " + num1 + " no es multiplo de " + num2);
        }
        
        if (num1 < num2) {
            resto = num2%num1; 
        } else if (resto == 0) {
            System.out.print("El numero " + num2 + " es multiplo de " + num1);
        } else {
            System.out.print("El numero " + num2 + " no es multiplo de " + num1);
        }
        */
        
        
        
        /*Ejercicio 15: Implementa un programa (Calculadora de 2 dígitos) que imprima un menú con las siguientes
        opciones (pulsar 1 para suma, 2 para resta, 3 para multiplicación y 4 para división). En
        función de la opción elegida, solicita al usuario los dos números y realiza la operación
        correspondiente. Este algoritmo debe resolverse mediante switch.*/
        
        /*
      //Variables
        int opcionCalculadora;
        double num1, num2;
        
        //Le pido la usuario que introduzca dos números e elija una opción
        System.out.print("Introduzca su primer digito para operar con el:   ");
            num1 = sc.nextDouble();
                
        System.out.print("Por favor, introduzca el segundo digito de operacion:   ");
            num2 = sc.nextDouble();
                
        System.out.println("Elija una de las siguientes operaciones (1-4): ");
        System.out.println("1.- SUMA");
        System.out.println("2.- RESTA");
        System.out.println("3.- MULTIPLICACION");
        System.out.println("4.- DIVISION");
        opcionCalculadora = sc.nextInt();
        
        
        //Uso un switch donde realizaré las operaciones segun la opción elegida por el usuario
        switch (opcionCalculadora) {
            case 1: //suma
                System.out.println("El resultado es: " + (num1+num2));
                break;
            
            case 2: //resta
                System.out.println("El resultado es: " + (num1-num2));
                break;
                
            case 3: //multiplicacion
                System.out.println("El resultado es: " + (num1*num2));
                break;
            
            case 4: //division
                System.out.println("El resultado es: " + (num1/num2));
                break;
                
            default:
                System.out.print("Por favor, introduzca un numero del 1 al 4 la proxima vez");                               
        }
        */
        
        
        
        /*Ejercicio 16: Modifica el programa anterior para que, en caso de que el usuario introduzca un 0 como
        número b, y después solicite la operación 4 (división) el programa no haga ningún resultado y
        muestre el mensaje “No es posible dividir entre 0”*/
        
        /*
        //Variables
        int opcionCalculadora;
        double num1, num2;
        
        //Le pido la usuario que introduzca dos números e elija una opción
        System.out.print("Introduzca su primer digito para operar con el:   ");
            num1 = sc.nextDouble();
                
        System.out.print("Por favor, introduzca el segundo digito de operacion:   ");
            num2 = sc.nextDouble();
                
        System.out.println("Elija una de las siguientes operaciones (1-4): ");
        System.out.println("1.- SUMA");
        System.out.println("2.- RESTA");
        System.out.println("3.- MULTIPLICACION");
        System.out.println("4.- DIVISION");
        opcionCalculadora = sc.nextInt();
        
        
        //Uso un switch donde realizaré las operaciones segun la opción elegida por el usuario
        switch (opcionCalculadora) {
            case 1: //suma
                System.out.println("El resultado es: " + (num1+num2));
                break;
            
            case 2: //resta
                System.out.println("El resultado es: " + (num1-num2));
                break;
                
            case 3: //multiplicacion
                System.out.println("El resultado es: " + (num1*num2));
                break;
            
            case 4: //division
                //Aquí añado el seguro para que no se pueda dividir entre 0
                if (num2 == 0) {
                    System.out.print("No es posible dividir entre 0");
                    break;
                }
                
                System.out.println("El resultado es: " + (num1/num2));
                break;
                
            default:
                System.out.print("Por favor, introduzca un numero del 1 al 4 la proxima vez");                               
        }
        */     
        
        
        /* Ejercicio 17: Partiendo de que cualquier DNI tiene un número “n” y una letra “c”, implementa un
        programa que reciba del usuario el número n y calcule la letra que le corresponde, teniendo
        en cuenta que el algoritmo que implementa la Policía Nacional consiste en dividir el número
        n entre 23 y asigna la letra en función del resto de esta división conforme a la siguiente tabla
        (es ejercicio debe implementarse mediante switch):*/
        
        /*
        //Variables
        int n, formulaDNI;
        char c;
        
        //Pido al usuario su DNI
        System.out.print("Por favor, introduzca su DNI:    ");
        n = sc.nextInt();
        
        //Inicio la variable dormulaDNI dandole el valor del resto de la divisón
        formulaDNI = n%23;
        
        //El valor del resto de la divisón equivale a cada case, se le asigna su letra y se muestra el DNI en pantalla
        switch (formulaDNI) {
            case 0: 
                c = 'T';
                System.out.print("Su DNI es " + n + " - " + c);
                break;
                
            case 1:
                c = 'T';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 2:
                c = 'W';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 3:
                c = 'A';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 4:
                c = 'G';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 5:
                c = 'M';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 6:
                c = 'Y';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 7: 
                c = 'F';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 8:
                c = 'P';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 9:
                c = 'D';
                System.out.print("Su DNI es " + n + "" + c);
                break;
               
            case 10:
                c = 'X';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 11:
                c = 'B';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 12:
                c = 'N';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 13:
                c = 'J';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 14: 
                c = 'Z';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 15:
                c = 'S';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 16:
                c = 'Q';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 17:
                c = 'V';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 18:
                c = 'H';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 19:
                c = 'L';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 20:
                c = 'C';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 21:
                c = 'K';
                System.out.print("Su DNI es " + n + "" + c);
                break;
                
            case 22:
                c = 'E';
                System.out.print("Su DNI es " + n + "" + c); 
                break;
                
            default:
                System.out.print("El formato de su número de DNI introducido es incorrecto");
            
        }
        */
        
        
        /*Ejercicio 18: Intenta resolver el ejercicio anterior considerando las posible soluciones como un String y
        accediendo el carácter correspondiente de la cadena (investiga la documentación oficial de la
        clase String y determina el método que permite acceder al carácter concreto de una
        palabra). Doc oficial String: https://docs.oracle.com/javase/8/docs/api/java/lang/String.htm*/
        
        /*
        //Variables
        int dni, formulaDNI;
        String letraDNI = ("TRWAGMYFPDXBNJZSQVHLCK");
    
        //Pido al usuario su DNI
        System.out.print("Por favor, introduzca su DNI:    ");
        dni = sc.nextInt();
        
        //Usaré el valor de formulaDNI para darle el valor de la posición de la letra correcta a charAT();
        formulaDNI = (dni%23);
        
        System.out.print("Su DNI es: " + dni + "" + letraDNI.charAt(formulaDNI));
        */
    }        
            
}