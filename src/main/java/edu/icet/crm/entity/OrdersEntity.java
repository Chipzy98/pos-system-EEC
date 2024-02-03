package edu.icet.crm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "order_date")
    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column(name = "note")
    private String note;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "total")
    private Double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<ItemsEntity> items;

    public OrdersEntity(String orderId, String orderDate, String note,String orderStatus) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.note = note;
        this.orderStatus=orderStatus;
    }

    public OrdersEntity(String orderId, String orderStatus, Double total) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.total = total;
    }
}
