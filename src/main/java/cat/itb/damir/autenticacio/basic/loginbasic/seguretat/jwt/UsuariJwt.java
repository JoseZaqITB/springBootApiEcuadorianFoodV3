package cat.itb.damir.autenticacio.basic.loginbasic.seguretat.jwt;

import cat.itb.damir.autenticacio.basic.loginbasic.model.entitats.UsuariConsultaDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@NoArgsConstructor
@Getter
@Setter
public class UsuariJwt extends UsuariConsultaDTO {
    private String token;

    @Builder(builderMethodName = "jwtUsuariJwtBuilder")
    public UsuariJwt(String username, String avatar, String rol, String token) {
        super(username, avatar, rol);
        this.token = token;
    }
}
