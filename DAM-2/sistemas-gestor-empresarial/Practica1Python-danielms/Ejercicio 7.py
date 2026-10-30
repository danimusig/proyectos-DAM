print("Muestra el valor en segundos de una serie de dias, horas y minutos.")

dias = int(input("Introduzca los dias: ") * 86,400)
horas = int(input("Introduzca las horas: ") * 3600)
minutos = int(input("Introduzca los minutos") * 60)

segundos_dia = dias * 86,400
segundos_hora = horas * 3600
segundos_minuto = minutos * 60

print(f"En {dias} días, hay {segundos_dia} segundos.")
print(f"En {horas} horas, hay {segundos_hora} segundos.")
print(f"En {minutos} minutos, hay {segundos_minuto} segundos.")