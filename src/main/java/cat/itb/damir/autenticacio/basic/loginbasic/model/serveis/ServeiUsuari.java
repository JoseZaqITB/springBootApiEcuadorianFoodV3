package cat.itb.damir.autenticacio.basic.loginbasic.model.serveis;


import cat.itb.damir.autenticacio.basic.loginbasic.model.entitats.Usuari;
import cat.itb.damir.autenticacio.basic.loginbasic.model.repositoris.RepositoriUsuari;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiUsuari {

    private final RepositoriUsuari repositoriUsuari;

    private final PasswordEncoder xifrat;

    public Usuari consultarPerUsername(String username) {
        return repositoriUsuari.findByUsername(username).orElse(null);
    }

    public Usuari crearNouUsuari(Usuari nouUsuari) {
        //falta controlar que els 2 passwords del client coincideixen
        //passar un UsuariCreacioDTO
        nouUsuari.setPassword(xifrat.encode(nouUsuari.getPassword()));
        repositoriUsuari.save(nouUsuari);
        return nouUsuari;
    }

    public List<Usuari> llistarUsuaris(){
        return repositoriUsuari.findAll();
    }

    public Usuari consultarPerId(Long id){
        return repositoriUsuari.findById(id).orElse(null);
    }

}


