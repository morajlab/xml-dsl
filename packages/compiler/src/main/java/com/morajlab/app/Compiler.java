package com.morajlab.app;

import com.morajlab.app.models.Function;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class Compiler {
    public static void main(String[] args) {
        JAXBContext jaxbContext = null;

        try {
            jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
                    .createContext(new Class[] {Function.class}, null);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // change XML encoding
            //jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");

            // remove <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
            //jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            //jaxbMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", false);

            // add custom xml headers
            //jaxbMarshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

            //jaxbMarshaller.marshal(createCompanyObject(), new File("C:\\test\\company.xml"));

            jaxbMarshaller.marshal(createCompanyObject(), System.out);

            // XML Unmarshalling
            /*File file = new File("C:\\test\\company.xml");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Company o = (Company) jaxbUnmarshaller.unmarshal(file);
            System.out.println(o);*/

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    private static Function createCompanyObject() {

        Function comp = new Function();
        comp.setArguments("My Arguments");
        comp.setPublic(true);

        return comp;
    }
}
