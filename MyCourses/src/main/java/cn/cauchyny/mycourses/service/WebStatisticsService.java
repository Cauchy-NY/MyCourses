package cn.cauchyny.mycourses.service;

import cn.cauchyny.mycourses.dao.CourseDao;
import cn.cauchyny.mycourses.dao.CourseRecordDao;
import cn.cauchyny.mycourses.dao.HomeworkDao;
import cn.cauchyny.mycourses.dao.UserDao;
import cn.cauchyny.mycourses.dto.WebStatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebStatisticsService {
    @Autowired
    private HomeworkDao homeworkDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseRecordDao courseRecordDao;

    public WebStatisticsDto getWebStatisticsDto() {
        return new WebStatisticsDto(userDao.getstudentNum(), userDao.getTeacherNum(),
                courseDao.getCourseNum(), courseRecordDao.getCourseRecordNum(),
                homeworkDao.getHomeWorkNum());
    }
}
