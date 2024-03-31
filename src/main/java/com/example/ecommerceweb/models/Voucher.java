package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

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
    private Integer id;

    @Column
    private String voucherCode;

    @Column
    private String name;

    @Column
    private String Description;

    @Column
    private Integer discountAmount;

    @Column
    private boolean isDelete;

    @Column
    private boolean isDisplay;

    @Column
    private Integer maxUses;

    @Column
    private Integer uses;

    @Column
    private Integer type;

    @Column
    private Date starts_at;

    @Column
    private Date  expires_at;
}
