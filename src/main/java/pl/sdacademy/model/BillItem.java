package pl.sdacademy.model;

/**
 * Created by RENT on 2017-03-18.
 */
public class BillItem {

    private Integer amount;

    private String itemName;

    private double price;

    private double tax;

    private String description;

    private String code;

    public BillItem() {

    }

    public Integer getAmount() {

        return amount;

    }

    public void setAmount(Integer amount) {

        this.amount = amount;

    }

    public String getItemName() {

        return itemName;

    }

    public void setItemName(String itemName) {

        this.itemName = itemName;

    }

    public double getPrice() {

        return price;

    }

    public void setPrice(double price) {

        this.price = price;

    }

    public double getTax() {

        return tax;

    }

    public void setTax(double tax) {

        this.tax = tax;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public String getCode() {

        return code;

    }

    public void setCode(String code) {

        this.code = code;

    }

    @Override

    public String toString() {

        return "BillItem{" +

                "amount=" + amount +

                ", itemName='" + itemName + '\'' +

                ", price=" + price +

                ", tax=" + tax +

                ", description='" + description + '\'' +

                ", code='" + code + '\'' +

                '}';

    }

}

