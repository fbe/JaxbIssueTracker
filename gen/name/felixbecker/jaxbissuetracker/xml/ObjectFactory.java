//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.09 at 03:26:55 AM CET 
//


package name.felixbecker.jaxbissuetracker.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the name.felixbecker.jaxbissuetracker.xml package. 
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

    private final static QName _ConcreteType_QNAME = new QName("http://www.felixbecker.name/concrete", "concreteType");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: name.felixbecker.jaxbissuetracker.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConcreteType }
     * 
     */
    public ConcreteType createConcreteType() {
        return new ConcreteType();
    }

    /**
     * Create an instance of {@link HijackedType }
     * 
     */
    public HijackedType createHijackedType() {
        return new HijackedType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcreteType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.felixbecker.name/concrete", name = "concreteType")
    public JAXBElement<ConcreteType> createConcreteType(ConcreteType value) {
        return new JAXBElement<ConcreteType>(_ConcreteType_QNAME, ConcreteType.class, null, value);
    }

}
