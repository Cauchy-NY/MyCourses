package cn.cauchyny.mycourses.controller;

import cn.cauchyny.mycourses.model.User;
import cn.cauchyny.mycourses.model.UserProfile;
import cn.cauchyny.mycourses.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Log log = LogFactory.getLog(UserController.class);

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String password = map.get("password");
        System.out.println("id: " + id + ", password: " + password);
        return userService.loginProcess(id, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String password = map.get("password");
        String verificationCode = map.get("verificationCode");
        String type = map.get("type");
        String encoded = map.get("encoded");

        User user = new User(id, password, id, type);
        System.out.println(user.toString());
        return userService.registerProcess(user, verificationCode, encoded);
    }

    @PostMapping("/sendVerificationCode")
    public String sendVerificationCode(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        return userService.sendVerificationCode(id);
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        userService.deleteUser(id);
        return "success";
    }

    @PostMapping("/getUserProfile")
    public String getUserProfile(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        return JSONObject.toJSONString(userService.getUserProfile(id));
    }

    @PostMapping("/updateUserProfile")
    public String updateUserProfile(@RequestBody Map<String, UserProfile> map) {
        UserProfile userProfile = map.get("userProfile");
        userService.updateUserProfile(userProfile);
        return "success";
    }

}
