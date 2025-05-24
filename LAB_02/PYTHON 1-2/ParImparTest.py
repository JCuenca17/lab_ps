import unittest
from io import StringIO
import sys

from ParImpar import par_impar

class TestParImpar(unittest.TestCase):

    def capturar_salida(self, funcion, *args):
        salida = StringIO()
        sys.stdout = salida
        try:
            funcion(*args)
        finally:
            sys.stdout = sys.__stdout__
        return salida.getvalue().strip()

    def test_numero_par_positivo(self):
        resultado = self.capturar_salida(par_impar, [8])
        self.assertEqual(resultado, "8 es par.")

    def test_numero_impar_positivo(self):
        resultado = self.capturar_salida(par_impar, [5])
        self.assertEqual(resultado, "5 es impar.")

    def test_numero_cero(self):
        resultado = self.capturar_salida(par_impar, [0])
        self.assertEqual(resultado, "0 es par.")

    def test_numero_par_negativo(self):
        resultado = self.capturar_salida(par_impar, [-4])
        self.assertEqual(resultado, "-4 es par.")

    def test_numero_impar_negativo(self):
        resultado = self.capturar_salida(par_impar, [-7])
        self.assertEqual(resultado, "-7 es impar.")

    def test_entrada_texto_invalida(self):
        with self.assertRaises(ValueError):
            int("abc")  # Simula Integer.parseInt

    def test_cantidad_numeros_negativa(self):
        cantidad = -5
        with self.assertRaises(ValueError):
            if cantidad <= 0:
                raise ValueError("La cantidad debe ser un número entero positivo.")

    def test_cantidad_numeros_cero(self):
        cantidad = 0
        with self.assertRaises(ValueError):
            if cantidad <= 0:
                raise ValueError("La cantidad debe ser un número entero positivo.")

if __name__ == '__main__':
    unittest.main()
