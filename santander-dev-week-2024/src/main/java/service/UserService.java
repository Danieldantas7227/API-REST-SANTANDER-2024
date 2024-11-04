package service;

import org.springframework.stereotype.Service;

import model.User;

@Service
public interface UserService {

	public abstract User findById(Long id);
	
	User create(User user);
	
	
	
}
