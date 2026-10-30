print("Muestra un resultado diferente si la variablees de tipo texto o numerica")

var = "Hola"

#if (var.isalpha()):
#    print("Cadena de caracteres.")
#elif (var.isdigit()):
#    print("Entero")

if isinstance(var, str):
    print("Cadena de caracteres.")
elif isinstance(var, int):
    print("Entero")