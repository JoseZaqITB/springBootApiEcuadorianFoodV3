package cat.itb.damir.autenticacio.basic.loginbasic.model.entitats;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariConsultaDTO {
    private String username;
    private String avatar;
    private String rol;
}
