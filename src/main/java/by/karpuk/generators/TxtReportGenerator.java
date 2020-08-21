package by.karpuk.generators;

import by.karpuk.settings.Settings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtReportGenerator implements ReportGenerator {

    private static final String NEW_LINE = "\r\n";

    private Settings settings;
    private List<String[]> inputData;
    private List<String> result = new ArrayList<>();

    @Override
    public void generate() {
        PageGenerator pageGenerator = new PageGenerator(settings);
        result = pageGenerator.generate(inputData);

        try (Writer out = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(new File("report.txt")), "UTF-16"))) {

            for (String line : result) {
                out.append(line).append(NEW_LINE);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setInputData(List<String[]> inputData) {
        this.inputData = inputData;
    }

    public List<String[]> getInputData() {
        return inputData;
    }
}