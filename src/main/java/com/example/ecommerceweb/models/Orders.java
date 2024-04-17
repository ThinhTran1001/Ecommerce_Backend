package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = true)
    private Users userCreate;

    @Column(nullable = false)
    private Timestamp orderDateStart;

    @Column(nullable = false)
    private Timestamp orderDateEnd;

    @Column(nullable = false)
    private Integer totalQuantity;

    @Column(nullable = false)
    private Long totalAmount;

    @Column
    private Status status;

    @Column
    private Long deliverInfoId;

    @Column
    private Boolean isCancelled;

    @Column(nullable = false)
    private String PaymentMethod;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_voucher",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id",
                    referencedColumnName = "voucher_id"))
    private List<Voucher> vouchers;

    @OneToMany(mappedBy = "orders")
    private List<BookOrder> ordersBookList;
}
