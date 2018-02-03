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
            <h1><h:outputText value="Hello Word"/></h1>
            <h:form>
            <table border="1">
                <tbody>
                    <tr>
                        <td> <h:outputText value="Nombre" />  </td>
                        <td> 
                            <h:inputText id="txtNombre" value="#{elEjemploBean.elEstudiante.nombre}"/> 
                            <h:message for="txtNombre" style="color:red" />
                        </td>
                    </tr>
                    <tr>
                        <td><h:outputText value="Cedula" /> </td>
                        <td>
                            <h:inputText id="txtCedula" value="#{elEjemploBean.elEstudiante.cedula}" />
                            <h:message for="txtCedula" style="color:red" />
                        </td>
                    </tr>
                    <tr>
                        <td> <h:outputText value="Carrera" />  </td>
                        <td> 
                            <h:inputText id="txtCarrera" value="#{elEjemploBean.elEstudiante.carrera}"/> 
                            <h:message for="txtCarrera" style="color:red" />
                        </td>
                    </tr>
                    <tr>
                        <td> <h:outputText value="Carnet" />  </td>
                        <td> 
                            <h:inputText id="txtCarnet" value="#{elEjemploBean.elEstudiante.carnet}"/> 
                            <h:message for="txtCarnet" style="color:red" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <h:commandButton id="btnAgregar" value="Agregar" action="#{elEjemploBean.agregar()}"/>
            </h:form>
        </body>
    </html>
</f:view>
