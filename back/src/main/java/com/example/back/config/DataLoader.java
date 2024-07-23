package com.example.back.config;

import com.example.back.entities.User;
import com.example.back.entities.UserProfile;
import com.example.back.repositories.UserRepository;
import com.example.back.repositories.UserProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword(passwordEncoder.encode("password1"));

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setFirstName("John");
        userProfile1.setLastName("Doe");
        userProfile1.setEmail("john.doe@example.com");
        userProfile1.setPhoneNumber("123-456-7890");
        userProfile1.setUser(user1);
        user1.setUserProfile(userProfile1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword(passwordEncoder.encode("password2"));

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setFirstName("Jane");
        userProfile2.setLastName("Doe");
        userProfile2.setEmail("jane.doe@example.com");
        userProfile2.setPhoneNumber("098-765-4321");
        userProfile2.setUser(user2);
        user2.setUserProfile(userProfile2);

        User user3 = new User();
        user3.setUsername("user3");
        user3.setPassword(passwordEncoder.encode("password3"));

        UserProfile userProfile3 = new UserProfile();
        userProfile3.setFirstName("Alice");
        userProfile3.setLastName("Smith");
        userProfile3.setEmail("alice.smith@example.com");
        userProfile3.setPhoneNumber("555-555-5555");
        userProfile3.setUser(user3);
        user3.setUserProfile(userProfile3);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
