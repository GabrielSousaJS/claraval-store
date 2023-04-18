package com.gabrielsantos.backend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter @Setter
    private Instant birthDate;

    @Column(unique = true)
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    @Getter @Setter
    private Address address;

    @OneToMany(mappedBy = "client")
    @Getter
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_privilege",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    @Getter
    private Set<Privilege> privileges = new HashSet<>();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public User() {
    }

    public User(Long id, String name, Instant birthDate, String email, String password) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public boolean hasPrivilege(String privilegeName) {
        for (Privilege privilege : privileges) {
            if (privilege.getAuthority().equals(privilegeName)) {
                return true;
            }
        }

        return false;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return privileges.stream().map(privilege -> new SimpleGrantedAuthority(privilege.getAuthority())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
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
