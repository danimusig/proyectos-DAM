d = int(input("Introduzca el dia:  "))
m = int(input("Introduzca el mes:  "))
a = int(input("Introduzca el año:  "))

if((d >= 20 and m == 3) or (d < 21 and m == 6)):
    print("Primavera")
elif((d >= 21 and m == 6) or (d < 23 and m == 9)):
    print("Verano")
elif((d >= 23 and m == 9) or (d < 21 and m == 12)):
    print("Otoño")
elif((d >= 21 and m == 12) or (d < 20 and m == 3)):
    print("Invierno")