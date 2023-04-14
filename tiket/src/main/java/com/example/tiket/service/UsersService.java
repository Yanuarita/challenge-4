package com.example.tiket.service;

import com.example.tiket.model.Users;
import com.example.tiket.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    EntityManager entityManager;


    public UsersService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public int saveUsers(Users users) {
        entityManager.persist(users);
        return users.getUsersId();
    }

    public List<Users> getUsersByPasswordDesc() {
        return repository.findByUsersPasswordDesc();
    }

    public Iterator<Users> getAll() {
        Iterator<Users> check = repository.findAll().iterator();
        if (check.hasNext()) return check;
        else throw new RuntimeException("data tidak tersedia");
    }

    public List<Users> findByUserName(String name) {
        if (repository.findByUserName(name).isEmpty()) throw new RuntimeException("nama user tidak ditemukan...!");
        else return repository.findByUserName(name);
    }

    public String deleteById(int id) {
        repository.deleteById(id);
        return "Berhasil di hapus..!";
    }

    public String updateUsers(Users users) throws ParseException {
        if (isExist(users)) {
            Users update = repository.findById(users.getUsersId()).orElse(null);
            update.setUsersId(users.getUsersId());
            update.setUserName(users.getUserName());
            update.setEmailAddress(users.getEmailAddress());
            update.setPassword(users.getPassword());
            repository.save(update);
            return "data berhasil di perbarui..!";
        } else {
            throw new RuntimeException("data dengan id " + users.getUsersId() + " tidak tersedia...!");
        }
    }


    public boolean isExist(Users users) {
        Optional<Users> check = repository.findById(users.getUsersId());
        return check.isPresent();
    }

    public Users addUsers(Users users) {
        if (isExist(users)) throw new RuntimeException("data sudah tersedia...!");
        else {
            return repository.save(users);
        }
    }

    public List<Users> addUsers(List<Users> users) {
        Iterator<Users> check = users.iterator();
        while (check.hasNext()) {
            Users temp = check.next();
            if (isExist(temp)) throw new RuntimeException("data dengan id " + temp.getUsersId() + " sudah tersedia...!");
        }
        return repository.saveAll(users);
    }
}