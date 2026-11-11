momento_dia = input("Introduzca el momento del dia - m = mañana, t = tarde, n = noche")
sexo = input("Introduzca su sexo  f = femenino, m = masculino ")

match(momento_dia):
    case 'm' if sexo == 'f':
            print("Buenos dias señora")
    case 'm' if sexo == 'm':
            print("Buenos dias señor")
    case 't' if sexo == 'f':
            print("Buenas tardes señora")
    case 't' if sexo == 'm':
            print("Buenas tardes señor")
    case 'n' if sexo == 'f':
            print("Buenas noches señora")
    case 'n' if sexo == 'm':
            print("Buenas noches señor")
    case _:
          print("Introuzca un valor válido...")