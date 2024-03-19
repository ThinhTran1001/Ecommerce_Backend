package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.Constant.StaticValidate;
import com.example.ecommerceweb.DTO.AutheticationResponse;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.Service.IUserService;
import com.example.ecommerceweb.Service.JwtService;
import com.example.ecommerceweb.converter.UserConverter;
import com.example.ecommerceweb.models.Roles;
import com.example.ecommerceweb.models.Users;
import com.example.ecommerceweb.repository.RoleRepository;
import com.example.ecommerceweb.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final UserConverter userConverter;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserConverter userConverter, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDTO AddUser(UserDTO newUser) {

        Users user = new Users();
        Roles role = roleRepository.findById(StaticValidate.CUSTOMER).orElse(null);
        if (newUser != null){
            Date currentDate = new Date();
            user = userConverter.toEntity(newUser);
            user.setRole_id(role);
            user.setStatus(true);
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
        if (newUser.getUser_id() != null){
            Users oldUser = userRepository.findById(newUser.getUser_id()).orElseThrow(() -> new EntityNotFoundException("Entity not found from database. "));
            Users updateUser = userConverter.toUpdateEntity(newUser, oldUser);
            Date currentDate = new Date();
            updateUser.setCreatedDate(currentDate);
            updateUser.setUpdatedDate(currentDate);
            userRepository.save(updateUser);
            newUser = userConverter.toDTO(updateUser);
        }
        return newUser;
    }

    @Override
    public UserDTO DeleteUser(UserDTO newUser) {

        if (newUser.getUser_id() != null){
            Users oldUser = userRepository.findById(newUser.getUser_id()).orElseThrow(() -> new EntityNotFoundException("Entity not found from database. "));
            userRepository.delete(oldUser);
            newUser = userConverter.toDTO(oldUser);
        }else {
            System.out.println("Not found id in request.");
        }
        return newUser;
    }

    @Override
    public UserDTO FindOneUser(UserDTO newUser) {
        if (newUser.getUser_id() != null){
            Users oldUser = userRepository.findById(newUser.getUser_id()).orElseThrow(() -> new EntityNotFoundException("Entity not found from database. "));
            newUser = userConverter.toDTO(oldUser);
            return newUser;
        }else {
            System.out.println("Not found id in request.");
        }
        return null;
    }

    @Override
    public List<UserDTO> FindAllUser() {
        return userConverter.toListDTO(userRepository.findAll());
    }


    public AutheticationResponse register(Users user){
        Roles role = roleRepository.findById(StaticValidate.USER).orElse(null);
        Date currentDate = new Date();
        user.setRole_id(role);
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate(currentDate);
        user.setUpdatedDate(currentDate);
        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AutheticationResponse(token);
    }

    public  AutheticationResponse authenticate(Users request){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        Users user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
        String token = jwtService.generateToken(user);
        return new AutheticationResponse(token);
    }
}
