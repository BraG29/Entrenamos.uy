<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main class="form-signup w-50 m-auto">
    <form>
        <h1 class="h3 mb-3 fw-normal">Dar de alta Dictado de Clase</h1>

        <p style="color:red;">Este select lista las actividades deportivas con estado = aceptado</p>
        <select class="form-select" aria-label="Default select example">
            <option selected>Elija una actividad</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
        </select>

        <div class="form-floating my-2">
            <input type="text" class="form-control" id="nombreClaseInput" required>
            <label for="nombreClaseInput">Nombre de la Clase</label>
        </div>

        <div class="form-floating my-2">
            <input type="date" class="form-control" id="fechaClaseInput" required>
            <label for="fechaClaseInput">Fecha de comienzo</label>
        </div>

        <div class="form-floating my-2">
            <input type="number" class="form-control" id="horaInput" min="0" max="23" required>
            <label for="horaInput">Hora de inicio</label>
        </div>

        <div class="form-floating my-2">
            <input type="number" class="form-control" id="minimoInput" min="0" required>
            <label for="minimoInput">Mínima cantidad de socios</label>
        </div>

        <div class="form-floating my-2">
            <input type="number" class="form-control" id="maximoInput" min="1" required>
            <label for="maximoInput">Máxima cantidad de socios</label>
        </div>

        <div class="form-floating my-2">
            <input type="url" class="form-control" id="urlClaseInput" required>
            <label for="urlClaseInput">URL asociada</label>
        </div>

        <br>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Crear Clase</button>
    </form>
</main>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
    integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script>
    var dateControler = {
        currentDate: null
    }

    $(document).on("change", "#fechaClaseInput", function (event, ui) {
        var now = new Date();
        var selectedDate = new Date($(this).val());

        if (selectedDate < now) {
            $(this).val(dateControler.currentDate)
        } else {
            dateControler.currentDate = $(this).val();
        }
    });
</script>