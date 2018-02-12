

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
                            <h:inputText id="txtCodigo" disabled="#{!actorBean.agregando}" value="#{actorBean.elActor.codigoActor}"/>
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
                <h:commandButton rendered="#{!actorBean.agregando}" id="btnModificar" value="Modificar" action="#{actorBean.modificar()}"/>
                <h:commandButton id="btnLimpiar" value="Limpiar" action="#{actorBean.limpiar()}"/>
                <h:commandButton id="btnRegresar" value="Regresar" action="#{actorBean.regresar()}"/>
                <h:commandButton id="btnConsXCodigo" value="Consulta X Codigo" action="#{actorBean.consXCodigo()}"/>
                <h:commandButton id="btnConsXNombre" value="Consulta X Nombre" action="#{actorBean.consXNombre()}"/>
                <h:messages globalOnly="true" style="color:green;"/>
                <h:dataTable id="tableActores" styleClass="table" value="#{actorBean.listaActores}" binding="#{actorBean.tableActores}" var="act" border="1">
                    <h:column id="col1">
                        <f:facet name="header">
                            <h:outputText value="Codigo" />
                        </f:facet>
                        <h:outputText value="#{act.codigoActor}"/>
                    </h:column>
                      
                    <h:column id="col2">
                        <f:facet name="header">
                            <h:outputText value="Nombre" />
                        </f:facet>
                        <h:outputText value="#{act.nombre}"/>
                    </h:column>
                    
                    <h:column id="col3">
                        <f:facet name="header">
                            <h:outputText value="Nacionalidad" />
                        </f:facet>
                        <h:outputText value="#{act.nacionalidad}"/>
                    </h:column>
                    
                    <h:column id="col4">
                        <f:facet name="header">
                            <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <h:commandLink action="#{actorBean.seleccionar()}">                                
                            <h:graphicImage url="img/modificar.png"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                    
                    <h:column id="col5">
                        <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                        </f:facet>
                        <h:commandLink onclick="return confirm('Esta seguro de eliminar el actor?')" action="#{actorBean.eliminar()}">                                
                            <h:graphicImage url="img/eliminar.gif"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                    
                </h:dataTable>
            </h:form>
        </body>
    </html>
</f:view>
