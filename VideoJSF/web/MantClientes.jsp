

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
                <h1><h:outputText value="Mantenimiento de Clientes"/></h1>
                <table>
                    <tr>
                        <td><h:outputText value="Cedula"/></td>
                        <td>
                            <h:inputText id="txtCedula" disabled="#{!clienteBean.agregando}" value="#{clienteBean.elCliente.cedula}"/>
                            <h:message for="txtCedula" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Nombre"/></td>
                        <td>
                            <h:inputText id="txtNombre" value="#{clienteBean.elCliente.nombre}"/>
                            <h:message for="txtNombre" style="color:red;"/>
                         </td>
                    </tr>
                  
                    <tr>
                        <td><h:outputText value="Telefono"/></td>
                        <td>
                            <h:inputText id="txtTelefono" value="#{clienteBean.elCliente.telefono}"/>
                            <h:message for="txtTelefono" style="color:red;"/>
                         </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Direccion"/></td>
                        <td>
                            <h:inputTextarea id="txtDireccion" value="#{clienteBean.elCliente.direccion}"/>
                            <h:message for="txtDireccion" style="color:red;"/>
                         </td>
                    </tr>
                    
                    <tr>
                        <td><h:outputText value="Monto Pagado"/></td>
                        <td>
                            <h:inputText id="txtMontoPagado" value="#{clienteBean.elCliente.montoPagado}"/>
                            <h:message for="txtDireccion" style="color:red;"/>
                         </td>
                    </tr>
                </table>
                <h:commandButton id="btnAgregar" value="Agregar" action="#{clienteBean.agregar()}"/>
                <h:commandButton rendered="#{!clienteBean.agregando}" id="btnModificar" value="Modificar" action="#{clienteBean.modificar()}"/>
                <h:commandButton id="btnLimpiar" value="Limpiar" action="#{clienteBean.limpiar()}"/>
                <h:commandButton id="btnRegresar" value="Regresar" action="#{clienteBean.regresar()}"/>
                <h:commandButton id="btnConsXCodigo" value="Consulta X Codigo" action="#{clienteBean.consXCedula()}"/>
                <h:commandButton id="btnConsXNombre" value="Consulta X Nombre" action="#{clienteBean.consXNombre()}"/>
                <h:messages globalOnly="true" style="color:green;"/>
                <h:dataTable id="tableClientes" styleClass="table" value="#{clienteBean.listaClientes}" binding="#{clienteBean.tableClientes}" var="client" border="1">
                    <h:column id="col1">
                        <f:facet name="header">
                            <h:outputText value="Cedula" />
                        </f:facet>
                        <h:outputText value="#{client.cedula}"/>
                    </h:column>
                    <h:column id="col2">
                        <f:facet name="header">
                            <h:outputText value="Nombre" />
                        </f:facet>
                        <h:outputText value="#{client.nombre}"/>
                    </h:column>
                    <h:column id="col3">
                        <f:facet name="header">
                            <h:outputText value="Telefono" />
                        </f:facet>
                        <h:outputText value="#{client.telefono}"/>
                    </h:column>
                    <h:column id="col4">
                        <f:facet name="header">
                            <h:outputText value="Direccion" />
                        </f:facet>
                        <h:outputText value="#{client.direccion}"/>
                    </h:column>
                    
                    <h:column id="col5">
                        <f:facet name="header">
                            <h:outputText value="Monto Pagado" />
                        </f:facet>
                        <h:outputText value="#{client.montoPagado}"/>
                    </h:column>
                    
               <h:column id="col6">
                        <f:facet name="header">
                            <h:outputText value="Seleccionar"/>
                        </f:facet>
                   <h:commandLink action="#{clienteBean.seleccionar()}">                                
                            <h:graphicImage url="img/modificar.png"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                    
                    
                    <h:column id="col7">
                        <f:facet name="header">
                            <h:outputText value="Eliminar"/>
                        </f:facet>
                        <h:commandLink onclick="return confirm('Esta seguro de eliminar el cliente?')" action="#{clienteBean.eliminar()}">                                
                            <h:graphicImage url="img/eliminar.gif"></h:graphicImage>
                        </h:commandLink>
                    </h:column>
                </h:dataTable>
            </h:form>
        </body>
    </html>
</f:view>
