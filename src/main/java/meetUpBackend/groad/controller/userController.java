package meetUpBackend.groad.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.User;
import meetUpBackend.groad.service.userService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class userController {
	private final userService userService;

	@GetMapping("/user/{userId}")
	public String selectRoadMap(@PathVariable("userId") String user_Id) {
		User userId = userService.getUserId(user_Id);

		return userId.toString();
	}

	@PostMapping("/user/reg")
	public void regUser(@RequestBody @Validated User userReq){
		User user = new User();
		user.setUserId(userReq.getUserId());
		userService.regUser(user);
	}

	@Data
	static class UserReq{
		private String userId;
	}
}
