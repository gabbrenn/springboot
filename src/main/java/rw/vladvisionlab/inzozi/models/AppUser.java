package rw.vladvisionlab.inzozi.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    // These methods are required by UserDetails:

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // For now: No roles or permissions
    }

    @Override
    public String getUsername() {
        return email; // use email as username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // account is always valid
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // credentials never expire
    }

    @Override
    public boolean isEnabled() {
        return true; // account is always enabled
    }
}