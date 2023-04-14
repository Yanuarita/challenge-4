package com.example.tiket.controller;

import com.example.tiket.model.Users;
import com.example.tiket.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/getAllPassword")
    public List<Users> getPassword() {
        return service.getUsersByPasswordDesc();
    }

    @PostMapping("/addUsersAuto")
    public int addUsersAuto(@RequestBody Users users) {
        return service.saveUsers(users);
    }

//    users id, users name, email address, password

    // tambah satu data
    @PostMapping("/addUsers")
    public Users addUsers(@RequestBody Users users) {
        return service.addUsers(users);
    }

    // tambah beberapa data
    @PostMapping("/addUsers")
    public List<Users> addUsers(@RequestBody List<Users> users) {
        return service.addUsers(users);
    }

    // mendapatkan data
    @GetMapping("/getAll")
    public Iterator<Users> getAll() {
        return service.getAll();
    }

    // mendapatkan data dari nama user
    @GetMapping("/findByUserName")
    public List<Users> findByUserName(@RequestBody Users users) {
        return service.findByUserName(users.getUserName());
    }

    // menghapus data dari ID
    @DeleteMapping("/delete")
    public String deleteById(@RequestBody int id) {
        return service.deleteById(id);
    }

    // memperbarui data
    @PutMapping("/update")
    public String updateUsers(@RequestBody Users users) throws ParseException {
        return service.updateUsers(users);
    }
}