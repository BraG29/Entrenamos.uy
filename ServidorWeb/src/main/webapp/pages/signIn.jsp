<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <title>Entrenamos.UY</title>
</head>

<body>
<main class="form-signin w-50 m-auto">
    <form>
    <h1 class="h3 mb-3 fw-normal">Iniciar Sesión</h1>

    <div class="form-floating my-3">
        <input type="email" class="form-control" name="floatingInput" placeholder="nombre@ejemplo.com" required>
        <label for="floatingInput">Usuario o Mail</label>
    </div>
    <div class="form-floating my-3">
        <input type="password" class="form-control" name="floatingPassword" placeholder="Password" required>
        <label for="floatingPassword">Contraseña</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Iniciar Sesión</button>
    </form>
</main>
<jsp:include page="./../templates/footer.jsp"/>
</body>
</html>