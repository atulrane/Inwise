package com.inwise.pojo;

import javax.persistence.*;
import javax.annotation.Generated;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ashay
 * Date: May 11, 2012
 * Time: 9:44:18 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "customer_order_no", unique = true,length = 20)
    private String customerOrderNo;

    @Column(name = "consignee_name", length = 50)
    private String consigneeName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "amendment_date")
    private Date amendmentDate;

    @Column(name = "amendment_no",length = 10)
    private String amendmentNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderDetail> orderDetail=new ArrayList<OrderDetail>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerOrderNo() {
        return customerOrderNo;
    }

    public void setCustomerOrderNo(String customerOrderNo) {
        this.customerOrderNo = customerOrderNo;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public Date getAmendmentDate() {
        return amendmentDate;
    }

    public void setAmendmentDate(Date amendmentDate) {
        this.amendmentDate = amendmentDate;
    }

    public String getAmendmentNo() {
        return amendmentNo;
    }

    public void setAmendmentNo(String amendmentNo) {
        this.amendmentNo = amendmentNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", customerOrderNo='" + customerOrderNo + '\'' +
                ", consigneeName='" + consigneeName + '\'' +
                ", amendmentDate=" + amendmentDate +
                ", amendmentNo='" + amendmentNo + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
