package com.sky.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sky.constant.MessageConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import com.sky.properties.JwtProperties;
import com.sky.properties.WeChatProperties;
import com.sky.service.UserService;
import com.sky.utils.HttpClientUtil;
import com.sky.vo.UserLoginVO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    WeChatProperties weChatProperties;
    public static final String WX_LOGIN ="https://api.weixin.qq.com/sns/jscode2session";
    @Override
    public User wxLogin(UserLoginDTO userLoginDTO) throws LoginException {
        String json=getOpenId(userLoginDTO.getCode());
        JSONObject jsonObject = JSON.parseObject(json);
        String openId = jsonObject.getString("openid");
        if (openId == null || openId.equals("")) {
            throw new LoginException(MessageConstant.LOGIN_FAILED);
        }
        User user = userMapper.getByOpenId(openId);
        if (user == null) {
            user=User.builder()
                    .openid(openId)
                    .createTime(LocalDateTime.now())
                    .build();
            userMapper.Insert(user);
        }
        return user;
    }
    public String getOpenId(String code) {
        Map<String,String> map = new HashMap<>();
        map.put("appid",weChatProperties.getAppid());
        map.put("secret",weChatProperties.getSecret());
        map.put("js_code",code);
        map.put("grant_type","authorization_code");
        String json = HttpClientUtil.doGet(WX_LOGIN,map);
        return json;
    }

}
