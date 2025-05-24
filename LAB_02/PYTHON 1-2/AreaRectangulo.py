def calcular_area_rectangulo(base, altura):
    if base <= 0 or altura <= 0:
        raise ValueError("La base y la altura deben ser positivas.")
    return base * altura

if __name__ == "__main__":
    print("Ingrese las dimensiones del rectángulo:")
    try:
        base = float(input("Base: "))
        altura = float(input("Altura: "))
        area = calcular_area_rectangulo(base, altura)
        print(f"\nBase: {base}")
        print(f"Altura: {altura}")
        print(f"Área del rectángulo: {area}")
    except ValueError as e:
        print(f"Error: {e}")