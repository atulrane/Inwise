package com.inwise.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Atul
 * Date: May 10, 2012
 * Time: 12:08:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "contact_person",length = 50)
    private String contactPerson;

    @Column(name = "department",length = 50)
    private String department;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "tin_no",length = 50)
    private String tinNo;

    @Column(name = "ecc_no",length = 50)
    private String eccNo;

    @Column(name = "customer_code",length = 10,nullable = true)
    private String customerCode;

    @Column(name = "contact_no1",length = 10)
    private Integer contactNo1;

    @Column(name = "contact_no2",length = 10)
    private Integer contactNo2;

    @Column(name = "deleted")
    private Integer deleted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_has_address",
        joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id")
    )
    private List<Address> addresslst=new ArrayList<Address>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getEccNo() {
        return eccNo;
    }

    public void setEccNo(String eccNo) {
        this.eccNo = eccNo;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(Integer contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public Integer getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(Integer contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public List<Address> getAddresslst() {
        return addresslst;
    }

    public void setAddresslst(List<Address> addresslst) {
        this.addresslst = addresslst;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", tinNo='" + tinNo + '\'' +
                ", eccNo='" + eccNo + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", contactNo1=" + contactNo1 +
                ", contactNo2=" + contactNo2 +
                ", deleted=" + deleted +
                ", addresslst=" + addresslst +
                '}';
    }
}
