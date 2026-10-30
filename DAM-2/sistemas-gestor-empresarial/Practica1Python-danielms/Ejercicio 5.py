print("Calcula el descuento de un producto basandose en el precio y descuento introducidos.")

precio = float(input("Introduzca el precio del producto: "))
descuento = float(input("Introduzca el porcentaje de descuento: "))

precio_descontado = precio - (precio * descuento / 100)

print(f"El valor del producto descontado es: {precio_descontado}")
