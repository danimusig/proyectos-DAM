from math import sqrt

print("Soluciona ecuaciones ")

a = int(input("Introduzca el primer coeficiente:"))
b = int(input("Introduzca el segundo coeficiente:"))
c = int(input("Introduzca el tercer coeficiente:"))

discriminante = (b ** 2) - (4 * a * c)

if discriminante < 0:
    print("La ecuación no tiene soluciones reales (el discriminante es negativo).")
else:
    x1 = (-b + sqrt(discriminante)) / (2 * a)
    x2 = (-b - sqrt(discriminante)) / (2 * a)
    print(f"x1 = {x1}")
    print(f"x2 = {x2}")