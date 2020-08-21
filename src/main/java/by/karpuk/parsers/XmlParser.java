package by.karpuk.parsers;

import by.karpuk.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlParser implements Parser {

    private Settings parsedSettings;

    @Override
    public void parse(String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
            XMLStreamReader xss = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(fileName));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            xss.nextTag();
            parsedSettings = (Settings) unmarshaller.unmarshal(xss);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Settings not found");
        }
    }

    public Settings getParsedSettings() {
        return parsedSettings;
    }

    public void setParsedSettings(Settings parsedSettings) {
        this.parsedSettings = parsedSettings;
    }
}