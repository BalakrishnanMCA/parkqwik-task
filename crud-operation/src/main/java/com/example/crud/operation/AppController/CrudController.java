package com.example.crud.operation.AppController;

import org.springframework.web.bind.annotation.RestController;

import com.example.crud.operation.AppEntity.MailData;
import com.example.crud.operation.AppEntity.UserData;
import com.example.crud.operation.AppService.CrudService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
public class CrudController {

    @Autowired
    CrudService service;

    @PostMapping("/insert")
    public ResponseEntity<String> saveUser(@RequestBody UserData entity) {
        service.saveUser(entity);
        return ResponseEntity.ok("value uploaded");
    }
    
    @GetMapping("/getuser/{name}")
    public List<UserData> getUser(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PostMapping("/updateuser/{name}")
    public ResponseEntity<String> getMethodName(@PathVariable String name, @RequestBody UserData entity) {
        boolean taskcomplete=service.updateuser(name,entity);
        if (taskcomplete) {
            return ResponseEntity.ok("value updated successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @GetMapping("/deleteuser/{name}")
    public ResponseEntity<String> deleteUser(@PathVariable String name) {
        boolean userdeleted=service.deleteUserByName(name);
        if (userdeleted) {
            return ResponseEntity.ok("user data deleted successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
    
    @PostMapping("/sendmail")
    public String sentmail(@RequestBody MailData data) {

        service.sendMail(data);
        return "successfully mail sended";
    }
    
    
    

}
