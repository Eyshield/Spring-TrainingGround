package com.trainingApi.User;

import com.trainingApi.Common.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ImplUserService implements UserService {
    private UserRepo userRepo;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userMapper.toUserResponse(userRepo.save(user));
    }

    @Override
    public UserResponse updateUser(UUID id, UserRequest userRequest) {
        User user = findUserById(id);

        user.setUsername(userRequest.getUsername());
        user.setRole(userRequest.getRole());
        user.setEmail(userRequest.getEmail());
        if (userRequest.getPassword() != null && !userRequest.getPassword().isEmpty()) {
            if (!passwordEncoder.matches(userRequest.getPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            }
        }
        return userMapper.toUserResponse(userRepo.save(user)) ;
    }

    @Override
    public void deleteUser(UUID id) {

        userRepo.delete(findUserById(id));
    }
    private User findUserById(UUID id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No User Found"));
    }

    @Override
    public UserResponse getUserById(UUID id) {
        return userMapper.toUserResponse( findUserById(id));}

    @Override
    public PageResponse<UserResponse> getAllUser(Pageable pageable) {
        return userMapper.toPageResponse(userRepo.findAll(pageable));
    }

    @Override
    public PageResponse<UserResponse> searchUser(Pageable pageable, String username) {
        return userMapper.toPageResponse(userRepo.findByUsernameContainingIgnoreCase(pageable, username));
    }
}
