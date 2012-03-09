package name.felixbecker.jaxbissuetracker;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import name.felixbecker.jaxbissuetracker.xml.ConcreteType;
import name.felixbecker.jaxbissuetracker.xml.HijackedType;
import name.felixbecker.jaxbissuetracker.xml.ObjectFactory;

public class Main {
	
	public static void main(String... args) throws Exception {
		final Main main = new Main();
		String xml = main.marshallConcreteType();
		System.out.println("XML: " + xml);
		main.unmarshallConcreteType(xml);
	}
	
	public ConcreteType unmarshallConcreteType(String xml) throws Exception {
		JAXBContext context = JAXBContext.newInstance(ConcreteType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader stringReader = new StringReader(xml);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(getClass().getResource("concrete.xsd"));
		unmarshaller.setSchema(schema);
		ConcreteType concreteType = (ConcreteType) unmarshaller.unmarshal(stringReader);
		return concreteType;

	}
	
	public String marshallConcreteType() throws Exception {
			
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
			
			JAXBElement<ConcreteType> elem = new ObjectFactory().createConcreteType(concreteType);
			
			m.marshal(elem, stringWriter);
						
			return stringWriter.toString();
	}

}
