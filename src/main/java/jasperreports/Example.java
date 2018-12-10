package jasperreports;

import gibb.db.Postgres;
import net.sf.jasperreports.engine.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-10, 14:21
 */
public class Example {

    public static void main(String[] args) throws JRException, SQLException {

        System.out.println("My first Report...");

        // Compile jrxml file.
        JasperReport report = JasperCompileManager.compileReport(
                "src/main/resources/MyReport.jrxml");

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        Connection connection = Postgres.getConnection();
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(report,
                parameters, connection);

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "src/main/resources/MyReport.pdf");

        System.out.println("Done!");
    }
}
