package pl.sdacademy.service;

import com.sun.xml.internal.bind.v2.util.XmlFactory;
import org.apache.commons.io.FileUtils;
import pl.sdacademy.model.*;
import pl.sdacademy.xml.XMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataService {

    private File file;

    public DataService() {
        this.file = new File("C:\\Users\\RENT\\Desktop\\data\\data.dat");
    }

    public void saveData(String xmlString) {

//        FileUtils to klasa statyczna biblioteki
//        touch - pusty plik
        try {
            FileUtils.touch(file);

            //        stringa zapisujemy do pliku za pomoca FileUtils.WriteStringToFile

            FileUtils.writeStringToFile(file, xmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public User loadData() {

//        pobrac usera z pliku data.dat
//        przerobic stringaXML na Usera

        User user = null;
        XMLFactory<User> xmlFactory = new XMLFactory<User>(User.class);
        String xml;
        try {
            xml = FileUtils.readFileToString(file, "UTF-8");
            user = xmlFactory.xmlToObject(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<String> printCompanyInfo(Company company) {
        List<String> result = new ArrayList<>();
        result.add(company.getName());
        result.add(company.getAddress().toString());

//        gdyby nip byl int'em to trzeba by: String.valueOf(company.getNip())

        result.add(company.getNip());
//        result.add(company.getRegon());

        return result;
    }

//    przy voidzie nic nie zwracamy

    public void printOutCompanyInfo(Company company) {

//        zwraca liste stringow

        List<String> listInfo = printCompanyInfo(company);
        for (String line : listInfo) {
            System.out.println(line);
        }
    }

//    properties - obiekt tego typu

    public static Properties loadProperties() {
        Properties result = new Properties();

//        dane statystyczne dla programu, wiec powolujemy InputStream i pobieramy streem'a

        InputStream inputStream;

//        trzeba wpisac nazwe klasy, bo to metoda statyczna
//        classLoader mechanizm odpowiadajacy za polozenie klas, dzieki temu mamy dostep do resources
//        tworzymy data.properties w resources ze sciezka do pulpitu

        inputStream = DataService.class.getClassLoader().getResourceAsStream("data.properties");

//        wczytyjemy do result naszego inputStream'a
//        za catch robimy blok finally

        try {
            result.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

//            zamykamy inputStream'a

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public String loadBillData() {

        Bill bill = null;

        XMLFactory<Bill> xmlFactory = new XMLFactory<Bill>(Bill.class);

        try {

            String xml = FileUtils.readFileToString(file);

            bill = xmlFactory.xmlToObject(xml);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return xmlFactory.objectToXML(bill);

    }
    public List<String> printBillInfo(Bill bill)

    {

        List<String> result = new ArrayList();

        DecimalFormat df = new DecimalFormat("#.##");

//        result.add(bill.getId().toString());

        result.add(bill.getDate().toString());

        result.add("___________________________________");

        for(BillItem e : bill.getListOfItems())

        {

            result.add(e.getAmount()+" x "+ e.getItemName() + " "

                    + df.format(e.getPrice())+" zl = "+" "+

                    df.format(e.getAmount()*e.getPrice()) + " zl");

        }

        result.add("___________________________________");

        result.add("\t Cena: \t" + df.format(bill.getPrice()).toString());

        result.add("Zapłacono:\t"+ bill.getPayment().toString());

        return result;

    }
}

