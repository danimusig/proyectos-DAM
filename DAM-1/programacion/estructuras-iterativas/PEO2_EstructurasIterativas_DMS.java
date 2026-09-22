package com.mycompany._dms_estructurasiterativas;

import java.util.Scanner;


/**Práctica evaluativa sobre el bucle for, while y do_while
 *
 * @author danielms
 * @version 1.0
 * @see Scanner
 * @see System
 * @see String
 * 
 */



public class EstructurasIterativas_DMS {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        /*Ejercicio 1:[while + for] Modifica el programa anterior para que el 
        usuario introduzca primero el mayor o el menor indistintamente*/
        
        /*
        //Variables
        int num1, num2;
        int i;    
        //Pedimos al usuario los números
        System.out.print("Por favor, introduzca el primer numero:   ");
        num1 = sc.nextInt();
        
        System.out.print("Por favor, introduzca el segundo numero:   ");
        num2 = sc.nextInt();
        
        //SOLUCION CON WHILE
        /*
        if (num1<num2) {
            i = num1;
            
            while(i<=num2) {
                System.out.print(i + " ");
                i++;
            }
            
        } else {
            i = num1;
            
            while (i>=num2) {
                System.out.print(i + " ");
                i--;
            }
        }*/
        
        //SOLUCION CON FOR
        /*
        if (num1<num2) {
        
            for (i=num1;i<=num2;i++) {
                System.out.print(i + " ");
            }
            
        } else {
        
            for (i=num2;i<=num1;i++) {
                System.out.print(i + " ");    
                }
        
        }*/  
        
        
        
        /*Ejercicio 2: [while + for] Escriba un programa que pida un número entero mayor que cero y
        que escriba sus divisores. Recuerda que b es divisor de a cuando a%b==0.*/
        
        /*
        //Variables
        int num1;
        int i = 1;  
        
        //Pedimos al usuario los números
        System.out.print("Por favor, introduzca un numero:   ");
        num1 = sc.nextInt();
        
        /*
        //SOLUCION WHILE
        while (i<=num1) {
        
            if (num1%i==0) {
                System.out.print(i + " ");
            }
        
        i++;       
        }*/
        
        /*        
        //SOLUCION FOR
        for (i=1;i<=num1;i++) {
            
            if (num1%i==0) {
                System.out.print(i + " ");       
            }
            
        }*/    
        
        
        
        /*Ejercicio 3: [while + for] Escriba un programa que pregunte cuántos números se van a
        introducir, pida esos números y escriba cuántos números pares ha introducido y
        cuántos números impares ha introducido*/
        
        /*
        //Variable
        int totalDigitos, numUsuario, i; 
        int pares = 0, impares = 0;
                
        //Le pido al usuario los datos
        System.out.print("Por favor, introduzca el numero de digitos que desea introducir:   ");
        totalDigitos= sc.nextInt();
        
        /*
        //SOLUCION WHILE
        i = 0;
        
        while (i<totalDigitos) {
            System.out.print("Introduzca los " + (totalDigitos-i) + " numeros restantes para saber cuantos son pares o impares:    ");
            numUsuario = sc.nextInt();
            i++;
            
            if (numUsuario%2==0) {
                pares++;
            } else if (numUsuario%2!=0) {
                impares++;
            }
        }
        
        System.out.print("Numeros pares: " + pares);
        System.out.print("Numeros impares: " + impares);
        */
        
        /*
        //SOLUCION FOR
        for (i = 0;i<totalDigitos;i++) {
            System.out.print("Queda " + (totalDigitos-i) + " numero/s restantes para saber cuantos son pares o impares:    ");
            numUsuario = sc.nextInt();
            
            if (numUsuario%2==0) {
                pares++;
            } else if (numUsuario%2!=0) {
                impares++;
            }
        }
        
        System.out.print("Numeros pares: " + pares);
        System.out.print("Numeros impares: " + impares);
        */
        
        
        
        /*Ejercicio 4: Escriba un programa que pregunte cuantos números se van a
        introducir, pida esos números (que puedan ser decimales) y calcule su suma.*/
        
        /*
        //Variables
        int i = 0, digito;
        double numero, resultado = 0;
        
        //Le pido los datos al usuario
        System.out.print("Indica la cantidad de numeros a calcular:   ");
        digito = sc.nextInt();
        
        
        //SOLUCION WHILE
        /*        
        while (i<digito) {
            System.out.print("Introduzca los digitos de la suma:   ");
            numero = sc.nextDouble();
            i++;
            resultado = resultado+numero;
        }
        
        System.out.print("El resultado de la suma es:   " + resultado);
        */

        
        //SOLUCION FOR
        /*
        for (i=0;i<digito;i++) {
            System.out.print("Introduzca los digitos de la suma:   ");
            numero = sc.nextDouble();
            resultado = resultado+numero;
        }
        
        System.out.print("El resultado de la suma es:   " + resultado);
        */
        
        
        /*Ejercicio 5: [while + for] Escriba un programa que pregunte cuántos números se van a
        introducir 1, pida esos números1, y escriba el mayor, el menor y la media aritmética.
        Se recuerda que la media aritmética de un conjunto de valores es la suma3 de esos
        valores dividida por la cantidad de valores4.*/
        
        /*
        //Variables
        int i, cantNum, numMedia, numero, numMayor, numMenor;
        //Le pido al usuario los datos
        System.out.print("Introduzca la cantidad de numeros que va a introducir:    ");
        cantNum = sc.nextInt();
        
        /*
        //SOLCUCION WHILE
        System.out.println("Por favor introduzca las cifras una a una:    ");
        numero = sc.nextInt();
        numMedia = numero;
        numMayor = numero;
        numMenor = numero;
        i = 1;
        
        while (i<cantNum) {
            numero = sc.nextInt();
            
            i++;
            numMedia = numMedia + numero;
            
            if (numero<numMenor) {
                numMenor = numero;
            }else if (numero>numMayor) {
                numMayor = numero;
            }     
        }
        
        System.out.print("El mayor es:   " + numMayor);
        System.out.print("El menor es:   " + numMenor);
        System.out.print("La media aritmetica es:   " + (numMedia/cantNum));
        */
        
        /*
        //SOLUCION FOR
        System.out.println("Por favor introduzca las cifras una a una:    ");
        numero = sc.nextInt();
        numMedia = numero;
        numMayor = numero;
        numMenor = numero;
        
        for (i=1;i<cantNum;i++) {
            numero = sc.nextInt();
            numMedia=numMedia+numero;
            if (numero<numMenor) {
                numMenor = numero;
            }else if (numero>numMayor) {
                numMayor = numero;
            }     
        }
        
        System.out.print("El mayor es:   " + numMayor);
        System.out.print("El menor es:   " + numMenor);
        System.out.print("La media aritmetica es:   " + (numMedia/cantNum));
        */
        
        
        /*Ejercicio 6: [while + for] Escriba un programa que pida un número entero mayor que cero y
        calcule su factorial. Recodad que el factorial de N es 1*2*3*4*…*N. Por
        ejemplo, el factorial de 5 es 1*2*3*4*5=120.*/
        
        /*
        //Variables
        int i, numero, factorial = 1;
        
        //Le pido los datos al usuario
        System.out.print("Por favor, introduzca un número para ver su factorial:    ");
        numero = sc.nextInt();
        
        /*
        //SOLUCION WHILE 
        i = 1;
        factorial = 1;
        
        while (i<=numero) {
            factorial=factorial*i;
            i++;
        }
        System.out.print("El factorial de " + numero + " es igual a " + factorial);
        */
        
        /*
        //SOLUCION FOR
        factorial = 1;
        
        for (i=1;i<=numero;i++) {
            factorial=factorial*i;
        }
        System.out.print("El factorial de " + numero + " es igual a " + factorial);
        */
        
        
        
        /*Ejercicio 7: [while + for] Escribe un programa que pida un número de 1 a 10 y a continuación
        escriba la tabla de multiplicar de ese número.*/
        
        /*
        //Variables
        int i, numero;
        
        //Le pido los datos al usuario
        System.out.print("Por favor, introduzca un numero del 1 al 10 para ver su tabla de multiplicar:     ");
        numero = sc.nextInt();
        
        //SOLUCION WHILE
        i = 1;
        
        /*
        while (i<=10) {
            System.out.print(numero + " x " + i + " = " + (numero*i) + "\n");
            i++;     
        }
        */
        
        /*
        //SOLUCION FOR
        for (i=1;i<=10;i++) {
            System.out.print(numero + " x " + i + " = " + (numero*i) + "\n");
        }
        */
        
        
        
        /*Ejercicio 8: [while + for] Modifica el programa anterior para que no haga falta que se pida
        un número al usuario, es decir, directamente el programa escribe la tabla del 1, a
        continuación del 2, así hasta la tabla del 10.*/
        
        /*
        //Variables
        int i, j;
        
        
        //SOLUCION WHILE
        i=1;
        while (i<=10) {
            
        }   
        */   
        
        /*
        //SOLUCION FOR
        for (int i=1;i<=10;i++) {
            System.out.println("Imprimimos la tabla de multiplicar del "+i+"...");
            
            for (int j=1;j<=10;j++) {
                 System.out.println(i + " x " + j + " = " + (j*i));    
            }
        }
        */
        
        
        
        /*Ejercicio 9: [while + for] Implementa un programa que calcule y muestre por pantalla la
        suma de los 20 primeros números naturales múltiplos de 7.*/
        
        /*
        //Variables
        int i, numero;
        
        /*
        //SOLUCION WHILE
        i = 1;
        numero = 0;
        
        while (i<=20) {  
            numero+=(i*7);
            i++;
        }
        System.out.print("La suma total de los primeros 20 numeros multiplos de 7 es:   " + numero);
        */
        
        /*
        //SOLUCION FOR
        numero = 0;
        
        for (i=1;i<=20;i++) {
                numero+=(i*7);
            }
        System.out.print("La suma total de los primeros 20 numeros multiplos de 7 es:   " + numero);
        */
        
        
        
        /*Ejercicio 10: [while + for] Realiza un programa que cuente los múltiplos de 3 desde el 1 hasta
        un número que introducimos por teclado. Ejemplo:*/
        
        /*
        //Variables
        int i, numero, contMultiplos;
        
        //Le pedimos los datos al usuario
        System.out.print("Dime un numero:  ");
        numero = sc.nextInt();
        /*
        //SOLUCION WHILE
        i= 1;
        contMultiplos = 0;
        
        while (i<=numero) {
            if(i*3<=numero) {
                contMultiplos++;
            }
            i++;
        }
        System.out.print("Cantidad de multiplos de 3:   " + contMultiplos);
        */
        
        /*
        //SOLUCION FOR
        contMultiplos = 0;
        for (i=1;i<=numero;i++) {
            if(i*3<=numero) {
                contMultiplos++;
            }
        }
        System.out.print("Cantidad de multiplos de 3:   " + contMultiplos);
        */
        
        
        
        /*Ejercicio 11:  [while + for] Escriba un programa que determine, mostrando un mensaje por
        pantalla, la suma de 10 números enteros leídos desde teclado. Suponga que los
        números enteros leídos son válidos.*/
        
        /*
        //Variables
        int i, numero, sumaTotal;
        
        /*
        //SOLUCION WHILE
        i = 1;
        sumaTotal = 0;
        
        System.out.println("Introduzca 10 numeros enteros separados con ENTER");
        
        while(i<=10) {
            numero=sc.nextInt();
            sumaTotal+=numero;
            i++;
        }
        
        System.out.print("La suma total de los 10 numeros es " + sumaTotal);
        */
        
        /*
        //SOLUCION FOR
        sumaTotal = 0;
        
        System.out.println("Introduzca 10 numeros enteros separados con ENTER");
        
        for(i=1;i<=10;i++) {
            numero=sc.nextInt();
            sumaTotal+=numero;
        }
        
        System.out.print("La suma total de los 10 numeros es " + sumaTotal);
        */
        
        
        
        /*Ejercicio 12: [while + for] Implementa un programa que solicite al usuario un número (num) y 
        determine sin num es primo o no es primo.*/
        //NOTA: Hecho después de ver la explicación en la pizarra.
        
        /*
        //Variables
        int i, num;
        boolean esPrimo = true;
        
        //Le pido los datos al usuario
        System.out.print("Por favor, introduzca un numero para saber si es primo:   ");
        num = sc.nextInt();
        
        
        //SOLUCION WHILE
        //i = 2 porque tosos los numeros son divisibles
        i = 2;
        
        while (i<num && esPrimo) {
            if (num % i == 0 ) {
                esPrimo = false;
            }
            i++;
        }
        
        if (esPrimo) {
            System.out.print(num + " es primo.");
        } else {
            System.out.print(num + " no es primo.");
        }*/
        
        
        /*
        //SOLUCION FOR
        for (i=2;i<num && esPrimo;i++) {
            if (num % i == 0 ) {    
                esPrimo = false;
            }
        }
        
        if (esPrimo) {
            System.out.print(num + " es primo.");
        } else {
            System.out.print(num + " no es primo.");
        }
        */
        
        
        
        /*Ejercicio 13: [2 for anidado] Crea una aplicación que dibuje una escalera de asteriscos.
        Nosotros le pasamos la altura de la escalera por teclado. Este es un ejemplo si
        insertaras un 5 de altura:*/
        
        /*
        //Variables
        int i, j, num;
        
        //Le pido los datos al usuario
        System.out.print("Introduzca la altura de su escalera de asteriscos:    ");
        num = sc.nextInt();
        
        //SOLUCION FOR + FOR
        for (i=1;i<=num;i++) {
            for(j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        */
        
        
        
        /*Ejercicio 14: [2 for anidado] Crea una aplicación que dibuje una escalera inversa de asteriscos.
        Nosotros le pasamos la altura de la escalera inversa por teclado.*/
        
        /*
        //Variables
        int i, j, num;
        
        //Le pido los datos al usuario
        System.out.print("Introduzca la altura de su escalera de asteriscos:    ");
        num = sc.nextInt();
        
        //SOLUCION FOR + FOR
        for (i=1;i<=num;i++) {
            for(j=num;j>=i;j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        */
        
        
        
        /*Ejercicio 15: [2 for anidado] Crea una aplicación que dibuje una escalera de números, siendo
        cada línea números empezando en uno y acabando en el numero de la línea*/
        
        /*
        //Variables
        int i, j, num, contador;
        
        //Le pido los datos al usuario
        System.out.print("Introduzca la altura de su escalera de asteriscos:    ");
        num = sc.nextInt();
        
        //SOLUCION FOR + FOR
        contador=0;
        
        for (i=1;i<=num;i++) {
            contador++;
            for(j=1;j<=i;j++) {
                System.out.print(contador);
            }
            System.out.println();
        }
        */
        
        
        
        /*Ejercicio 16: [for] Escribe un programa que solicite al usuario dos números, uno real (base) y 
        un entero positivo (exponente), e imprima por pantalla el resultado de la 
        potencia. No se puede utilizar el operador de potencia. Recuerda que 2,305 = 2,30 
        x 2,30 x 2,30 x 2,30 x 2,30.*/
        
        /*
        //Variables
        int i, base, exponente, calcPotencia, resultado;
        
        //Le pido al usuario los datos
        System.out.print("Introduzca la base de la potencia:    ");
        base = sc.nextInt();
        
        System.out.print("Introduzca el exponente de la potencia:    ");
        exponente = sc.nextInt();
        
        //SOLUCION FOR
        resultado = 1;
        
        for(i=1;i<=exponente;i++) {
            resultado*=base;
        }
       
        System.out.print("El resultado de la potencia con base " + base + " y exponente " + exponente + " es igual a " + resultado);
        */
        
        
        
        /*Ejercicio 17: [do while] Escribe un programa que calcule la suma de varios números decimales
        introducidos por teclado. El proceso debe terminar cuando se introduzca un
        número negativo por teclado, mostrando en ese momento la suma de los números
        previos e indicando cuántos números se han sumado.*/
        
        /*
        //Variables
        int i, num, suma, contNum;
        
        //Le pdio al usuario los datos
        System.out.println("Introduzca los números enteros, introduzca uno negativo para parar la lista:  ");
        
        contNum = 0;
        suma = 0;
        
        //SOLUCION DO WHILE
        do {
            num = sc.nextInt();
            
            if (num>=0) {
            suma+=num;
            contNum++; 
            }
            
        } while (num>=0);
    
        System.out.println("La suma total de los numero es: " + suma);
        System.out.println("El numero de digitos introducidos es: " + contNum);
        */
        
        
        
        /*Ejercicio 18: Implementa un programa que solicite al usuario el nº de toros que corren en el
        encierro (n>1). A continuación, para cada uno de esos toros, solicita la velocidad
        a la que va (un entero que representa los km/h). El programa calcula y devuelve
        la velocidad a la que deberán ir los corredores expertos para mantener el
        espectáculo. */
        
        /*
        //Variables
        int i, numToros, velocidad, veloNecesaria;
        
        //Le pido los datos al usuario
        System.out.print("Introduzca el numero de toros de la corrida:  ");
        numToros = sc.nextInt();
        
        
        //SOLUCION FOR
        velocidad = 0;
        veloNecesaria = velocidad;
        for (i=1;i<=numToros;i++) {
            System.out.print("Introduzca la velocidad de cada toro:  ");
            velocidad = sc.nextInt();
            
            if (velocidad>veloNecesaria) {
                veloNecesaria = velocidad;
            }
        }
        
        System.out.print("La velocidad necesaria para evitar los toros es de " + veloNecesaria + " Km/h");
        */
        
        
        /*Ejercicio 19: Implementa un programa cuya solicite al usuario el número de operaciones que
        va a realizar el ascensor en ese día (en rojo). A continuación, se indican los pisos
        que vista (el primero marca el piso inicial en el que empieza el ascensor, siendo el
        0 la planta baja, y no habiendo plantas por debajo de ella).
        El programa devuelve la longitud (en número de pisos) del recorrido completo
        del ascensor a lo largo del día.*/
        
        /*
        //Variables 
        int i, numRecorridos, pisoActual, pisoAnterior, recorrido, movimiento;
        
        //Pido los datos al usuario
        System.out.print("Por favor introduca el numero de recorridos realizados:   ");
        numRecorridos = sc.nextInt();
        
        //Pido el primero fuera del bucle y lo guardo en una variable para marcar el inicio del ascensor
        System.out.println("Introduzca los pisos visitados:   ");
        pisoAnterior = sc.nextInt();
        
        recorrido=0;
        
        // i<=numRecorridos-1 porque uno de los valores se pide fuera
        for (i=1;i<=(numRecorridos-1);i++) {
            pisoActual=sc.nextInt();
            
            if(pisoActual>=pisoAnterior) {
                movimiento = pisoActual - pisoAnterior;
            } else {
                movimiento = pisoAnterior - pisoActual;
            }
            
            recorrido = recorrido+movimiento;
            pisoAnterior = pisoActual;
        }
       
        System.out.print("El recorrido total del ascensor ha sido de " + recorrido + " movimientos.");
        */
        
        
        /*Ejercicio 20: Implementa un programa en Java que lea una cadena con el mensaje a codificar
        (String) y el desplazamiento (int) y codifique dicho mensaje usando codificación
        César con desplazamiento.*/
        //NOTA: Hecho después de ver la explicación en la pizarra.
        
        
        /*
        //Variables
        String palabra, codificado, abecedario;
        int i, desplazamiento, posicionLetra, nuevaPosicion;
        char nuevaLetra, letra;
        
        //Le pido la cadena al usuario
        System.out.print("Por favor introduzca una frase para codificar:    ");
        palabra = sc.nextLine();
        
        System.out.print("Por favor introduzca el desplazamiento:   ");
        desplazamiento = sc.nextInt();
        
        //Solucion
        codificado = "";
        abecedario = "abcdefghijklmnopqrstuvwxyz";
        
        for (i=0;i<palabra.length();i++) {
            
            //Una a una representamos la posicion de las letras de "palabra" dentro de "abecedario"
            letra = palabra.charAt(i);
            posicionLetra = abecedario.indexOf(letra);
            nuevaPosicion = posicionLetra + desplazamiento;
            
            //Con el valor de nuevaPosición sabemos que letra de "abecedario" necesitamos
            nuevaLetra = abecedario.charAt(nuevaPosicion);
            codificado = codificado + nuevaLetra;
         
        }
        
        System.out.print("El mensaje codificado es:" + codificado);
        */
    }
}

