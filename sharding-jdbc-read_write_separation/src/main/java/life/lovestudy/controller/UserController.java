package life.lovestudy.controller;

import life.lovestudy.entity.UserEntity;
import life.lovestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/findUser")
	public List<UserEntity> findUser() {
		return userService.findUser();
	}

	@RequestMapping("/insertUser")
	public String insertUser(String userName) {
		return userService.insertUser(userName) > 0 ? "success" : "fail";
	}

}
