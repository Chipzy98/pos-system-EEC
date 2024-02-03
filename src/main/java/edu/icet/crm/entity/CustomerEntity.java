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
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "contact_number")
    private String contactNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<OrdersEntity> orders;

    public CustomerEntity(String customerId, String customerName, String emailAddress, String contactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
    }
}
