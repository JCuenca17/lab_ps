def par_impar(lista_numeros):
    for numero in lista_numeros:
        if numero % 2 == 0:
            print(f"{numero} es par.")
        else:
            print(f"{numero} es impar.")

if __name__ == "__main__":
    try:
        cantidad = int(input("¿Cuántos números deseas ingresar?: "))
        if cantidad <= 0:
            raise ValueError("La cantidad debe ser un número entero positivo.")

        numeros = []
        for i in range(cantidad):
            num = int(input(f"Ingrese el número {i + 1}: "))
            numeros.append(num)

        par_impar(numeros)
    except ValueError as e:
        print(f"Error: {e}")