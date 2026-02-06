function login() {
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  if (!email || !password) {
    document.getElementById("error").innerText = "Completa todos los campos";
    return;
  }

  // Simulación (luego va backend)
  localStorage.setItem("token", "fake-jwt");
  localStorage.setItem("role", "CLIENT");

  window.location.href = "client/dashboard.html";
}

function goRegister() {
  window.location.href = "register.html";
}

function goLogin() {
  window.location.href = "login.html";
}