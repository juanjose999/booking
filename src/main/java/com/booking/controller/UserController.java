package com.booking.controller;

import com.booking.dto.user.UserDto;
import com.booking.dto.user.UserResponseDto;
import com.booking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        try{
            return ResponseEntity.ok(userService.getAllUsers());
        }catch (Exception e){
            return new ResponseEntity("Error in getAllUsers controller: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponseDto> findUserById (@PathVariable String idUser){
        try{
            return new ResponseEntity<>(userService.findUserById(idUser),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("the user " + idUser + " doesn't in the data base.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String idUser,@RequestBody UserDto userDto){
        try{
            Boolean isUpdateUser = userService.updateUser(idUser, userDto);
            if(isUpdateUser){
                return new ResponseEntity("The user is update", HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException e){
            return new ResponseEntity("the user " + idUser + " doesn't in the data base." , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Boolean> deleteUser(String idUser){
        return new ResponseEntity<>(userService.deleteUser(idUser),HttpStatus.OK);
    }

}