package com.digistore.ecommerce.controller;

import com.digistore.ecommerce.repository.entity.User;
import com.digistore.ecommerce.service.UserService;
import com.digistore.ecommerce.service.dto.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping({"/id"})
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(userService.create(userRequest));
    }
    @DeleteMapping({"/id"})
    public ResponseEntity deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping({"/id"})
    public ResponseEntity update(@PathVariable Long id , @RequestBody @Valid UserRequest userRequest){
        User updatedUser= userService.update(id , userRequest);
        return ResponseEntity.ok(updatedUser);
    }
}
