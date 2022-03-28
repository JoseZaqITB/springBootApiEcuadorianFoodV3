package cat.itb.damir.autenticacio.basic.loginbasic.controladors;

import cat.itb.damir.autenticacio.basic.loginbasic.model.entitats.Food;
import cat.itb.damir.autenticacio.basic.loginbasic.model.serveis.ServeiFood;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/* CRUD Foods *******************************
- 1) llistar tots els food
- 2) Afegir food
- 3) Consultar un Food per long id
- 4) Modificar Food
- 5) Eliminar Food per long id
 ***********************************************/


@RestController
@RequiredArgsConstructor
public class ControladorFoods {
    private final ServeiFood serveiFoods;

    @GetMapping("/food")
    public ResponseEntity<?> consultarFoods() {
        List<Food> res = serveiFoods.llistarFoods();
        if (res != null) return ResponseEntity.ok(res);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/food")
    public ResponseEntity<?> afegirFood(@RequestBody Food v) {
        try {
            serveiFoods.afegirFood(v);
            return new ResponseEntity<Food>(v, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @GetMapping("/food/{id}")
    public ResponseEntity<?> consultarUnFood(@PathVariable long id) {
        Food v = serveiFoods.consultarPerId(id);
        if (v != null) {
            return ResponseEntity.ok(v);
        } else return ResponseEntity.notFound().build();
    }

    @PutMapping("/food")
    public ResponseEntity<?> modificarFood(@RequestBody Food vmod){
        Food res=serveiFoods.modificarFood(vmod);
        if(res!=null) return ResponseEntity.ok(res);
        else return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/food/{id}")
    public ResponseEntity<?> eliminarFood(@PathVariable long id){
        Food res=serveiFoods.eliminarFood(id);
        if(res!=null){
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }

}
