<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<main class="form-signup w-50 m-auto">
    <form>
        <h1 class="h3 mb-3 fw-normal">Dar de alta una Actividad Deportiva</h1>

        <div class="form-floating my-2">
            <input type="text" class="form-control" id="nombreActividadInput" required>
            <label for="nombreActividadInput">Nombre de la Actividad</label>
        </div>

        <div class="form-floating my-2">
            <input type="text" class="form-control" id="descripcionActividadInput" required>
            <label for="descripcionActividadInput">Descripción</label>
        </div>

        <div class="form-floating my-2">
            <input type="number" class="form-control" id="duracionActividadInput" min="0" required>
            <label for="duracionActividadInput">Duración</label>
        </div>

        <div class="form-floating my-2">
            <input type="number" class="form-control" id="costoActividadInput" min="0" required>
            <label for="costoActividadInput">Costo</label>
        </div>

        <div class="form-check form-check-inline" style="background: #ddefff;border-radius: 10%;">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
            <label class="form-check-label" for="inlineCheckbox1">Basketball &nbsp;</label>
        </div>
        <div class="form-check form-check-inline" style="background: #ddefff;border-radius: 10%;">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
            <label class="form-check-label" for="inlineCheckbox2">Fútbol &nbsp;</label>
        </div>
        <div class="form-check form-check-inline" style="background: #ddefff;border-radius: 10%;">
            <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
            <label class="form-check-label" for="inlineCheckbox3">Voleiball &nbsp;</label>
        </div>

        <div class="form-floating my-2">
            <input type="file" class="form-control" id="imagenInput" accept="image/png, image/jpeg, image/jpeg">
            <label for="imagenInput">Imagen</label>
        </div>
        <br>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Crear Actividad</button>
    </form>
</main>