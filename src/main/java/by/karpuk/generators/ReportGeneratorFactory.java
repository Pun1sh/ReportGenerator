package by.karpuk.generators;

public class ReportGeneratorFactory {

    public static ReportGenerator getReportGenerator(String extension) {
        if (extension.equals("txt")) {
            return new TxtReportGenerator();
        } else {
            throw new RuntimeException("No generator with extension " + extension);
        }
    }
}