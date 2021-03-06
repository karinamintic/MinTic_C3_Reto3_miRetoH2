
package com.usa.Servicios;

import com.usa.Modelo.Skate;
import com.usa.Repositorio.SkateRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosSkate {
    
    @Autowired
    private SkateRepositorio metodosCrud;
    
    public List<Skate> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Skate> getSkate(int id){
        return metodosCrud.getSkate(id);
    }
    
    public Skate save(Skate skate){
        if(skate.getId()==null){
            return metodosCrud.save(skate);
        }else{
            Optional<Skate> evt=metodosCrud.getSkate(skate.getId());
            if(evt.isEmpty()){
               return metodosCrud.save(skate);
            }else{
                return skate;
            }
        }
    }
}
