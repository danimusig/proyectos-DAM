año_usuario = int(input("¿En que año estamos?:  "))
año_aleatorio = int(input("Introduzca un año aleatorio:  "))

if (año_usuario < año_aleatorio):
    print(f"Para llegar al año {año_usuario} faltan {(año_aleatorio - año_usuario)} años")
else:
    print(f"Desde {año_usuario} han pasado {(año_usuario - año_aleatorio)} años")

