function protect(roleExpected) {
  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  if (!token || role !== roleExpected) {
    window.location.href = "../login.html";
  }
}