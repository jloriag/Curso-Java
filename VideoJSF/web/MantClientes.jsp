

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
                            <h:inputText id="txtCedula" value="#{clienteBean.elCliente.cedula}"/>
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
                <h:messages globalOnly="true" style="color:green;"/>
            </h:form>
        </body>
    </html>
</f:view>
