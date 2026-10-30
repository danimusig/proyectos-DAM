print("Programa que calcula el cociente y resto de dos numeros.")

operando1 = int(input("Introduzca el primer numero: "))
operando2 = int(input("Introduzca el segundo numero: "))

if operando1 == 0 or operando2 == 0:
    print("No se puede dividir por 0.")
else:
    cociente = operando1 / operando2
    resto = operando1 % operando2
    print(f"El cociente de la division es : {cociente} \n"
          f"El resto de la division es: {resto}")
