package com.example.ecommerceweb.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bills")
public class Bill extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer id ;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id",nullable = true)
    private Users user_create;

    @OneToMany(mappedBy = "bill_list", cascade = CascadeType.ALL)
    private Collection<Books> books_bill;

    @Column
    private Integer totalBill;

    @Column
    private boolean isStatus;

    @Column
    private boolean idDeliver;
}
