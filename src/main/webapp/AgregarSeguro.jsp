<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Entidad.TipoSeguro" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Seguros</title>
</head>
<body>

    <div style="margin-bottom: 20px;">
        <a href="InicioServlet">Inicio</a> | 
        <a href="AgregarSeguroServlet">Agregar seguros</a> | 
        <a href="ListarSegurosServlet">Listar seguros</a>
    </div>

    <h2>Agregar Seguros</h2>

    <form action="AgregarSeguroServlet" method="post">
        
        <table>
            <tr>
                <td><label>Id Seguro:</label></td>
                
                <td><input type="text" name="idSeguro" value="${nextId}" readonly /></td>
            </tr>
            <tr>
                <td><label>Descripción:</label></td>
                <td><input type="text" name="descripcion" required /></td>
            </tr>
            <tr>
                <td><label>Tipo de Seguro:</label></td>
                <td>
                    <select name="idTipo">
                        <%
                            
                            List<TipoSeguro> tipos = (List<TipoSeguro>) request.getAttribute("tipos");
                            if (tipos != null) {
                                
                                for (TipoSeguro tipo : tipos) {
                        %>
                                    <option value="<%= tipo.getIdTipo() %>"><%= tipo.getDescripcion() %></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Costo contratación:</label></td>
                <td><input type="number" step="0.01" name="costoContratacion" required /></td>
            </tr>
            <tr>
                <td><label>Costo Máximo Asegurado:</label></td>
                <td><input type="number" step="0.01" name="costoAsegurado" required /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Aceptar" /></td>
            </tr>
        </table>
        
    </form>

</body>
</html>