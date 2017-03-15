package pl.sdacademy.service;

import org.apache.commons.io.FileUtils;
import pl.sdacademy.model.Company;
import pl.sdacademy.model.User;
import pl.sdacademy.xml.XMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
