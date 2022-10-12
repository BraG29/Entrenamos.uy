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
<main class="form-signup w-50 m-auto">
    <form>
    <h1 class="h3 mb-3 fw-normal">Registro</h1>

    <div class="form-floating my-2">
        <input type="text" class="form-control" name="nombreUsuarioInput" required>
        <label for="nombreUsuarioInput">Nombre de Usuario</label>
    </div>

    <div class="form-floating my-2">
        <input type="text" class="form-control" name="nombreInput" required>
        <label for="nombreInput">Nombre</label>
    </div>

    <div class="form-floating my-2">
        <input type="text" class="form-control" name="apellidoInput" required>
        <label for="apellidoInput">Apellido</label>
    </div>

    <div class="form-floating my-2">
        <input type="email" class="form-control" name="emailInput" placeholder="nombre@ejemplo.com" required>
        <label for="emailInput">Mail</label>
    </div>
    <div class="form-floating my-2">
        <input type="password" class="form-control" name="passwordInput" required>
        <label for="passwordInput">Contraseña</label>
    </div>

    <div class="form-floating my-2">
        <input type="password" class="form-control" name="passwordConfirmInput" required>
        <label for="passwordConfirmInput">Confirmación de Contraseña</label>
    </div>

    <div class="form-floating my-2">
        <input type="date" class="form-control" name="fechaInput" required>
        <label for="fechaInput">Fecha de Nacimiento</label>
    </div>

    <div class="form-floating my-2">
        <input type="file" class="form-control" name="imagenInput" accept="image/png, image/jpeg, image/jpeg">
        <label for="imagenInput">Imagen</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Registro</button>
    </form>
</main>
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script>
    var dateControler = {
        currentDate: null
    }

    $(document).on("change", "#fechaInput", function (event, ui) {
        var now = new Date();
        var selectedDate = new Date($(this).val());

        if (selectedDate > now) {
        $(this).val(dateControler.currentDate)
        } else {
        dateControler.currentDate = $(this).val();
        }
    });
</script>
<jsp:include page="./../templates/footer.jsp"/>
</body>
</html>