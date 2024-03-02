package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.Constant.StaticValidate;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.Service.IUserService;
import com.example.ecommerceweb.converter.UserConverter;
import com.example.ecommerceweb.models.Roles;
import com.example.ecommerceweb.models.Users;
import com.example.ecommerceweb.repository.RoleRepository;
import com.example.ecommerceweb.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public UserDTO AddUser(UserDTO newUser) {

        Users user = new Users();
        Roles role = roleRepository.findById(StaticValidate.CUSTOMER).orElse(null);
        if (newUser != null){
            Date currentDate = new Date();
            user = userConverter.toEntity(newUser);
            user.setRole_id(role);
            user.setCreatedDate(currentDate);
            user.setUpdatedDate(currentDate);
            userRepository.save(user);
            newUser = userConverter.toDTO(user);
            return newUser;
        }
        return null;
    }

    @Override
    public UserDTO UpdateUser(UserDTO newUser) {
        return null;
    }

    @Override
    public UserDTO DeleteUser(UserDTO newUser) {
        return null;
    }

    @Override
    public UserDTO FindOneUser(UserDTO newUser) {
        return null;
    }

    @Override
    public List<Users> FindAllUser() {
        return userRepository.findAll();
    }
}
