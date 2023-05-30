<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Emanuel">
    <meta name="description" content="formulario de registro APLICACION">
    <meta name="keywords" content="registro,creacion de cuenta de usuario">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register form</title>
    <link rel="icon" type="image/x-icon" href="img/juego.png">
    <!-- Latest compiled and minified CSS -->

    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/register-form.css">
    <link rel="stylesheet" href="css/menu.css">

    <script src="https://kit.fontawesome.com/861b3604ef.js" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navegation">
    <i id="burger-button" class="fa-solid fa-bars"></i>
    <div class="nav">
        <img src="img/juego.png" alt="logo">
        <a href="index.jsp"><i class="fa-solid fa-house"></i> Registrar</a>
        <a href="registerForm.jsp">Ingresar</a>
        <a href="productRegister.jsp">Producto</a>
        <a href="categoryRegister.jsp">Categoria</a>
    </div>
</nav>
<main class="logo-form">
    <div class="message">
        <img src="img/juego.png" alt="logo" width="200px">
        <h1><span class="s1">My</span> <span class="s2">APP</span></h1>
    </div>
    <div class="container">
        <div class="image">
            <div class="form-box">
                <form action="registerForm" method="post" class="form">
                    <h2>¡Inicia sesión!</h2>
                    <div class="input-box">
                        <input type="email"  id="user_email" name="user_email" required pattern="{60}">
                        <label for="user_email">Correo:</label>
                    </div>

                    <div class="input-box">
                        <input type="password"  id="user_password" name="user_password" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$">
                        <label for="user_password">Contraseña:</label>
                    </div>
                    <div class="group">
                        <a href="">¿Olvidaste tu contraseña?</a>
                        <a href="index.jsp">registrarse</a>
                    </div>
                    <button type="submit">Iniciar sesión</button>
                </form>
            </div>
        </div>
    </div>
</main>

<p class="copyR">Todos los derechos reservados APLICACIÓN
    ©<%=displayDate()%></p>
<!-- Latest compiled JavaScript -->

<%!
    public String displayDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date = Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }
%>
<script src="js/nav.js"></script>
</body>
</html>