class LoginController:
    def __init__(self, auth_service):
        self.auth_service = auth_service

    def login(self, username: str, password: str) -> bool:
        return self.auth_service.authenticate(username, password)
