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
    <div class="container">
        <div class="image">
            <div class="form-box">
                <form action="productForm" method="post" class="form">
                    <h2>Registrar producto</h2>
                    <div class="input-box">
                        <input type="text" id="product_name" name="product_name" autofocus required pattern="[A-Za-z ]{2,40}">
                        <label for="product_name">Nombre producto:</label>
                    </div>

                    <div class="input-box">
                        <input type="number"  id="product_value" name="product_value" required pattern="{1,100}">
                        <label for="product_value">precio:</label>
                    </div>

                    <div class="input-box">
                        <input type="number"  id="category_id" name="category_id" required max="3">
                        <label for="category_id">Numero de Categoria:</label>
                    </div>
                    <button type="submit" width="400px">Registrar categoria</button>
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