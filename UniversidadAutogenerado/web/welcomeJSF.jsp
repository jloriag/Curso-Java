<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%--
    This file is an entry point for JavaServer Faces application.
--%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="JavaServer Faces"/></h1>
            <h:form>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>C&eacute;dula</td>
                            <td><h:inputText id="txtCedula" value="#{profesorbean.elprofe.cedulaprofe}"/></td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td><h:inputText id="txtNombre" value="#{profesorbean.elprofe.nombre}"/></td>
                        </tr>
                        <tr>
                            <td>A&ntilde;os de Experiencia</td>
                            <td><h:inputText id="txtAnnos" value="#{profesorbean.elprofe.annosexperiencia}"/></td>
                        </tr>
                        <tr>
                            <td>Correo</td>
                            <td><h:inputText id="txtCorreo" value="#{profesorbean.elprofe.correo}"/></td>
                        </tr>
                    </tbody>
                </table>
                            <h:commandButton id="btnAgregar" value="Agregar" action="#{profesorbean.agregar()}"/>
            </h:form>
        </body>
    </html>
</f:view>
