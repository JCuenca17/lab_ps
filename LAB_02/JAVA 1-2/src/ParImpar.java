import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ParImpar {

    public static String determinarParImpar(int numero) {
        if (numero % 2 == 0) {
            return numero + " es par.";
        } else {
            return numero + " es impar.";
        }
    }

    public static void analizarLista(List<Integer> numeros) {
        for (int numero : numeros) {
            System.out.println(determinarParImpar(numero));
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("¿Cuántos números deseas ingresar?: ");
            int cantidad = sc.nextInt();

            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser un número entero positivo.");
            }

            List<Integer> numeros = new ArrayList<>();
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Ingrese el número " + (i + 1) + ": ");
                numeros.add(sc.nextInt());
            }

            analizarLista(numeros);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
