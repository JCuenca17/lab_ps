import sys
import unittest
from io import StringIO
import CajeroAutomatico

class TestCajero(unittest.TestCase):
    def setUp(self):
        # Guardar los originales stdin/stdout
        self.original_input = input
        self.original_stdout = sys.stdout
        self.saldo_inicial = 1000.00

    def tearDown(self):
        # Restaurar los originales
        sys.stdin = sys.__stdin__
        sys.stdout = self.original_stdout

    def capturar_salida(self, funcion, *args):
        """Captura la salida impresa por una función"""
        salida = StringIO()
        sys.stdout = salida
        funcion(*args)
        sys.stdout = self.original_stdout
        return salida.getvalue()

    def simular_entrada(self, *valores):
        """Simula múltiples entradas del usuario"""
        sys.stdin = StringIO('\n'.join(map(str, valores)) + '\n')

    # 1. Consultar saldo -
    def test_consultar_saldo(self):
        salida = self.capturar_salida(CajeroAutomatico.consultar, self.saldo_inicial)
        self.assertIn(f"S/. {self.saldo_inicial:.2f}", salida)

    # 2. Depositar 400 -
    def test_depositar_400(self):
        self.simular_entrada(400)
        saldo = CajeroAutomatico.depositar(self.saldo_inicial)
        self.assertEqual(saldo, 1400.0)

    # 3. Retirar 100 -
    def test_retirar_100(self):
        self.simular_entrada(100)
        saldo = CajeroAutomatico.retirar(self.saldo_inicial)
        self.assertEqual(saldo, 900.0)

    # 4. Retirar 5000 (fondos insuficientes) -
    def test_retirar_5000(self):
        self.simular_entrada(5000)
        salida = self.capturar_salida(CajeroAutomatico.retirar, self.saldo_inicial)
        self.assertIn("Fondos insuficientes", salida)

    # 5. Depositar número negativo -
    def test_depositar_negativo(self):
        self.simular_entrada(-200)
        salida = self.capturar_salida(CajeroAutomatico.depositar, self.saldo_inicial)
        self.assertIn("positivo", salida)


    # 6. Depositar cadena de texto ("dos mil")
    def test_depositar_texto(self):
        self.simular_entrada("dos mil")
        salida = self.capturar_salida(CajeroAutomatico.depositar, self.saldo_inicial)
        self.assertIn("Error", salida)

    # 7. Depositar con coma decimal (500,5)
    def test_depositar_coma(self):
        self.simular_entrada("500,5")
        salida = self.capturar_salida(CajeroAutomatico.depositar, self.saldo_inicial)
        self.assertIn("Error", salida)

    # 8. Depositar decimal correcto (500.5) -
    def test_depositar_decimal(self):
        self.simular_entrada(500.5)
        saldo = CajeroAutomatico.depositar(self.saldo_inicial)
        self.assertEqual(saldo, 1500.5)

    # 9. Retirar cantidad 0 -
    def test_retirar_cero(self):
        self.simular_entrada(0)
        salida = self.capturar_salida(CajeroAutomatico.retirar, self.saldo_inicial)
        self.assertIn("positivo", salida)

    # 10. Depositar cantidad 0 -
    def test_depositar_cero(self):
        self.simular_entrada(0)
        salida = self.capturar_salida(CajeroAutomatico.depositar, self.saldo_inicial)
        self.assertIn("positivo", salida)

if __name__ == '__main__':
    unittest.main(verbosity=2)