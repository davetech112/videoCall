package com.dave.videocall.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins ="*")
@Slf4j
public class UserController {
    private final UserService service;
    @PostMapping("/register")
    public void register(@RequestBody User user) {
        service.register(user);
    }
    @PostMapping("/login")
    public User login(@RequestBody User user){
       return service.login(user);
    }
    @PostMapping("/logout")
    public void logout(@RequestBody User user){
        service.logout(user.getEmail());
    }
    @GetMapping
    public List<User> findAll(){
      return service.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex){
        ex.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }

}
