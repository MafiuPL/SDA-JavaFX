package pl.sdacademy.model;

/**
 * Created by RENT on 2017-03-18.
 */

import java.util.ArrayList;
import java.util.List;

    public class BillItemService {

        private List<BillItem> billitemList;

        public List<BillItem> createList(){

            List<BillItem> billItemList=new ArrayList<>();

            BillItem paczek= new BillItem();

            paczek.setItemName("Paczek");

            paczek.setAmount(1);

            paczek.setPrice(2.70);

            paczek.setDescription("Pączek z marmoladą");

            paczek.setTax(0.08);

            paczek.setCode("72235");

            billItemList.add(paczek);

            BillItem herbata= new BillItem();

            herbata.setItemName("Herbata");

            herbata.setAmount(1);

            herbata.setPrice(1.70);

            herbata.setDescription("Malinowa");

            herbata.setTax(0.22);

            herbata.setCode("62435");

            billItemList.add(herbata);

            BillItem ciachoZeSzpinakiem= new BillItem();

            ciachoZeSzpinakiem.setItemName("Ciastko ze szpinakiem");

            ciachoZeSzpinakiem.setAmount(1);

            ciachoZeSzpinakiem.setPrice(3.70);

            ciachoZeSzpinakiem.setDescription("Ciasto francuskie nadziewane szpinakiem");

            ciachoZeSzpinakiem.setTax(0.08);

            ciachoZeSzpinakiem.setCode("623445");

            billItemList.add(ciachoZeSzpinakiem);

            BillItem kawa = new BillItem();

            kawa.setItemName("Kawa");

            kawa.setAmount(1);

            kawa.setPrice(5.0);

            kawa.setDescription("Swiezo mielona kawa JAVA prosto z plantacji");

            kawa.setTax(0.22);

            kawa.setCode("97034567");

            billItemList.add(kawa);

            return billItemList;

        }

    }

