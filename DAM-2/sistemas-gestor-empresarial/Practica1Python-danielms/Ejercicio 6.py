print("Calcula el valor en dolares de una cantidad de euros introducidos.")

dolares = float(input("Introduzca los dolares: "))
cambio_euros = dolares - (dolares * 0.33250)

print(f"{dolares}$ equivales a {cambio_euros}€.")