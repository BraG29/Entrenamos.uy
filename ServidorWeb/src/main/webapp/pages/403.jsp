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

<div class="row justify-content-center">
    <div class="col-md-12 col-sm-12">
      <div class="card shadow-lg border-0 rounded-lg mt-5 mx-auto" style="width: 30rem;">
        <h3 class="card-header display-1 text-muted text-center"> 403</h3>
        <span class="card-subtitle mb-2 text-muted text-center"> Acceso denegado </span>
        <div class="card-body mx-auto">
          <a type="button" href="../HelloWorld.jsp" class="btn btn-sm btn-info text-white"> Volver al Principio </a>
        </div>
      </div>
    </div>
</div>
<jsp:include page="./../templates/footer.jsp"/>

</body>
</html>