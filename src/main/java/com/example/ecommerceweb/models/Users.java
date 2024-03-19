package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
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
    private Integer user_id;

    @Column(name="avatar")
    private String Avatar;

    @Column(length=50, nullable = false)
    private String fullName;

    @Column(length=50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length =50, nullable = false)
    private String email;

    @Column(name="status")
    private boolean status;

    @Column(length=100, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Roles role_id;

    @OneToMany(mappedBy = "created_by", cascade = CascadeType.ALL)

    private Collection<Books> books_created;

    @OneToMany(mappedBy = "updated_by", cascade = CascadeType.ALL)
    private Collection<Books> books_updated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role_id.getRole_name()));
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
