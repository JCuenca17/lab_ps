import unittest
from unittest.mock import Mock
from login_controller import LoginController

class TestLoginController(unittest.TestCase):
    def setUp(self):
        self.mock_auth_service = Mock()
        self.controller = LoginController(self.mock_auth_service)

    def test_login_exitoso(self):
        self.mock_auth_service.authenticate.return_value = True
        resultado = self.controller.login("usuario", "clave")
        self.assertTrue(resultado)
        self.mock_auth_service.authenticate.assert_called_with("usuario", "clave")

    def test_login_fallido(self):
        self.mock_auth_service.authenticate.return_value = False
        resultado = self.controller.login("usuario", "clave_incorrecta")
        self.assertFalse(resultado)
        self.mock_auth_service.authenticate.assert_called_with("usuario", "clave_incorrecta")

if __name__ == "__main__":
    unittest.main()
