package by.karpuk.generators;

public class ReportGeneratorFactory {

    public static ReportGenerator getReportGenerator(String extension) {
        if (extension == null) {
            return null;
        } else if (extension.equals("txt")) {
            return new TxtReportGenerator();
        }
        return null;
    }
}