package bigxuexue.club.ngalain.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import bigxuexue.club.ngalain.sys.annotation.UserLoginToken;
import bigxuexue.club.ngalain.sys.entity.Staff;
import bigxuexue.club.ngalain.sys.service.StaffService;
import bigxuexue.club.ngalain.sys.service.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private StaffService staffService;
	@Autowired
	TokenService tokenService;

	// 登录
	@PostMapping("/login")
	public Object login(@RequestBody Staff staff) {
		JSONObject jsonObject = new JSONObject();
		Staff userForBase = staffService.findStaff(staff);
		if (userForBase == null) {
			jsonObject.put("message", "登录失败,用户不存在");
			return jsonObject;
		} else {
			if (!userForBase.getPassword().equals(staff.getPassword())) {
				jsonObject.put("message", "登录失败,密码错误");
				return jsonObject;
			} else {
				String token = tokenService.getToken(userForBase);
				jsonObject.put("token", token);
				jsonObject.put("user", userForBase);
				return jsonObject;
			}
		}
	}

	@UserLoginToken
	@GetMapping("/getMessage")
	public String getMessage() {
		return "你已通过验证";
	}

}
