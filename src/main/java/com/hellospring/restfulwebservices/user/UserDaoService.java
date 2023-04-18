package com.hellospring.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "Amanda", LocalDate.now().minusYears(24)));
		users.add(new User(++usersCount, "Teste", LocalDate.now().minusYears(18)));
		users.add(new User(++usersCount, "Feeling 22", LocalDate.now().minusYears(22)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteUserById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
}
