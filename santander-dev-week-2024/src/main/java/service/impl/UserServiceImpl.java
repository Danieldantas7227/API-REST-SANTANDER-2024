package service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public User findById(Long id) {
		
		Optional<User> byId = userRepository.findById(id);

		if (!byId.isEmpty() ) { return byId.get(); }
		else {
			throw new NoSuchElementException();
		}
		
	} 

	@Override
	public User create(User user) {
		
		if(user.getId() != null && !userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
			
			return userRepository.save(user);
		} else {
			throw new IllegalArgumentException("O número da conta já existe!");
		}
	}

	
	
	
}
