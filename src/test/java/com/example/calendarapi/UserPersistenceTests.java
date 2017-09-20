package com.example.calendarapi;

import com.example.calendarapi.controllers.UserController;
import com.example.calendarapi.models.User;
import com.example.calendarapi.models.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserPersistenceTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void findByUserNameCorrectReturn() {

		User user = new User("jbush@gmail.com", "Jordan", "Bush", "jordanbush", "passs");
		userDao.save(user);

		User foundUser = userDao.findByUserName("jordanbush");

		assertThat(foundUser.getUserName()).isEqualTo(user.getUserName());
		assertThat(foundUser.getEmail()).isEqualTo(user.getEmail());
		assertThat(foundUser.getFirstName()).isEqualTo(user.getFirstName());
		assertThat(foundUser.getLastName()).isEqualTo(user.getLastName());
		assertThat(foundUser.getPassword()).isEqualTo(user.getPassword());
		assertThat(foundUser.getId()).isEqualTo(user.getId());
	}

}
