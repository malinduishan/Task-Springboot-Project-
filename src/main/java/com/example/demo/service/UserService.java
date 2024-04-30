package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    public User saveUser(UserDTO userDTO){
        return userRepo.save(modelMapper.map(userDTO, User.class));
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());

    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
    return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }

    //    user id > user details
    //    select * from user where id = 1;

    public UserDTO getUserByUserID(String userID){
       User user =  userRepo.getUserByUserId(userID);
        return modelMapper.map(user, UserDTO.class);

    }

    //    user id, fname > user details
    //    select * from user where id = 1 and fname = "malindu";
public UserDTO getUserByIdAndFname(String userId,String fname){
        User user = userRepo.getUserByIdAndFname(userId,fname);
    return modelMapper.map(user, UserDTO.class);
}

}
