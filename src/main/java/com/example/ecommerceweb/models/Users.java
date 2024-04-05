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
@Builder
@Table(name = "users")
public class Users extends Base implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer user_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar",referencedColumnName = "id")
    private ImageData Avatar;


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

    @Column(length=100, nullable = false)
    private String address;

    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "created_by", cascade = CascadeType.ALL)
    private Collection<Books> books_created;

    @OneToMany(mappedBy = "updated_by", cascade = CascadeType.ALL)
    private Collection<Books> books_updated;

    @OneToMany(mappedBy = "user_create", cascade = CascadeType.ALL)
    private Collection<Bill> bill_list;


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
