num1 = int(input("Introduzca un numero:  "))
num2 = int(input("Introduzca otro numero:  "))

numMayor: int
numMenor: int

if(num1 > num2):
    numMayor = num1
    numMenor = num2
else:
    numMayor = num2
    numMenor = num1

if (numMayor % numMenor == 0):
    print(f"{numMenor} es divisor de {numMayor} ")
else:
    print(f"{numMenor} no es divisor de {numMayor} ")
