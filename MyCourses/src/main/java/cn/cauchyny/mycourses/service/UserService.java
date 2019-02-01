package cn.cauchyny.mycourses.service;

import cn.cauchyny.mycourses.dao.UserDao;
import cn.cauchyny.mycourses.dao.UserProfileDao;
import cn.cauchyny.mycourses.model.User;
import cn.cauchyny.mycourses.model.UserProfile;
import cn.cauchyny.mycourses.util.Base64Util;
import cn.cauchyny.mycourses.util.MailHelper;
import cn.cauchyny.mycourses.util.TokenUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserProfileDao userProfileDao;

    public String registerProcess(User user, String verificationCode, String encoded) {
        User existed = userDao.getUserById(user.getId());
        if (existed == null) {
//            if (Base64Util.decodeData(encoded).equals(verificationCode)) {
                userDao.insert(user);
                UserProfile userProfile = new UserProfile(user.getId(), "none", "none", "none");
                userProfileDao.insert(userProfile);
                return new JSONObject(){{put("message","success");}}.toString();
//            } else {
//                return new JSONObject(){{put("message","验证码不正确");}}.toString();
//            }
        } else {
            return new JSONObject(){{put("message","账号已存在");}}.toString();
        }
    }

    public String loginProcess(String id, String password) {
        User user = userDao.getUserByIdAndPassword(id, password);
        if (user != null)
            return new JSONObject(){{
                put("message","success");
                put("id", user.getId());
                put("type", user.getType());
            }}.toString();
        else
            return new JSONObject(){{put("message","fail");}}.toString();
    }

    public String sendVerificationCode(String id) {
        String email = id + "@smail.nju.edu.cn";
        MailHelper mailHelper = new MailHelper();
        String subject = "MyCourses验证码";
        String content = "您好：\n" +
                "欢迎加入MyCourses！您的注册验证码是：";
        String code = TokenUtil.getRandomToken(6);
        content += code + "\n请尽快完成注册";
        mailHelper.sendSimpleMail(email, subject, content);
        return Base64Util.encodeData(code);
    }

    public void deleteUser(String id) {
        userDao.delete(id);
    }

    public void updateUserProfile(UserProfile userProfile) {
        userProfileDao.updateByUserId(userProfile);
    }

    public UserProfile getUserProfile(String userId) {
        return userProfileDao.selectByUserId(userId);
    }
}
