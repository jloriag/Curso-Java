
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultaXCedula_QNAME = new QName("http://webservice/", "consultaXCedula");
    private final static QName _ConsultaXCedulaResponse_QNAME = new QName("http://webservice/", "consultaXCedulaResponse");
    private final static QName _Hello_QNAME = new QName("http://webservice/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservice/", "helloResponse");
    private final static QName _Suma_QNAME = new QName("http://webservice/", "suma");
    private final static QName _SumaResponse_QNAME = new QName("http://webservice/", "sumaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaXCedula }
     * 
     */
    public ConsultaXCedula createConsultaXCedula() {
        return new ConsultaXCedula();
    }

    /**
     * Create an instance of {@link ConsultaXCedulaResponse }
     * 
     */
    public ConsultaXCedulaResponse createConsultaXCedulaResponse() {
        return new ConsultaXCedulaResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Suma }
     * 
     */
    public Suma createSuma() {
        return new Suma();
    }

    /**
     * Create an instance of {@link SumaResponse }
     * 
     */
    public SumaResponse createSumaResponse() {
        return new SumaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaXCedula }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "consultaXCedula")
    public JAXBElement<ConsultaXCedula> createConsultaXCedula(ConsultaXCedula value) {
        return new JAXBElement<ConsultaXCedula>(_ConsultaXCedula_QNAME, ConsultaXCedula.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaXCedulaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "consultaXCedulaResponse")
    public JAXBElement<ConsultaXCedulaResponse> createConsultaXCedulaResponse(ConsultaXCedulaResponse value) {
        return new JAXBElement<ConsultaXCedulaResponse>(_ConsultaXCedulaResponse_QNAME, ConsultaXCedulaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suma }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "suma")
    public JAXBElement<Suma> createSuma(Suma value) {
        return new JAXBElement<Suma>(_Suma_QNAME, Suma.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "sumaResponse")
    public JAXBElement<SumaResponse> createSumaResponse(SumaResponse value) {
        return new JAXBElement<SumaResponse>(_SumaResponse_QNAME, SumaResponse.class, null, value);
    }

}
