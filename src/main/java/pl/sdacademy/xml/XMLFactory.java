package pl.sdacademy.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by RENT on 2017-03-13.
 */
public class XMLFactory<T> {

//    ? pytajnik - nie rozrozniamy typow

    private Class<T> type;

    public XMLFactory() {
    }

    public XMLFactory(Class<T> type) {
        this.type = type;
    }

//    zamiana obiektu do xml'a
//    metody generyczne - uniwersalne dla innych obiektow
//    serializacja deserializacja do xml'a
//    T - typ generyczny nie trzeba tworzyc tyle fabryk ile jest obiektow
//    T - okreslony typ - konkretny obiekt do ktorego mozna sie odwolac

    public T xmlToObject(String xml) {

        T object = null;

//        jaxv cotext - klasa sluzaca do serializacji w xml

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(type);
            XMLInputFactory xif = XMLInputFactory.newInstance();

            StringReader stringReader = new StringReader(xml);

            XMLStreamReader xsr = xif.createXMLStreamReader(stringReader);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            object = (T) unmarshaller.unmarshal(xsr);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    public String objectToXML(T object) {
        String result = null;

//        maszyna do robienie xml'i

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(type);

            Marshaller m = jaxbContext.createMarshaller();

            StringWriter stringWriter = new StringWriter();

//        stringWriter to odpowiedz/result
//        obiekt/user przy uzyciu fiunkcji marshall zamienia sie w xml

            m.marshal(object, stringWriter);
            result = stringWriter.toString();
            return result;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

//        serializacja Marshaller, deserializajca unmarshaller

        return result;
    }


}
