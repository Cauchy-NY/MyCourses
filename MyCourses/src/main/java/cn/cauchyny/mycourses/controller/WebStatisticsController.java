package cn.cauchyny.mycourses.controller;

import cn.cauchyny.mycourses.service.WebStatisticsService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webStatistics")
public class WebStatisticsController {
    @Autowired
    private WebStatisticsService webStatisticsService;

    @PostMapping("/getWebStatistics")
    public String getWebStatistics() {
        return JSONObject.toJSONString(webStatisticsService.getWebStatisticsDto());
    }
}
