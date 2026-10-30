print("Programa que calcula el precio de 3 productos introducidos por teclado: ")

precios = 0
for i in range(3):
    precios += float(input("Introduzca el precio: "))

print(f"La suma de los precios es igual a: {precios}")