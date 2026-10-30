from math import pi

print("Programa que calcula el area de un circulo en base a su radio: ")

radio = float(input("Introduzca el radio del círculo: "))
area = pi * (pow(radio, 2))
print(f"El area del circulo con radio {radio} es: {area}")