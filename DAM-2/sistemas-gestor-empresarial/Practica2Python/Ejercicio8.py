cant_numeros = int(input("Introduzca la cantidad de numeros a introducir: "))
cant_pares = 0
cant_impares = 0

for element in range(cant_numeros):
    num = int(input(f"Introduzca un numero {cant_numeros-element} restantes: "))
    if (num % 2 == 0):
        cant_pares = cant_pares + 1
    else:
        cant_impares = cant_impares + 1

print(f"Hay {cant_pares} numeros pares. ")
print(f"Hay {cant_impares} numeros impares. ")