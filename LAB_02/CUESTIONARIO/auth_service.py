class AuthService:
    def authenticate(self, username: str, password: str) -> bool:
        # Lógica real de autenticación (por ejemplo, consulta a una base de datos)
        return username == "admin" and password == "1234"
