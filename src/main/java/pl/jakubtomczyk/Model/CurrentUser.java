package pl.jakubtomczyk.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final pl.jakubtomczyk.entity.User user;

    public CurrentUser(
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            pl.jakubtomczyk.entity.User user
    ) {
        super(username, password, authorities);
        this.user = user;
    }

    public pl.jakubtomczyk.entity.User getUser() {
        return user;
    }
}