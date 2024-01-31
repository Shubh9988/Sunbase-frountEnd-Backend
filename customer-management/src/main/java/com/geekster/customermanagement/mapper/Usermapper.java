package com.geekster.customermanagement.mapper;

import com.geekster.customermanagement.Model.User;
import com.geekster.customermanagement.dto.UserDto;

public class Usermapper {
  public  static User UserDtoToUser(UserDto userDto,User user){
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        return user;
    }
   public static UserDto UsertouserDto (User user,UserDto userDto){
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;

    }


}
