package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vouchers")
public class Voucher extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="voucher_id")
    private Long id;

    @Column
    private Timestamp startedAt;

    @Column
    private Timestamp willExpireAt;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Long discountAmount;

    @Column
    private Boolean status;

    @Column
    private String type;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users usersCreateVouchers;

    @ManyToMany(mappedBy = "vouchers")
    private List<Orders> order;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_voucher",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id",
                    referencedColumnName = "voucher_id"))
    private List<Users> usersHasVouchers;
}
