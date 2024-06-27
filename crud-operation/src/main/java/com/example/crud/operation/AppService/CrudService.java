package com.example.crud.operation.AppService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.operation.AppEntity.UserData;
import com.example.crud.operation.AppRepository.CrudRepository;

@Service
public class CrudService {

    @Autowired
    CrudRepository repository;

    public UserData saveUser(UserData data){
        return repository.save(data);
    }

    public List<UserData> getUserByName(String name) {
        return repository.findByName(name);
    }

    public boolean updateuser(String name, UserData entity) {
        List<UserData> users = repository.findByName(name);
        if (users.isEmpty()) {
            return false;
        }
        UserData user = users.get(0);

        if(entity.getName()!=null){
            user.setName(entity.getName());

        }
        if(entity.getMobile()!=null){
            user.setMobile(entity.getMobile());

        }
        if(entity.getEmail()!=null){
            user.setEmail(entity.getEmail());

        }
        if(entity.getAddress()!=null){
            user.setAddress(entity.getAddress());

        }
        if(entity.getVehiclemodel()!=null){
            user.setVehiclemodel(entity.getVehiclemodel());

        }
        if(entity.getVehiclenumber()!=null){
            user.setVehiclenumber(entity.getVehiclenumber());

        }
        if(entity.getVehicletype()!=null){
            user.setVehicletype(entity.getVehicletype());

        }
        repository.save(user);
        return true;  
      }

    public boolean deleteUserByName(String name) {
        List<UserData> users = repository.findByName(name);
        if (users.isEmpty()) {
            return false;
        }
        
        repository.delete(users.get(0));
        return true;
            
    }
}
