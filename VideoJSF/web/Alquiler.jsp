

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
                <h1><h:outputText value="Alquiler de Peliculas"/></h1>
                <table>
                    <tr>
                        <td><h:outputText value="Pelicula"/></td>
                        <td>
                            <h:selectOneMenu id="cbPelicula" value="#{alquilerBean.elAlquiler.codigo}">
                                <f:selectItems value="#{alquilerBean.llenaPelicula()}"/>
                            </h:selectOneMenu>
                            <h:message for="cbPelicula" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Cliente"/></td>
                        <td>
                            <h:selectOneMenu id="cbCliente" value="#{alquilerBean.elAlquiler.cedula}">
                                <f:selectItems value="#{alquilerBean.llenaCliente()}"/>
                            </h:selectOneMenu>
                            <h:message for="cbCliente" style="color:red;"/>
                         </td>
                    </tr>
                  
                    <tr>
                        <td><h:outputText value="Monto"/></td>
                        <td>
                            <h:inputText id="txtMonto" value="#{alquilerBean.elAlquiler.monto}"/>
                            <h:message for="txtMonto" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Dias"/></td>
                        <td>
                            <h:inputText id="txtDias" value="#{alquilerBean.elAlquiler.dias}"/>
                            <h:message for="txtDias" style="color:red;"/>
                         </td>
                    </tr>
                    
                    <tr>
                        <td><h:outputText value="Monto Pagado"/></td>
                        <td>
                            <h:inputText id="txtMontoPagado" value="#{alquilerBean.elAlquiler.monto}"/>
                            <h:message for="txtDireccion" style="color:red;"/>
                         </td>
                    </tr>
                </table>
               <h:commandButton id="btnAgregar" value="Agregar" action="#{alquilerBean.agregar()}"/>
                <h:commandButton rendered="#{!alquilerBean.agregando}" id="btnModificar" value="Modificar" action="#{alquilerBean.modificar()}"/>
                <h:commandButton id="btnLimpiar" value="Limpiar" action="#{alquilerBean.limpiar()}"/>
                <h:messages globalOnly="true" style="color:green;"/>
                <h:dataTable id="tableActores" styleClass="table" value="#{alquilerBean.listaAlquileres}" binding="#{alquilerBean.tableAlquileres}" var="alqui" border="1">
                    <h:column id="col1">
                        <f:facet name="header">
                            <h:outputText value="Pelicula" />
                        </f:facet>
                        <h:outputText value="#{alqui.codigo}"/>
                    </h:column>
                      
                    <h:column id="col2">
                        <f:facet name="header">
                            <h:outputText value="Cliente" />
                        </f:facet>
                        <h:outputText value="#{alqui.cedula}"/>
                    </h:column>
                    
                    <h:column id="col3">
                        <f:facet name="header">
                            <h:outputText value="Fecha" />
                        </f:facet>
                        <h:outputText value="#{alqui.fecha}"/>
                    </h:column>
                    
                    <h:column id="col4">
                        <f:facet name="header">
                            <h:outputText value="Monto" />
                        </f:facet>
                        <h:outputText value="#{alqui.monto}"/>
                    </h:column>
                    
                    <h:column id="col5">
                        <f:facet name="header">
                            <h:outputText value="Dias" />
                        </f:facet>
                        <h:outputText value="#{alqui.dias}"/>
                    </h:column>
                    
                    <h:column id="col6">
                        <f:facet name="header">
                            <h:outputText value="Seleccionar"/>
                        </f:facet>
                        <h:commandLink action="#{alquilerBean.seleccionar()}">                                
                            <h:graphicImage url="img/modificar.png"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                    
                    <h:column id="col7">
                        <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                        </f:facet>
                        <h:commandLink onclick="return confirm('Esta seguro de eliminar el alquiler?')" action="#{alquilerBean.eliminar()}">                                
                            <h:graphicImage url="img/eliminar.gif"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                    
                </h:dataTable>
            </h:form>
        </body>
    </html>
</f:view>
