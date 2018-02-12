<%-- 
    Document   : Alquileres
    Created on : 10-feb-2018, 12:21:30
    Author     : Josue
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
            <h:form>
            <h1><h:outputText value="Alquiler de Pelicula!"/></h1>
            
            <table border="1">
               
                <tbody>
                    <tr>
                        <td><h:outputText value="Pelicula" /></td>
                        <td>
                            <h:selectOneMenu id="cbPelicula" value="#{alquilerBean.elAlquiler.codigo}">
                                <f:selectItems value="#{peliculaBean.llenaPeliculas()}" />
                            </h:selectOneMenu>
                        </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Cliente" /></td>
                        <td>
                            <h:selectOneMenu id="cbCliente" value="#{alquilerBean.elAlquiler.cedula}">
                                
                            </h:selectOneMenu>
                        </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Monto" /></td>
                        <td>
                            <h:outputText id="txtMonto" value="#{alquilerBean.elAlquiler.monto}" />
                        </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Dias" /></td>
                        <td>
                            <h:outputText  id="txtDias" value="#{alquilerBean.elAlquiler.dias}" />
                        </td>
                    </tr>
                </tbody>
            </table>

            </h:form>
        </body>
    </html>
</f:view>
