package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users extends Base implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="avatar")
    private String avatar;

    @Column(length=50, nullable = false)
    private String fullName;

    @Column(length=50, nullable = false)
    private String username;

    @Column(length = 300, nullable = false)
    private String password;

    @Column(length =50, nullable = false)
    private String email;

    @Column(name="status")
    private boolean status;

    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "created_by", cascade = CascadeType.ALL)
    private Collection<Books> booksCreated;

    @OneToMany(mappedBy = "updated_by", cascade = CascadeType.ALL)
    private Collection<Books> booksUpdated;

    @OneToMany(mappedBy = "user_create", cascade = CascadeType.ALL)
    private Collection<Orders> orderList;

    @OneToMany(mappedBy = "usersCart")
    private List<Carts> carts;

    @OneToMany(mappedBy = "userAddress")
    private List<Address> addresses;

    // relationship that users created vouchers
    @OneToMany(mappedBy = "usersCreateVouchers")
    private List<Voucher> vouchersCreated;

    // relationship that users has their own vouchers
    @ManyToMany(mappedBy = "usersHasVouchers")
    private List<Voucher> vouchersOwner;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
