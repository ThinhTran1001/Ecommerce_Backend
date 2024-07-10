package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.DTO.AutheticationResponse;
import com.example.ecommerceweb.DTO.UserDTO;
import com.example.ecommerceweb.DTO.request.UserRequestLoginDTO;
import com.example.ecommerceweb.Service.IUserService;
import com.example.ecommerceweb.Service.JwtService;
import com.example.ecommerceweb.converter.UserConverter;
import com.example.ecommerceweb.mapper.UserMapper;
import com.example.ecommerceweb.models.ImageData;
import com.example.ecommerceweb.models.Role;
import com.example.ecommerceweb.models.Users;
import com.example.ecommerceweb.repository.ImageRepository;
import com.example.ecommerceweb.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService{

    private final UserRepository userRepository;

    private  final ImageRepository imageRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserMapper userMapper;

    @Override
    public Long AddUser(UserDTO newUser) {
        Users user = userMapper.convertToUser(newUser);
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));

        userRepository.save(user);
        log.info("Add new user");

        return user.getId();
    }

    @Override
    public void UpdateUser(Long userId,UserDTO dto) {
        Users entity = getOneUser(userId);
        if (dto != null){
            entity.setFullName(dto.getFullName());
            entity.setPassword(dto.getPassword());
            entity.setEmail(dto.getEmail());
            entity.setRole(dto.getRole());
            entity.setStatus(dto.isStatus());
            entity.setCreatedAt(dto.getCreatedAt());
            entity.setUpdatedAt(dto.getUpdatedAt());
            entity.setBooksCreated(dto.getBooksCreated());
            entity.setBooksUpdated(dto.getBooksUpdated());

        }

        log.info("User has save!");

    }

    @Override
    public void DeleteUser(Long userId) {
        Users users = getOneUser(userId);
        userRepository.delete(users);

        log.info("Delete user by id = {}",users.getId());
    }

    @Override
    public UserDTO FindOneUser(Long userId) {
        Users user = getOneUser(userId);
        return userMapper.convertToUserDTO(user);
    }

    @Override
    public List<UserDTO> FindAllUser() {
        return null;
    }



    public AutheticationResponse register(UserRequestLoginDTO dto){
        Users user = userMapper.convertToUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AutheticationResponse(token);
    }

    public  AutheticationResponse authenticate(UserRequestLoginDTO request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        Users user = getOneUser(request.getUsername());
        String token = jwtService.generateToken(user);
        return new AutheticationResponse(token);
    }

    private Users getOneUser(Long userId){
        return  userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
    }

    private Users getOneUser(String username){
        return  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Not Found User"));
    }
}
