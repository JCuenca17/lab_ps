def menu():
    print("\n--- Menú Cajero Automático ---")
    print("1. Consultar Saldo")
    print("2. Depositar Dinero")
    print("3. Retirar Dinero")
    print("4. Salir")

def consultar(saldo):
    print(f"\nTu saldo actual es: S/. {saldo:.2f}")

def depositar(saldo):
    try:
        monto = float(input("Ingrese el monto a depositar: "))
        if monto <= 0:
            raise ValueError("El monto debe ser positivo.")
        saldo += monto
        print(f"Depósito exitoso. Nuevo saldo: S/. {saldo:.2f}")
    except ValueError as e:
        print(f"Error: {e}")
    return saldo

def retirar(saldo):
    try:
        monto = float(input("Ingrese el monto a retirar: "))
        if monto <= 0:
            raise ValueError("El monto debe ser positivo.")
        if monto > saldo:
            raise ValueError("Fondos insuficientes.")
        saldo -= monto
        print(f"Retiro exitoso. Nuevo saldo: S/. {saldo:.2f}")
    except ValueError as e:
        print(f"Error: {e}")
    return saldo

def main():
    global saldo
    saldo = 1000.00

    while True:
        menu()
        try:
            opcion = int(input("Seleccione una opción (1-4): "))
            if opcion == 1:
                consultar(saldo)
            elif opcion == 2:
                saldo = depositar(saldo)
            elif opcion == 3:
                saldo = retirar(saldo)
            elif opcion == 4:
                print("Gracias por usar el cajero. ¡Hasta luego!")
                break
            else:
                print("Opción inválida. Por favor, seleccione entre 1 y 4.")
        except ValueError:
            print("Error: Ingrese un número entero válido.")

if __name__ == "__main__":
    main()