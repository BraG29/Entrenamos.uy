<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main class="form-signup w-50 m-auto">
    <form>
    <h1 class="h3 mb-3 fw-normal">Registro</h1>

    <div class="form-floating my-2">
        <input type="text" class="form-control" id="nombreUsuarioInput" required>
        <label for="nombreUsuarioInput">Nombre de Usuario</label>
    </div>

    <div class="form-floating my-2">
        <input type="text" class="form-control" id="nombreInput" required>
        <label for="nombreInput">Nombre</label>
    </div>

    <div class="form-floating my-2">
        <input type="text" class="form-control" id="apellidoInput" required>
        <label for="apellidoInput">Apellido</label>
    </div>

    <div class="form-floating my-2">
        <input type="email" class="form-control" id="emailInput" placeholder="nombre@ejemplo.com" required>
        <label for="emailInput">Mail</label>
    </div>
    <div class="form-floating my-2">
        <input type="password" class="form-control" id="passwordInput" required>
        <label for="passwordInput">Contraseña</label>
    </div>

    <div class="form-floating my-2">
        <input type="password" class="form-control" id="passwordConfirmInput" required>
        <label for="passwordConfirmInput">Confirmación de Contraseña</label>
    </div>

    <div class="form-floating my-2">
        <input type="date" class="form-control" id="fechaInput" required>
        <label for="fechaInput">Fecha de Nacimiento</label>
    </div>

    <div class="form-floating my-2">
        <input type="file" class="form-control" id="imagenInput" accept="image/png, image/jpeg, image/jpeg">
        <label for="imagenInput">Imagen</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Registro</button>
    </form>
</main>
<jsp:include page="./../template/footer.jsp"/>
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