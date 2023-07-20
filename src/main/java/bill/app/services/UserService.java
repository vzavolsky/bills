package bill.app.services;

import bill.app.entities.User;
import bill.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userExists(User user) {
        User checkUser = getUserByEmail(user.getEmail());
        if (checkUser != null) {
            return checkUser;
        }
        return null;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return user;
    }
}
