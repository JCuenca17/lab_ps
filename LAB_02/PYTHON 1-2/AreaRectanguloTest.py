import unittest

from math import isclose
from AreaRectangulo import calcular_area_rectangulo

class TestAreaRectangulo(unittest.TestCase):

    def test_positive_values(self):
        base, altura = 5.0, 4.0
        resultado = calcular_area_rectangulo(base, altura)
        self.assertAlmostEqual(resultado, 20.0, places=4, msg=f"Base: {base}, Altura: {altura} debe ser 20.0")

    def test_negative_values(self):
        with self.assertRaises(ValueError):
            calcular_area_rectangulo(-5.0, -3.0)

    def test_positive_and_negative_values(self):
        with self.assertRaises(ValueError):
            calcular_area_rectangulo(5.0, -3.0)

    def test_zero_values(self):
        with self.assertRaises(ValueError):
            calcular_area_rectangulo(0, 0)

    def test_decimal_values(self):
        base, altura = 2.5, 4.1
        esperado = 10.25
        resultado = calcular_area_rectangulo(base, altura)
        self.assertAlmostEqual(resultado, esperado, places=4, msg=f"Base: {base}, Altura: {altura} debe ser {esperado}")

    def test_very_large_values(self):
        base, altura = 1e9, 2e9
        esperado = base * altura
        resultado = calcular_area_rectangulo(base, altura)
        self.assertTrue(isclose(resultado, esperado, rel_tol=1e-5), f"Base: {base}, Altura: {altura} debe ser {esperado}")

    def test_very_small_values(self):
        base, altura = 1e-9, 2e-9
        esperado = base * altura
        resultado = calcular_area_rectangulo(base, altura)
        self.assertTrue(isclose(resultado, esperado, rel_tol=1e-9), f"Base: {base}, Altura: {altura} debe ser {esperado}")

if __name__ == '__main__':
    unittest.main()
