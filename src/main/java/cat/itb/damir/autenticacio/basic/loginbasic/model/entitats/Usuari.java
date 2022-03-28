package cat.itb.damir.autenticacio.basic.loginbasic.model.entitats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@RequiredArgsConstructor
public class Usuari implements UserDetails {
    @Id
    @GeneratedValue
    private Long id; //identificador autonumèric
    @Column(unique = true)
    private String username; //no es repeteix username
    private String password;
    private String avatar;
    private String rol = "USER"; //per defecte

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        //l'altre rol seria "ROLE_ADMIN", per exemple
        return roles;
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
