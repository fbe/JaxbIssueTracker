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

import name.felixbecker.concrete.ConcreteType;
import name.felixbecker.concrete.ObjectFactory;
import name.felixbecker.hijacked.HijackedType;

import org.junit.Test;

public class MarshallingTest {
	
	@Test
	public void testMarshalling() throws Exception {
		String xml = marshallConcreteType();
		System.out.println("XML: " + xml);
	}
	
	@Test
	public void testUnmarshalling() throws Exception {
		unmarshallConcreteType(marshallConcreteType());
	}
	

	public ConcreteType unmarshallConcreteType(String xml) throws Exception {
		JAXBContext context = JAXBContext.newInstance(ConcreteType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		StringReader stringReader = new StringReader(xml);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(getClass().getResource("/concrete.xsd"));
		unmarshaller.setSchema(schema);
		ConcreteType concreteType = (ConcreteType) unmarshaller.unmarshal(stringReader);
		return concreteType;

	}
	
	public String marshallConcreteType() throws Exception {
				
			JAXBContext context = JAXBContext.newInstance(ConcreteType.class);
			Marshaller m = context.createMarshaller();
			
			// Validation
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(getClass().getResource("/concrete.xsd"));
			m.setSchema(schema);
	
			// pretty printing
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// write marshalled xml to stringwriter
			StringWriter stringWriter = new StringWriter();
			m.marshal(getConcreteType(), stringWriter);
			return stringWriter.toString();
	}
	
	private JAXBElement<ConcreteType> getConcreteType(){
		ConcreteType concreteType = new ConcreteType();
		HijackedType hijackedType = new HijackedType();
		hijackedType.setValue("foobar");
		concreteType.setHijacked(hijackedType);
		
		return new ObjectFactory().createConcreteType(concreteType);
	}

}
