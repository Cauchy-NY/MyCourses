package cn.cauchyny.mycourses.controller;

import cn.cauchyny.mycourses.model.Discussion;
import cn.cauchyny.mycourses.service.DiscussionService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/discussion")
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;

    @PostMapping("/getPostList")
    public String getPostList() {
        List<Discussion> discussionList = discussionService.getPostList();
        return JSONObject.toJSONString(discussionList);
    }

    @PostMapping("/getPostDetail")
    public String getPostDetail(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        List<Discussion> discussionList = discussionService.getPostDetail(id);
        return JSONObject.toJSONString(discussionList);
    }

    @PostMapping("/insertDiscussion")
    public String insertDiscussion(@RequestBody Map<String, Discussion> map) {
        Discussion discussion = map.get("discussion");
        System.out.println(discussion.toString());
        discussionService.insertDiscussion(discussion);
        return "success";
    }
}
