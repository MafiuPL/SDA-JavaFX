package pl.sdacademy.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import pl.sdacademy.model.Bill;
import pl.sdacademy.model.Company;
import pl.sdacademy.service.DataService;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.List;

public class PdfFactory {

    public void createPdf() {

//        ustalamy, gdzie umieszczamy pdf'a
//        loadProperties to metoda statyczna, wiec nie musimy powolywac obiektu do zycia
//        kazda metoda statyczna jest zapisywana bezposrednio do pamieci - nie zaleca sie naduzywania statycznych metod

        Properties properties = DataService.loadProperties();

        String pdfPath = properties.getProperty("pdfPath");

//        przy tworzeniu pdf tworzymy dokument pdf

        Document document = new Document();

//        pobieramy instancje, aby moc wypelnic dokument
//        FileSeparator domyslny separator


        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "file.pdf"));

//            aby dodac cos do pliku
//            paragraph element uzywany w pdfie

            document.open();
            document.add(new Paragraph("Hello SDAcademy!"));

//            po edycji zamykamy

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        po tym utworzy sie pusty plik, aby dodac cos do pliku patrz linia 40/41

    }

    //            proba zapisu do PDF z SceneBuilder



    public void createPdfFromSceneBuilder(Company company) {

//        przyjmuje argument company

        DataService dataService = new DataService();
        List<String> companyInfos = dataService.printCompanyInfo(company);

        Properties properties = DataService.loadProperties();

        String pdfPath = properties.getProperty("pdfPath");

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "file.pdf"));
            document.setPageSize(new Rectangle(180, 240));

            document.open();

            for (String e : companyInfos) {
                document.add(new Paragraph(e));
            }

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void createPdfBill (Bill bill)

    {

        DataService dataService = new DataService();

        List<String> companyInfoList = dataService.printBillInfo(bill);

        Properties properties = DataService.loadProperties();

        String pdfPath = properties.getProperty("pdfPath");

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream(pdfPath + File.separator + "bill.pdf"));

            Font font = new Font(Font.TIMES_ROMAN, 8.0f, Font.NORMAL, Color.black);

            document.setPageSize(new Rectangle(200,300));

            document.setMargins(15,15,15,15);

            document.open();

            for(String e:companyInfoList)

                document.add(new Paragraph(e,font));

            document.close();

        } catch (DocumentException e) {

            e.printStackTrace();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }

}
