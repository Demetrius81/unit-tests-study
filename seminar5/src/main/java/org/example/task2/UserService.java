package org.example.task2;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }
}
