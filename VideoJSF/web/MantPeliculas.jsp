<%-- 
    Document   : MantPeliculas
    Created on : 03-feb-2018, 11:37:02
    Author     : Estudiante
--%>

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
                <h1><h:outputText value="Mantenimiento de Peliculas"/></h1>
                <table>
                    <tr>
                        <td><h:outputText value="Código"/></td>
                        <td>
                            <h:inputText id="txtCodigo" value="#{peliculaBean.laPelicula.codigo}"/>
                            <h:message for="txtCodigo" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Nombre"/></td>
                        <td>
                            <h:inputText id="txtNombre" value="#{peliculaBean.laPelicula.nombre}"/>
                            <h:message for="txtNombre" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Productora"/></td>
                        <td>
                            <h:inputText id="txtProductora" value="#{peliculaBean.laPelicula.productora}"/>
                            <h:message for="txtProductora" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Tipo"/></td>
                        <td>
                            <h:selectOneMenu id="cbTipo" value="#{peliculaBean.laPelicula.tipo}">
                                <f:selectItems value="#{peliculaBean.llenaTipo()}"/>
                            </h:selectOneMenu>
                            <h:message for="cbtipo" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Taquillera"/></td>
                        <td>
                            <h:selectOneRadio id="cbTaquillera" value="#{peliculaBean.laPelicula.taquillera}">
                                <f:selectItems value="#{peliculaBean.llenaTaquillera()}"/>
                            </h:selectOneRadio>
                            <h:message for="cbtipo" style="color:red;"/>
                         </td>
                    </tr>
                </table>
                <h:commandButton id="btnAgregar" value="Agregar" action="#{peliculaBean.agregar()}"/>
                <h:messages globalOnly="true" style="color:green;"/>
            </h:form>
        </body>
    </html>
</f:view>
