num = input("Introduzca un numero: ")

if (len(num) == 1):
    print("El numero tiene un dígito.")
elif (len(num) == 2):
    print("El número tiene dos digitos.")
else:
    print("El número tiene tres o más dígitos.")