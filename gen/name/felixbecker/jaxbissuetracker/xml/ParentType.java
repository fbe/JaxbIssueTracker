//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.09 at 02:22:45 AM CET 
//


package name.felixbecker.jaxbissuetracker.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hijacked" type="{http://www.felixbecker.name/hijacked}hijackedType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parentType", namespace = "http://www.felixbecker.name/parent", propOrder = {
    "hijacked"
})
@XmlSeeAlso({
    ConcreteType.class
})
public abstract class ParentType {

    @XmlElement(required = true)
    protected HijackedType hijacked;

    /**
     * Gets the value of the hijacked property.
     * 
     * @return
     *     possible object is
     *     {@link HijackedType }
     *     
     */
    public HijackedType getHijacked() {
        return hijacked;
    }

    /**
     * Sets the value of the hijacked property.
     * 
     * @param value
     *     allowed object is
     *     {@link HijackedType }
     *     
     */
    public void setHijacked(HijackedType value) {
        this.hijacked = value;
    }

}
