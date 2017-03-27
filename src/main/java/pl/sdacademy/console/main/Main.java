package pl.sdacademy.console.main;

import com.sun.xml.internal.bind.v2.util.XmlFactory;
import pl.sdacademy.model.Bill;
import pl.sdacademy.model.BillItem;
import pl.sdacademy.model.User;
import pl.sdacademy.pdf.PdfFactory;
import pl.sdacademy.service.DataService;
import pl.sdacademy.service.UserService;
import pl.sdacademy.xml.XMLFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        login(scanner);
//
////        DataService dataService = new DataService();
////
//////        zapisujemy od razu do stworzonego pliku
////
////        User user = new User();
////        XMLFactory xf = new XMLFactory();
////        String xmlUser = xf.objectToXML(user);
////        dataService.saveData(xmlUser);
//
//    }
//
////        metoda pobierajaca z konsoli
//
//    private static void login(Scanner scanner) {
//
////        sprawdzenie poprawnosci loginu i hasla - nowa klasa UserService
//
//        UserService userService = new UserService();
//
//        boolean isLogin = false;
//        while (!isLogin) {
//            System.out.println("Login: ");
//            String login = scanner.nextLine();
//
//            System.out.println("Password: ");
//            String password = scanner.nextLine();
//
//            User user = new User(login, password);
//
//            isLogin = userService.authenticate(user);
//
//            if (isLogin) {
//                System.out.println("You are log in");
//            } else {
//                System.out.println("Wrong password");
//            }
//
//        }
//
//        //        DataService dataService = new DataService("C:\\Users\\Miki\\Desktop\\data\\data2.dat");

        DataService dataService = new DataService();

//        login();

//        initFile();

//        User userFromFile = dataService.loadData();

//        PdfFactory pdfFactory = new PdfFactory();

//        pdfFactory.createPdf();

        Bill bill = new Bill();

        XMLFactory<Bill> xmlFactory = new XMLFactory<>(Bill.class);

        String xbill = xmlFactory.objectToXML(bill);
        System.out.println(xbill);

    }

//        dataService.saveData(xbill);
//
//    Bill bill2 = dataService.loadBillData();
//
//        System.out.println("asd");

    private static List<BillItem> listInit() {

        List<BillItem> billitemList = new ArrayList<>();

        BillItem paczek = new BillItem();

        paczek.setItemName("Paczek");

        paczek.setAmount(1);

        paczek.setPrice(2.70);

        paczek.setDescription("Pączek z marmoladą");

        paczek.setTax(0.08);

        paczek.setCode("72235");

        billitemList.add(paczek);

        BillItem herbata = new BillItem();

        herbata.setItemName("Herbata");

        herbata.setAmount(1);

        herbata.setPrice(1.70);

        herbata.setDescription("Malinowa");

        herbata.setTax(0.22);

        herbata.setCode("62435");

        billitemList.add(herbata);

        BillItem ciachoZeSzpinakiem = new BillItem();

        ciachoZeSzpinakiem.setItemName("Ciastko ze szpinakiem");

        ciachoZeSzpinakiem.setAmount(1);

        ciachoZeSzpinakiem.setPrice(3.70);

        ciachoZeSzpinakiem.setDescription("Ciasto francuskie nadziewane szpinakiem");

        ciachoZeSzpinakiem.setTax(0.08);

        ciachoZeSzpinakiem.setCode("623445");

        billitemList.add(ciachoZeSzpinakiem);

        BillItem kawa = new BillItem();

        kawa.setItemName("Kawa");

        kawa.setAmount(1);

        kawa.setPrice(5.0);

        kawa.setDescription("Swiezo mielona kawa JAVA prosto z plantacji");

        kawa.setTax(0.22);

        kawa.setCode("97034567");

        billitemList.add(kawa);

        return billitemList;

    }


//        DataService dataService = new DataService("C:\\Users\\Miki\\Desktop\\data\\data2.dat");

            DataService dataService = new DataService();

//        login();

//        initFile();

//        User userFromFile = dataService.loadData();

            PdfFactory pdfFactory = new PdfFactory();

//        pdfFactory.createPdf();

            Bill bill = new Bill();

            List<BillItem> billItems = listInit();

            bill.addItem(billItems.get(1),3);

            bill.addItem(billItems.get(2),3);

//        bill.removeItem(billItems.get(2),1000);

            for(String e:dataService.printBillInfo(bill))

            {

                System.out.println(e);

            }

            pdfFactory.createPdfBill(bill);

            System.out.println("Ostatnia linia kodu");

        }

}


