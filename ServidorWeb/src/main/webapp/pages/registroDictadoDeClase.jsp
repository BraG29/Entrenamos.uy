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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	<title>Entrenamos.UY</title>
</head>

<body>
	<jsp:include page="./../templates/headerCommon.jsp" />
	<main>
	<div class="container-fluid mt-4">
		<%  DtClaseExt datosClase = (DtClase) request.getAttribute("clase");
			String nombreActividad = (String) request.getAttribute("actividad");
			String nombreInstitucion = (String) request.getAttribute("institucion");
			boolean esSocio = (boolean) request.getAttribute("esSocio");
			boolean estaInscripto = (boolean) request.getAttribute("estaInscripto");
			boolean estaCaducada = (boolean) request.getAttribute("estaCaducada");
			boolean estaLlena = (boolean) request.getAttribute("estaLlena");
			%>
		<div class="row mx-3 mx-md-5">
			<div id="user-general" class="col-sm-7">
				<div id="user-superior" class="row ">
					<div class="col-3 py-3">
						<div id="mainImgDiv">
							<img alt="imagenClase" id="mainImgDiv" src="<%=request.getContextPath()%>/api/content?c=cla&id=<%=datosClase.getNombre()%>">
						</div>
					</div>
					<div class="col-9 py-3">
						<div id="user-info" class="row">
							<p>
								<strong id="user-nickname"> <%=datosClase.getNombre()%> </strong>
								<a id="user-type" href="<%=request.getContextPath()%>/actividades?actividad=<%=nombreActividad%>">
									(<%=nombreActividad%>)
								</a>
							</p>
						</div>
						<div id="creatorDiv" class="row">
							<div class="col-auto">
								<h4><strong>Dictada por:</strong></h4>
							</div>
							<div class="col-auto">
								<img alt="Qries" src="<%=request.getContextPath()%>/api/content?c=usu&id=<%=datosClase.getNicknameProfesor()%>" class="vertical-align-middle imagenSeleccionable">
							</div>
							<div class="col-auto">
								<a class="clase color-blue" href="<%=request.getContextPath()%>/usuarios?nickname=<%=datosClase.getNicknameProfesor()%>">
									<%=datosClase.getNicknameProfesor()%>
								</a>
							</div>
								<button id="botonInsc" type="button" class="w-100 mb-2 btn btn-lg rounded-4 btn-primary" type="submit">
									Inscribirse
								</button>
							</div>
						</div>
					</div>
				</div>
				<div id="user-inferior" class="row card-body mb-3">
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Fecha y Hora de Inicio:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%=datosClase.getFechaClase().toFechaHora()%>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Cupos minimos:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%=datosClase.getMinSocios()%> socios.
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Cupos maximos:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%=datosClase.getMaxSocios()%> socios.
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>URL:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%=datosClase.getURL()%>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<h6 class="mb-0"><strong>Fecha de registro:</strong></h6>
						</div>
						<div class="col-sm-9 text-secondary">
							<%=datosClase.getFechaRegistro().toFecha()%>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3 ps-1 ps-sm-3">
				<div id="user-consultaInscriptos" class="extraInfoDiv row">
					<%  List<String> nickAlumnos = datosClase.getNickAlumnos();%>
					<h5>Usuarios Inscriptos (
						<%=nickAlumnos.size()%>)
					</h5>
					<ul id="listaInscriptos" class="py-3">
						<%  for (String alumno : nickAlumnos) { %>
						<li class="container border card-body elementoLista">
							<img alt="Default"
								src="<%=request.getContextPath()%>/api/content?c=usu&id=<%=alumno%>"
								class="vertical-align-middle imagenSeleccionable">
							<a class="clase color-blue"
								href="<%=request.getContextPath()%>/usuarios?nickname=<%=alumno%>">
								<%=alumno%>
							</a>
						</li>
						<%  } %>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</main>
	<jsp:include page="./../templates/footer.jsp" />
</body>

</html>