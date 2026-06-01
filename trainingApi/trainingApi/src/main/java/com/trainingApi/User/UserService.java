package com.trainingApi.User;

import com.trainingApi.Common.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {
    UserResponse addUser(UserRequest userRequest);
    UserResponse updateUser(UUID id,UserRequest userRequest);
    void deleteUser(UUID id);
    UserResponse getUserById(UUID id);
    PageResponse<UserResponse> getAllUser(Pageable pageable);
    PageResponse<UserResponse> searchUser(Pageable pageable,String username);

}
