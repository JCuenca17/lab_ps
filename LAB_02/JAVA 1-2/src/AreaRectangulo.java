import java.util.Scanner;

public class AreaRectangulo {

    public static double calcularAreaRectangulo(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser positivas.");
        }
        return base * altura;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las dimensiones del rectángulo:");

        try {
            System.out.print("Base: ");
            double base = scanner.nextDouble();

            System.out.print("Altura: ");
            double altura = scanner.nextDouble();

            double area = calcularAreaRectangulo(base, altura);

            System.out.println("\nBase: " + base);
            System.out.println("Altura: " + altura);
            System.out.println("Área del rectángulo: " + area);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida.");
        } finally {
            scanner.close();
        }
    }
}
