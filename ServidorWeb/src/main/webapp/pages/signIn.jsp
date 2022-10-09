<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main class="form-signin w-50 m-auto">
    <form>
    <h1 class="h3 mb-3 fw-normal">Iniciar Sesión</h1>

    <div class="form-floating my-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="nombre@ejemplo.com" required>
        <label for="floatingInput">Usuario o Mail</label>
    </div>
    <div class="form-floating my-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
        <label for="floatingPassword">Contraseña</label>
    </div>

    <button class="w-100 btn btn-lg btn-primary" type="submit">Iniciar Sesión</button>
    </form>
</main>
<jsp:include page="./../templates/footer.jsp"/>