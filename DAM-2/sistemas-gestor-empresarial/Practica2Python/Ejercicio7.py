numero_dni = int(input("Introduzca el numero del DNI sin la letra."))
letra = ""

match(numero_dni % 23):
    case 0: 
        letra = 'T'
    case 1: 
        letra = 'R'
    case 2: 
        letra = 'W'
    case 3: 
        letra = 'A'
    case 4: 
        letra = 'G'
    case 5: 
        letra = 'M'
    case 6: 
        letra = 'Y'
    case 7: 
        letra = 'F'
    case 8: 
        letra = 'P'
    case 9: 
        letra = 'D'
    case 10: 
        letra = 'X'
    case 11: 
        letra = 'B'
    case 12: 
        letra = 'N'
    case 13: 
        letra = 'J'
    case 14: 
        letra = 'Z'
    case 15: 
        letra = 'S'
    case 16: 
        letra = 'Q'
    case 17: 
        letra = 'V'
    case 18: 
        letra = 'H'
    case 19: 
        letra = 'L'
    case 20: 
        letra = 'C'
    case 21: 
        letra = 'K'
    case 22: 
        letra = 'E'

print(f"Su DNI es: {numero_dni}{letra}")