

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h:form id="form1">
                <h1><h:outputText value="Mantenimiento de Actores"/></h1>
                <table>
                    <tr>
                        <td><h:outputText value="Codigo Actor"/></td>
                        <td>
                            <h:inputText id="txtCodigo" value="#{actorBean.elActor.codigoActor}"/>
                            <h:message for="txtCodigo" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Nombre"/></td>
                        <td>
                            <h:inputText id="txtNombre" value="#{actorBean.elActor.nombre}"/>
                            <h:message for="txtNombre" style="color:red;"/>
                         </td>
                    </tr>
                  
                    <tr>
                        <td><h:outputText value="Nacionalidad"/></td>
                        <td>
                            <h:inputText id="txtNacionalidad" value="#{actorBean.elActor.nacionalidad}"/>
                            <h:message for="txtNacionalidad" style="color:red;"/>
                         </td>
                    </tr>
                 
                </table>
                <h:commandButton id="btnAgregar" value="Agregar" action="#{actorBean.agregar()}"/>
                <h:messages globalOnly="true" style="color:green;"/>
            </h:form>
        </body>
    </html>
</f:view>
