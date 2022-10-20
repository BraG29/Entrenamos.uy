<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>    
<%@ page import="datatypes.DtUsuario"%>
<%@ page import="datatypes.DtUsrKey"%>
<%@ page import="datatypes.DtProfesor"%>
<%@ page import="datatypes.DtSocio"%>
<%@ page import="datatypes.DtCuponera"%>
<%@ page import="datatypes.DtClase"%>
<%@ page import="datatypes.DtActividadDeportiva"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	<link rel="stylesheet" href="./../assets/styles/main.css">
  <title>Entrenamos.UY</title>
</head>
<% DtUsuario usrLogged = (DtUsuario) request.getSession().getAttribute("loggedUser");
  DtUsuario usrProfile = (DtUsuario) request.getAttribute("datoUsuario");
  boolean db = (boolean) request.getAttribute("db"); %>

<body>
  <jsp:include page="./../templates/headerCommon.jsp"/>
          
  <main id="listOfUsers">
    <div class="album py-5 bg-light">
      <div class="container">
        <h2 class="h3 mb-3 fw-normal">Lista de usuarios</h2>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <div class="list-group">
            <% List<?> varActDepoAsociadas = (List<?>) request.getAttribute("actividadesAsociadas"); %>
            <% for ( Object index: varActDepoAsociadas ) { %>
              <a href="<%=request.getContextPath()%>/actividades?actividad=<%=((DtActividadDeportiva)index).getNombre()%>" class="list-group-item list-group-item-action">
                <img alt="Actividad Asociada" src="<%=request.getContextPath()%>/api/content?c=act&id=<%=((DtActividadDeportiva)index).getNombre()%>" class="vertical-align-middle imagenSeleccionable">
              </a>
                <b> <%=((DtActividadDeportiva)index).getNombre()%> </b>
							<% } %>
          </div>
        </div>
      </div>
    </div>
  </main>

  <jsp:include page="./../templates/footer.jsp"/>
</body>
</html>