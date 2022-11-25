package meetUpBackend.groad.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meetUpBackend.groad.domain.Member;
import meetUpBackend.groad.service.UserService;
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
public class UserController {
	private final UserService userService;

	@GetMapping("/user/{userId}")
	public String selectRoadMap(@PathVariable("userId") String user_Id) {
		Member userId = userService.getUserId(user_Id);

		return userId.toString();
	}

	@PostMapping("/user/reg")
	public void regUser(@RequestBody @Validated Member userReq){
		Member user = new Member();
		user.setUserId(userReq.getUserId());
		userService.regUser(user);
	}

	@Data
	static class UserReq{
		private String userId;
	}
}
