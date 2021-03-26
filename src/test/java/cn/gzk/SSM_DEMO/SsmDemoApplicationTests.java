package cn.gzk.SSM_DEMO;

import cn.gzk.SSM_DEMO.model.entity.User;
import cn.gzk.SSM_DEMO.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmDemoApplicationTests {

	@Test
	public void testGeneJWT(){
		User user = new User();
		user.setId(666);
		user.setName("李四");
		user.setHeadImg("png");

		String token = JWTUtils.geneJsonWebToken(user);
		System.out.println(token);
		Claims claims = JWTUtils.checkJWT(token);
		System.out.println(claims.get("name"));
	}

}
