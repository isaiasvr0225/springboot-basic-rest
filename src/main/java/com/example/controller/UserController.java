package com.example.controller;

import com.example.entity.UserEntity;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<UserEntity> findById(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }

    @PostMapping("/save")
    public UserEntity save(@RequestBody UserEntity userEntity){
       return userService.save(userEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(name = "id") Long id){
        userService.deleteById(id);
        return "Se ha eliminado correctamente!";
    }
}
