package com.webservices.rest.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {

	private static List<User> list = new ArrayList<User>();

	private static int userCount = 4;
	static {
		list.add(new User(1, "Name1", new Date()));
		list.add(new User(2, "Name2", new Date()));
		list.add(new User(3, "Name3", new Date()));
		list.add(new User(4, "Name4", new Date()));

	}

	public List<User> findAll() {
		return list;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		list.add(user);

		return user;
	}

	public User findOne(int id) {
		for (User user : list) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = list.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
	
	
}
