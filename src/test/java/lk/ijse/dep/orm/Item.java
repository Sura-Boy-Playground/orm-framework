package lk.ijse.dep.orm;

import lk.ijse.dep.orm.annotation.Column;
import lk.ijse.dep.orm.annotation.Entity;
import lk.ijse.dep.orm.annotation.Id;

import java.math.BigDecimal;

@Entity
public class Item {

    @Id
    @Column
    private String code;
    @Column
    private String description;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "qty_on_hand")
    private int qtyOnHand;

    public Item() {
    }

    public Item(String code, String description, BigDecimal unitPrice, int qtyOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
