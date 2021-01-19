package lk.ijse.dep.orm;

import lk.ijse.dep.orm.annotation.Column;
import lk.ijse.dep.orm.annotation.Entity;
import lk.ijse.dep.orm.annotation.Id;

@Entity
public class Customer {
    @Column
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    private String telephone;

    public Customer() {
    }

    public Customer(int id, String name, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
