<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>    
<%@ page import="logica.datatypes.DtUsuario"%>
<%@ page import="logica.datatypes.DtUsrKey"%>
<%@ page import="logica.datatypes.DtProfesor"%>
<%@ page import="logica.datatypes.DtSocio"%>
<%@ page import="logica.datatypes.DtCuponera"%>
<%@ page import="logica.datatypes.DtClase"%>
<%@ page import="logica.datatypes.DtActividadDeportiva"%>

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
	<jsp:include page="./../templates/headerCommon.jsp" />
	<!--CUERPO DE LA PAGINA WEB-->
	<div class="container-fluid mt-4">
		<div class="row mx-3 mx-md-5">
			<div id="user-general" class="col-sm-7">
				<%
				Boolean comprada = false;
				DtUsuario usrLogged = (DtUsuario) request.getSession().getAttribute("loggedUser");
				DtCuponera varDTCuponera = (DtCuponera) request.getAttribute("cuponera");
				if (usrLogged != null && usrLogged instanceof DtSocio){
					DtSocio usr = (DtSocio)usrLogged;
					Set<String> setCupsCompradas = usr.getCuponerasCompradas();
					for (String x: setCupsCompradas) {
						if (x.equals(varDTCuponera.getNombre())){
							comprada = true;
						}  
					}
				}
				%>
				<div class="row">
					<div class="col-3 py-3">
						<div >
							<img alt="Imagen de la Cuponera" class="img-thumbnail" src="<%=request.getContextPath()%>/api/content?c=cup&id=<%=varDTCuponera.getNombre()%>">
						</div>
					</div>
					<div class="col-9 py-3">
						<div id="user-info" class="row">
							<p><strong><%= varDTCuponera.getNombre() %></strong></p>
						</div>
						<div id="creatorDiv" class="row">
							<div class="col-auto">
								<%  Boolean varYaComprado = (usrLogged != null) && (usrLogged instanceof DtSocio) && (comprada == false);
	    	    				if (varYaComprado == true){ %>
								<button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/ComprarCuponera?cuponera=<%=varDTCuponera.getNombre()%>'">
									Comprar
								</button>
								<%}%>
								<%if ((usrLogged != null) && (usrLogged instanceof DtSocio) && (comprada == true)){ %>
								<button type="button" disabled class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/ComprarCuponera?cuponera=<%=varDTCuponera.getNombre()%>'">
									Comprado
								</button>
								<%}%>
							</div>
						</div>
					</div>
				</div>
				<div id="user-inferior" class="row card-body mb-3">
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Descripción:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%= varDTCuponera.getDescripcion() %>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Período de validez:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%= varDTCuponera.getFechaInicio().toFecha() %> -
							<%= varDTCuponera.getFechaFin().toFecha() %>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Precio:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							$ <%= varDTCuponera.getCosto() %>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Descuento aplicado:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%= varDTCuponera.getDescuento() %>%
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Fecha de registro:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%= varDTCuponera.getFechaAlta().toFecha() %>
						</div>
					</div>
				</div>
			</div>

			<!--<div class="col-sm-3 ps-1 ps-sm-3">
				<div id="user-consultaInscriptos" class="extraInfoDiv row">
					<h5>Actividades Deportivas</h5>
					<ul id="listaInscriptos" class="py-3">
						<% List<DtClasesCuponera> acts = varDTCuponera.getContenido();
                   for (DtClasesCuponera x :acts){ %>
						<li class="container border card-body elementoLista">
							<img alt="Imagen de la Actividad" src="<%=request.getContextPath()%>/api/content?c=act&id=<%=x.getNombreActividad()%>" class="vertical-align-middle imagenSeleccionable">
							<a class="clase color-blue" href="<%=request.getContextPath()%>/actividades?actividad=<%= x.getNombreActividad()%>">
								<%= x.getNombreActividad() %> /
								<%=x.getCantidadClases() %>
								<%if (x.getCantidadClases()>1){ %> clases
								<%}else{ %> clase
								<%} %>
							</a>
						</li>
						<% } %>
					</ul>
				</div>
				<div id="user-consultaInscriptos" class="extraInfoDiv row">
					<h5>Categorías</h5>
					<ul id="listaInscriptos" class="py-3">
						<% List<String> cats = varDTCuponera.getCategorias();
            		for (String x :cats){  %>
						<li class="container border card-body elementoLista">
							<a class="clase color-blue"
								href="<%=request.getContextPath()%>/search?actividades=yes&cuponeras=yes&fltrC1=<%=x%>">
								<%=x%>
							</a>
						</li>
						<%  } %>
					</ul>
				</div>
			</div> -->
		</div>
	</div>
	<jsp:include page="./../templates/footer.jsp" />
</body>

</html>