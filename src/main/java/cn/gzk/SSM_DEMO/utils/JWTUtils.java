package cn.gzk.SSM_DEMO.utils;/*
 *ClassName:JWTUtils
 *Description:
 *Author: GZK0329
 *Date: 2021/3/24
 */

import cn.gzk.SSM_DEMO.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/*
 * JWT工具类
 */
public class JWTUtils {

    //redis中的过期时间
    private static final long EXPIRE = 60000 * 60 * 24 * 7;//过期时间 一周 单位ms

    //密钥
    private static final String SECRET = "cngzk.net0329";

    //token令牌前缀
    private static final String PREFIX = "cngzk";

    //主题subject
    private static final String SUBJECT = "cngzk";

    /* @description:根据用户信息生成令牌token
     * @param user
     * @return java.lang.String
     */
    public static String geneJsonWebToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())//载荷注入playload
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())//令牌产生时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//令牌失效时间
                .signWith(SignatureAlgorithm.HS256, SECRET)//设置签名算法
                .compact();//返回字符串
        token = PREFIX + token;
        return token;
    }

    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
