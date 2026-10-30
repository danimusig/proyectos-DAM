print("Programa que calcula el consumo de combustible de diferentes tipos de vehiculos.")

cant_automoviles = int(input("¿Cuantos automoviles tiene que repostar?: "))
cant_todoterrenos = int(input("¿Cuantos todoterrenos tiene que repostar?: "))
cant_autobuses = int(input("¿Cuantos autobuses tiene que repostar?: "))

combustible_automovil = cant_automoviles * 45
combustible_todoterrenos = cant_todoterrenos * 70
combustible_autobuses = cant_autobuses * 800

print(f"Sus automoviles consumen {combustible_automovil} litros de gasolina.")
print(f"Sus todoterrenos consumen {combustible_todoterrenos} litros de gasolina.")
print(f"Sus autobuses consumen {combustible_autobuses} litros de gasolina.")