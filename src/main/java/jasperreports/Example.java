package jasperreports;

import gibb.db.Postgres;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRSaver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-10, 14:21
 */
public class Example {

    private static String directory = "src/resources/";
    private static String reportName = "MyReport";


    public static void main(String[] args) throws JRException, SQLException {

        System.out.println("My first Report...");

        // Compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(
                directory + reportName + ".jrxml");

        // To avoid compiling it every time, we can save it to a file
        JRSaver.saveObject(jasperReport, directory + reportName + ".jasper");

        
        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("username", "Beat");

        // DataSource
        Connection connection = Postgres.getConnection();

        System.out.println("Connection established...");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters, connection);

        System.out.println("Write PDF...");
        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                directory + reportName + ".pdf");

        System.out.println("Done!");
    }
}
