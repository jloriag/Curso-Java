/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author estudiante
 */
@WebService(serviceName = "ConsultaClientes")
public class ConsultaClientes {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "consultaXCedula")
    public String consultaXCedula(@WebParam(name = "name") String cedula) {
        
//        Aqui se va a realizar las consultas correspondientes a la Base de datos o al lugar que se necesite
//                Se maneja la infotmacion para dar un resultado/respuesta
        
        return "Hello " + cedula + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public int suma(@WebParam(name = "numero1") int numero1, @WebParam(name = "numero2") int numero2) {
        //TODO write your implementation code here:
        return numero1+numero2;
    }
}
