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
                            <h:inputText id="txtCodigo" disabled="#{!peliculaBean.agregando}" value="#{peliculaBean.laPelicula.codigo}"/>
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
                <h:commandButton rendered="#{peliculaBean.agregando}" id="btnAgregar" value="Agregar" action="#{peliculaBean.agregar()}"/>
                <h:commandButton rendered="#{!peliculaBean.agregando}" id="btnModificar" value="Modificar" action="#{peliculaBean.modificar()}"/>
                <h:commandButton id="btnLimpiar" value="Limpiar" action="#{peliculaBean.limpiar()}"/>
                <h:commandButton id="btnRegresar" value="Regresar" action="#{peliculaBean.regresar()}"/>
                <h:commandButton id="btnConsXCodigo" value="Consulta X Codigo" action="#{peliculaBean.consXCodigo()}"/>
                <h:commandButton id="btnConsXNombre" value="Consulta X Nombre" action="#{peliculaBean.consXNombre()}"/>
                <h:messages globalOnly="true" style="color:green;"/>
                <h:dataTable  id="tablePeliculas" styleClass="table" value="#{peliculaBean.listaPeliculas}" binding="#{peliculaBean.tablePeliculas}" var="peli" border="1">
                    <h:column id="col1">
                        <f:facet name="header">
                            <h:outputText value="Codigo" />
                        </f:facet>
                        <h:outputText value="#{peli.codigo}"/>
                    </h:column>
                    <h:column id="col2">
                        <f:facet name="header">
                            <h:outputText value="Codigo" />
                        </f:facet>
                        <h:outputText value="#{peli.nombre}"/>
                    </h:column>
                    <h:column id="col3">
                        <f:facet name="header">
                            <h:outputText value="Productora" />
                        </f:facet>
                        <h:outputText value="#{peli.productora}"/>
                    </h:column>
                    <h:column id="col4">
                        <f:facet name="header">
                            <h:outputText value="Tipo" />
                        </f:facet>
                        <h:panelGroup rendered="#{peli.tipo==1}">
                            <h:outputText value="Accion"/>
                        </h:panelGroup>

                        <h:panelGroup rendered="#{peli.tipo==2}">
                            <h:outputText value="Comedia"/>
                        </h:panelGroup>

                        <h:panelGroup rendered="#{peli.tipo==3}">
                            <h:outputText value="Suspenso"/>
                        </h:panelGroup>

                        <h:panelGroup rendered="#{peli.tipo==4}">
                            <h:outputText value="Romantica"/>
                        </h:panelGroup>

                    </h:column>

                    <h:column id="col5">
                        <f:facet name="header">
                            <h:outputText value="Taquillera" />
                        </f:facet>
                        <h:panelGroup rendered="#{peli.taquillera==1}">
                            <h:outputText value="SI"/>
                        </h:panelGroup>
                        <h:panelGroup rendered="#{peli.taquillera==2}">
                            <h:outputText value="NO"/>
                        </h:panelGroup>

                    </h:column>

                    <h:column id="col6">
                        <f:facet name="header">
                            <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <h:commandLink action="#{peliculaBean.seleccionar()}">                                
                            <h:graphicImage url="img/modificar.png"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                    
                    <h:column id="col7">
                        <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                        </f:facet>
                        <h:commandLink onclick="return confirm('Esta seguro de eliminar la pelicula?')" action="#{peliculaBean.eliminar()}">                                
                            <h:graphicImage url="img/eliminar.gif"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                </h:dataTable>
            </h:form>
        </body>
    </html>
</f:view>
