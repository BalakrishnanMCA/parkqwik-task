package com.example.crud.operation.AppRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.operation.AppEntity.UserData;
import java.util.List;


@Repository
public interface CrudRepository extends MongoRepository<UserData,String>{

    List<UserData> findByName(String name);

}
