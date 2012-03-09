package name.felixbecker.jaxbissuetracker;

import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import name.felixbecker.jaxbissuetracker.xml.ConcreteType;
import name.felixbecker.jaxbissuetracker.xml.HijackedType;
import name.felixbecker.jaxbissuetracker.xml.ObjectFactory;

public class Main {
	
	public static void main(String... args) throws Exception{
		new Main().marshallConcreteType();
	}
	
	public void marshallConcreteType() throws Exception {
			
			StringWriter stringWriter = new StringWriter();
	
			// schema for validation
	
			JAXBContext context = JAXBContext.newInstance(ConcreteType.class);
			Marshaller m = context.createMarshaller();
			
			// Validation
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(getClass().getResource("concrete.xsd"));
			m.setSchema(schema);
	
			// pretty printing
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			ConcreteType concreteType = new ConcreteType();
			HijackedType hijackedType = new HijackedType();
			hijackedType.setValue("foobar");
			concreteType.setHijacked(hijackedType);
			concreteType.getSomething().add("something");
			
			JAXBElement<ConcreteType> elem = new ObjectFactory().createConcreteType(concreteType);
			
			m.marshal(elem, stringWriter);
			
			System.out.println(stringWriter.toString());
		}

}
