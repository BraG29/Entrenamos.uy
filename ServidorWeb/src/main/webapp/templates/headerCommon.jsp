<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="logica.datatypes.DtUsuario"%>
<%@ page import="logica.datatypes.DtUsrKey"%>

<%  DtUsuario usrLogged = (DtUsuario) request.getSession().getAttribute("loggedUser");
    DtUsuario usrProfile = (DtUsuario) request.getAttribute("datoUsuario");
%>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <ul class="nav nav-pills col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="./selectActividadDeportiva.jsp" class="nav-link px-2">Actividades</a></li>
            <li><a href="./selectCuponera.jsp" class="nav-link px-2">Cuponeras</a></li>
            <li><a href="./selectDictadoDeClase" class="nav-link px-2">Clases</a></li>
            <li><a href="./selectUsuario" class="nav-link px-2">Usuarios</a></li>
        </ul>
        <div class="col-md-3 text-end">
            <%if(usrLogged != null) {%>
                <img class="img-thumbnail" alt="<%=usrProfile.getNickname()%>" src="<%=request.getContextPath()%>/api/content?c=usu&id=<%=usrProfile.getNickname()%>">
            <% } %>
            <form action="logout" method="GET" enctype="multipart/form-data" accept-charset="UTF-8">
                <button type="submit" class="btn btn-outline-danger me-2">Cerrar Sesión</button>
            </form>
        </div>
    </header>
</div>