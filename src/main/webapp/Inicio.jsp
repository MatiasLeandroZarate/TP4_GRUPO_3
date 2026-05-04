<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, Entidad.TipoSeguro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tp4 Grupo 3</title>
</head>
<body>

<nav>
    <a href="InicioServlet">Inicio</a>
    <a href="AgregarSeguroServlet?AgregarSeguro=1">Agregar seguros</a>
    <a href="listarSeguros">Listar seguros</a>
</nav>

<h1>Soy la página inicio</h1>

<h2>Categorías de seguros</h2>
<ul>
<%
    List listaCategorias = (List) request.getAttribute("listaCategorias");
    if (listaCategorias != null && !listaCategorias.isEmpty()) {
        for (Object obj : listaCategorias) {
            TipoSeguro ts = (TipoSeguro) obj;
%>
    <li><%= ts.getIdTipo() %> - <%= ts.getDescripcion() %></li>
<%
        }
    } else {
%>
    <li>No hay categorías disponibles.</li>
<%
    }
%>
</ul>

</body>
</html>
