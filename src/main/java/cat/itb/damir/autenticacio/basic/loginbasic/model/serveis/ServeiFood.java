package cat.itb.damir.autenticacio.basic.loginbasic.model.serveis;

import cat.itb.damir.autenticacio.basic.loginbasic.model.entitats.Food;
import cat.itb.damir.autenticacio.basic.loginbasic.model.repositoris.RepositoriFood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiFood {
    private final RepositoriFood repoFoods;

    public List<Food> llistarFoods(){
        return repoFoods.findAll();
    }

    public Food consultarPerId(Long id){
        return repoFoods.findById(id).orElse(null);
    }

    public Food eliminarFood(Long id){
        Food res=repoFoods.findById(id).orElse(null);
        if(res!=null) repoFoods.deleteById(id);
        return res;
    }

    public Food afegirFood(Food v){
        return repoFoods.save(v);
    }

    /** si existeix el videojoc el modifica (el torna a gravar), altrament retorna null*/
    public Food modificarFood(Food v){
        Food res=null;
        if(repoFoods.existsById(v.getId())) res=repoFoods.save(v);
        return res;
    }


}
