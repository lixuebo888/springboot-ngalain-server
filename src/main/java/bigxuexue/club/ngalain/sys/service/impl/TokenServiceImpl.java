package bigxuexue.club.ngalain.sys.service.impl;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import bigxuexue.club.ngalain.sys.entity.Staff;
import bigxuexue.club.ngalain.sys.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public String getToken(Staff staff) {
		String token = "";
		token = JWT.create().withAudience(staff.getId())// 将 user id 保存到 token 里面
				.sign(Algorithm.HMAC256(staff.getPassword()));// 以 password 作为 token 的密钥
		return token;
	}

}
