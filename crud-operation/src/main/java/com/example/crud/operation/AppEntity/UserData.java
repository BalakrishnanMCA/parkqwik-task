package com.example.crud.operation.AppEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "UserDetails")
public class UserData {

    @Id
    String id;
    String name;
    String mobile;
    String email;
    String address;
    String vehiclenumber;
    String vehiclemodel;
    String vehicletype;


}
