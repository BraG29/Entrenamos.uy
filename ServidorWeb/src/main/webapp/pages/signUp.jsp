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
<jsp:include page="./../templates/headerSignInSignUp.jsp"/>

  <div class="form-floating my-2">
    <button class="w-50 btn btn-lg btn-success" onclick="toggleSection()" name="botonDeCambioDeRegistro" style="margin-left: 25%;">Cambiar tipo de usuario</button>
  </div>

  <main id="zonaRegistroSocio" class="form-signup w-50 m-auto">
    <form action="/ServidorWeb/signupSocio" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
      <h1 class="h3 mb-3 fw-normal">Registro de Socio</h1>

      <div class="form-floating my-2">
        <input type="text" class="form-control" name="nicknameInput" required>
        <label for="nicknameInput">Nombre de Usuario</label>
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
        <input type="date" class="form-control" id="fechaInput" name="fechaInput" onclick="upperDateControler()" required>
        <label for="fechaInput">Fecha de Nacimiento</label>
      </div>

      <div class="form-floating my-2">
        <input type="file" class="form-control" name="imagenInput" accept="image/png, image/jpeg, image/jpeg">
        <label for="imagenInput">Imagen</label>
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">Registro</button>
    </form>
  </main>

  <main id="zonaRegistroProfesor" class="form-signup w-50 m-auto" style="display:none">
    <form action="signupProfesor" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
      <h1 class="h3 mb-3 fw-normal">Registro de Profesor</h1>

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
        <input type="date" class="form-control" id="fechaInput" name="fechaInput" onclick="upperDateControler()" required>
        <label for="fechaInput">Fecha de Nacimiento</label>
      </div>

      <div class="form-floating my-2">
        <input type="file" class="form-control" name="imagenInput" accept="image/png, image/jpeg, image/jpeg">
        <label for="imagenInput">Imagen</label>
      </div>

      <div class="form-floating my-2">
        <select class="form-select" aria-label="Default select example" name="institucionInput" required>
          <option value="Instituto Natural" selected>Instituto Natural</option>
          <option value="Fuerza Bruta">Fuerza Bruta</option>
          <option value="Telón">Telón</option>
          <option value="Olympic">Olympic</option>
        </select>
        <label for="institucionInput">Institución</label>
      </div>

      <div class="form-floating my-2">
        <textarea class="form-control rounded-1" name="descripcionInput" rows="5"></textarea>
        <label for="descripcionInput">Descripción general</label>
      </div>

      <div class="form-floating my-2">
        <textarea class="form-control rounded-1" name="biografiaInput" rows="5"></textarea>
        <label for="biografiaInput">Biografía</label>
      </div>

      <div class="form-floating my-2">
        <input type="url" class="form-control" name="urlInput">
        <label for="urlInput">Link a sitio web</label>
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">Registro</button>
    </form>
  </main>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
  <script src="./../assets/scripts/main.js" type="text/javascript"></script>
<jsp:include page="./../templates/footer.jsp"/>
</body>
</html>