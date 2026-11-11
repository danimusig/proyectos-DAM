edad = int(input("Introduzca la edad del jugador: "))

if(edad < 4):
    print("Puede entrar gratis.")
elif(edad >= 4 and edad < 18):
    print("El precio de la entrada es de 5€") 
else:
    print("El precio de la entrada es de 10€")