package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phonenumbers")
public class PhoneNumber implements Serializable {
    public PhoneNumber(String telNumber,String mobNumber,Address address){
        this.telNumber=telNumber;
        this.mobNumber=mobNumber;
        this.address=address;
    }
    public PhoneNumber(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(name = "telNumber")
    private String telNumber;
    @Column(name = "mobNumber")
    private String mobNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", address=" + address +
                ", telNumber='" + telNumber + '\'' +
                ", mobNumber='" + mobNumber + '\'' +
                '}';
    }
}
