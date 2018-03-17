package com.h2.example.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.h2.example.entity.User;
import com.h2.example.repository.UserRepository;

@SpringBootTest
public class ServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepo;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addUser() {
		User user = getMockUser();
		Mockito.when(userRepo.save(user)).thenReturn(user);
		User userResponse = userService.addUser(user);
		assertEquals(userResponse.getEmailId(), user.getEmailId());
	}
	
	@Test
	public void addListOfUser() {
		List<User> userList = new ArrayList<>();
		userList.add(getMockUser());
		Mockito.when(userRepo.saveAll(userList)).thenReturn(userList);
		List<User> userListResponse = userService.addListOfUser(userList);
		assertEquals(userListResponse.size(), userList.size());
	}
	
	@Test
	public void getAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(getMockUser());
		Mockito.when(userRepo.findAll()).thenReturn(userList);
		List<User> userListResponse = userService.getAllUsers();
		assertEquals(userListResponse.size(), userList.size());
	}
	
	private User getMockUser() {
		User user = new User();
		user.setEmailId("test@test.com");
		user.setFirstName("Test");
		return user;
	}
	
}
