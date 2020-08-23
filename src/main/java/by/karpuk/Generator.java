package by.karpuk;

import by.karpuk.generators.ReportGeneratorFactory;
import by.karpuk.generators.TxtReportGenerator;
import by.karpuk.parsers.ParserFactory;
import by.karpuk.parsers.TsvParser;
import by.karpuk.parsers.XmlParser;

public class Generator {

    public static void main(String[] args) {

        XmlParser xmlParser = (XmlParser) ParserFactory.getParser("xml");
        xmlParser.parse("settings.xml");

        TsvParser tsvParser = (TsvParser) ParserFactory.getParser("tsv");
        tsvParser.parse("source-data.tsv");

        TxtReportGenerator txtReportGenerator = (TxtReportGenerator) ReportGeneratorFactory.getReportGenerator("txt");
        txtReportGenerator.setSettings(xmlParser.getParsedSettings());
        txtReportGenerator.setInputData(tsvParser.getTsvParserResult());
        txtReportGenerator.generate();
    }
}