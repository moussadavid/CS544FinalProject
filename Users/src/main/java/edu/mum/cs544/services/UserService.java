package edu.mum.cs544.services;

import java.util.List;

import edu.mum.cs544.dtos.GetUser;
import edu.mum.cs544.dtos.KCCreateUser;
import edu.mum.cs544.dtos.UpdateUser;
import edu.mum.cs544.entities.User;
import edu.mum.cs544.repositories.IUserDao;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final IUserDao userDao;
    private final KeycloakAdminClientService keycloakAdminClientService;
    private final ModelMapper modelMapper;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User add(User user) throws Exception {
        KCCreateUser result = keycloakAdminClientService.createNewUser(user.getUsername(), user.getPassword());
        if (result.getStatus() == 201) {
            user.setKeyCloakId(result.getKCId());
            return userDao.save(user);
        } else if (result.getStatus() == 409)
            throw new Exception("username already exist");
        return null;
    }

    public GetUser get(int id) {
        return modelMapper.map(userDao.findById(id).get(), GetUser.class);
    }

    public UpdateUser update(UpdateUser user) {
        return modelMapper.map(userDao.save(modelMapper.map(user, User.class)), UpdateUser.class);
    }

    public boolean delete(int id) {
        userDao.deleteById(id);
        return true;
    }
}