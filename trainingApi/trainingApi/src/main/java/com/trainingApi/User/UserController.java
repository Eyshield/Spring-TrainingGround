package com.trainingApi.User;

import com.trainingApi.Common.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(userRequest));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse>getUser(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <UserResponse>updateUser(@PathVariable UUID id, @RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,userRequest));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/all")
    public ResponseEntity<PageResponse<UserResponse>> getAllUser(@PageableDefault(page = 0, size=10)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser(pageable));
    }
    @GetMapping("/search")
    public ResponseEntity<PageResponse<UserResponse>>searchUser(@PageableDefault(page = 0,size = 10)Pageable pageable, @RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(userService.searchUser(pageable,name));
    }
}
