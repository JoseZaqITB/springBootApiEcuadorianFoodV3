package cat.itb.damir.autenticacio.basic.loginbasic.config;

import cat.itb.damir.autenticacio.basic.loginbasic.model.entitats.Food;
import cat.itb.damir.autenticacio.basic.loginbasic.model.entitats.Usuari;
import cat.itb.damir.autenticacio.basic.loginbasic.model.repositoris.RepositoriUsuari;
import cat.itb.damir.autenticacio.basic.loginbasic.model.repositoris.RepositoriFood;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * CLASE USADA SOLO PARA INICIALIZAR DATOS BASICOS EN LA BASE DE DATOS
 * USARLA CUANDO SE QUIERE TENER VALORES POR DEFAULT DE LA API
 * DESCOMENTAR @SERVICE PARA EJECUTARLO
 */
//@Service
public class DBInit implements CommandLineRunner {
    private PasswordEncoder encoderConfig;
    private RepositoriUsuari repositoriUsuaris;
    private RepositoriFood repositoriFoods;

    public DBInit(PasswordEncoder encoderConfig, RepositoriUsuari repositori, RepositoriFood repositoriFood) {
        this.encoderConfig = encoderConfig;
        this.repositoriUsuaris = repositori;
        this.repositoriFoods = repositoriFood;
    }


    @Override
    public void run(String... args) throws Exception {
        // delete db
        repositoriUsuaris.deleteAll();
        repositoriFoods.deleteAll();
        // create basic users
        Usuari admin = new Usuari();
        admin.setRol("ADMIN");
        admin.setUsername("admin");
        admin.setPassword(encoderConfig.encode("1234"));
        admin.setRol("ADMIN");

        Usuari user = new Usuari();
        user.setUsername("user");
        user.setPassword(encoderConfig.encode("1234"));

        // create basic ecaudorian foods
        Food encebollado = new Food();
        encebollado.setNom("Encebollado");
        encebollado.setDescripcio("Sopa con ingredientes principales el pescado y el tomate ");
        encebollado.setPreu(6.0);
        encebollado.setPuntuacio(10);

        Food encocado = new Food();
        encocado.setNom("Encocado");
        encocado.setDescripcio("Plato de arroz con carne/marisco sumergidas en una salsa hecha con coco");
        encocado.setPreu(12.0);
        encocado.setPuntuacio(9);
        //save to db
        List<Usuari> usuariList = Arrays.asList(user, admin);
        List<Food> foods = Arrays.asList(encebollado, encocado);
        repositoriUsuaris.saveAll(usuariList);
        repositoriFoods.saveAll(foods);
    }
}
