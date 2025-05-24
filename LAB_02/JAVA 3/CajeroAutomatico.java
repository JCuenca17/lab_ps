import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {
    private double saldo;

    public CajeroAutomatico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void mostrarMenu() {
        System.out.println("\n--- Menú Cajero Automático ---");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar Dinero");
        System.out.println("3. Retirar Dinero");
        System.out.println("4. Salir");
    }

    public void consultarSaldo() {
        System.out.printf("\nTu saldo actual es: S/. %.2f%n", saldo);
    }

    public void depositar(double monto) throws IllegalArgumentException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        saldo += monto;
        System.out.printf("Depósito exitoso. Nuevo saldo: S/. %.2f%n", saldo);
    }

    public void retirar(double monto) throws IllegalArgumentException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        saldo -= monto;
        System.out.printf("Retiro exitoso. Nuevo saldo: S/. %.2f%n", saldo);
    }

    // Método para simular entrada de usuario en pruebas
    public void procesarDeposito(String entrada) throws IllegalArgumentException, NumberFormatException {
        try {
            // Reemplazar coma por punto para manejar formatos internacionales
            // String entradaNormalizada = entrada.replace(',', '.');
            String entradaNormalizada = entrada;
            double monto = Double.parseDouble(entradaNormalizada);
            depositar(monto);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error: Entrada no numérica no válida.");
        }
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico(1000.00);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            cajero.mostrarMenu();
            System.out.print("Seleccione una opción (1-4): ");
            
            try {
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        cajero.consultarSaldo();
                        break;
                    case 2:
                        System.out.print("Ingrese el monto a depositar: ");
                        scanner.nextLine(); // Limpiar buffer
                        String entradaDeposito = scanner.nextLine();
                        try {
                            cajero.procesarDeposito(entradaDeposito);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingrese un número válido.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        cajero.retirar(montoRetiro);
                        break;
                    case 4:
                        System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido para la opción.");
                scanner.next(); // Limpiar el buffer del scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public double getSaldo() {
        return saldo;
    }
}