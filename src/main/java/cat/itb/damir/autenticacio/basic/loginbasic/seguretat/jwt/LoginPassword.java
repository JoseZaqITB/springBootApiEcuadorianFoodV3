package cat.itb.damir.autenticacio.basic.loginbasic.seguretat.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginPassword {

    private String username;
    private String password;
}
