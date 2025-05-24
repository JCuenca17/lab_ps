import tkinter as tk
from tkinter import messagebox
from login_controller import LoginController
from auth_service import AuthService

class LoginView:
    def __init__(self, root):
        self.root = root
        self.root.title("Login")

        self.controller = LoginController(AuthService())

        tk.Label(root, text="Usuario:").grid(row=0, column=0)
        tk.Label(root, text="Contraseña:").grid(row=1, column=0)

        self.username_entry = tk.Entry(root)
        self.password_entry = tk.Entry(root, show="*")

        self.username_entry.grid(row=0, column=1)
        self.password_entry.grid(row=1, column=1)

        tk.Button(root, text="Iniciar Sesión", command=self.attempt_login).grid(row=2, column=0, columnspan=2)

    def attempt_login(self):
        username = self.username_entry.get()
        password = self.password_entry.get()
        if self.controller.login(username, password):
            messagebox.showinfo("Éxito", "Inicio de sesión exitoso.")
        else:
            messagebox.showerror("Error", "Credenciales inválidas.")

if __name__ == "__main__":
    root = tk.Tk()
    app = LoginView(root)
    root.mainloop()
