package com.trainingApi.User;

import com.trainingApi.Common.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class UserMapper {
    public UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
    public User toUser(UserRequest userRequest){
        return User.builder()
                .id(userRequest.getId())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .role(userRequest.getRole())
                .build();
    }
    public PageResponse<UserResponse> toPageResponse(Page<User>users){
        List<UserResponse> userResponseList=new ArrayList<>();
        for (User user:users.getContent()){
            userResponseList.add(toUserResponse(user));
        }
        return new PageResponse<UserResponse>(
                userResponseList,
                users.getNumber(),
                users.getSize(),
                users.getTotalElements(),
                users.getTotalPages(),
                users.isFirst(),
                users.isLast()
        );




    }
}
