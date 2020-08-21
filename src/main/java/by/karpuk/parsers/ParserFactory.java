package by.karpuk.parsers;

public class ParserFactory {

    public static Parser getParser(String extension) {
        if (extension.equals("tsv")) {
            return new TsvParser();
        } else if (extension.equals("xml")) {
            return new XmlParser();
        } else {
            throw new RuntimeException("No parser with extension " + extension);
        }
    }
}