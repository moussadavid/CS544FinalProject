package edu.mum.cs544.services;

import java.util.List;

import edu.mum.cs544.entities.User;
import edu.mum.cs544.repositories.IUserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final IUserDao userDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User add(User user) {
        return userDao.save(user);
    }

    public User get(int id) {
        return userDao.findById(id).get();
    }

    public User update(User user) {
        return userDao.save(user);
    }

    public boolean delete(int id) {
        userDao.deleteById(id);
        return true;
    }
}