package ar.com.nat.auth.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.com.nat.auth.models.User;
import ar.com.nat.auth.repository.RoleRepository;
import ar.com.nat.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	   @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private RoleRepository roleRepository;
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Override
	    public void save(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setRoles(new HashSet<>(roleRepository.findAll()));
	        userRepository.save(user);
	    }

	    @Override
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }
}
