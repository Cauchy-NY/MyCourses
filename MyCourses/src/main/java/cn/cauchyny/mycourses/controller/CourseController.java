package cn.cauchyny.mycourses.controller;

import cn.cauchyny.mycourses.dto.CourseDto;
import cn.cauchyny.mycourses.model.*;
import cn.cauchyny.mycourses.service.CourseService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 获取老师已创建的课程列表
     * @param map
     * @return
     */
    @PostMapping("/getCourseList")
    public String getCourseList(@RequestBody Map<String, String> map) {
        String teacherId = map.get("id");
        List<Course> courseList = courseService.getCourseList(teacherId);
        return JSONObject.toJSONString(courseList);
    }

    /**
     * 新建课程
     * @param map
     * @return
     */
    @PostMapping("/insertCourse")
    public String insertCourse(@RequestBody Map<String, Course> map) {
        Course course = map.get("course");
        System.out.println(course.toString());
        return courseService.insertCourse(course);
    }

    /**
     * 获取课程详情
     * @param map
     * @return
     */
    @PostMapping("/getCourseDetailList")
    public String getCourseDetailList(@RequestBody Map<String, String> map) {
        String teacherId = map.get("id");
        List<CourseDto> courseRecordList = courseService.getCourseDetailList(teacherId);
        return JSONObject.toJSONString(courseRecordList);
    }

    /**
     * 新增课程发布
     * @param map
     * @return
     */
    @PostMapping("/insertCourseRecord")
    public String insertCourseRecord(@RequestBody Map<String, CourseRecord> map) {
        CourseRecord courseRecord = map.get("courseRecord");
        System.out.println(courseRecord.toString());
        return courseService.insertCourseRecord(courseRecord);
    }

    /**
     * 获取学生已选择课程列表
     * @param map
     * @return
     */
    @PostMapping("/getSelectedCourse")
    public String getSelectedCourse(@RequestBody Map<String, String> map) {
        String studentId = map.get("id");
        List<CourseDto> courseDtoList = courseService.getSelectedCourse(studentId);
        return JSONObject.toJSONString(courseDtoList);
    }

    /**
     * 获取学生未选择课程列表
     * @param map
     * @return
     */
    @PostMapping("/getUnselectedCourse")
    public String getUnselectedCourse(@RequestBody Map<String, String> map) {
        String studentId = map.get("id");
        List<CourseDto> courseDtoList = courseService.getUnselectedCourse(studentId);
        return JSONObject.toJSONString(courseDtoList);
    }

    /**
     * 学生选课
     * @param map
     * @return
     */
    @PostMapping("/selectCourse")
    public String selectCourse(@RequestBody Map<String, Selection> map) {
        Selection selection = map.get("selection");
        System.out.println(selection.toString());
        return courseService.selectCourse(selection);
    }

    /**
     * 学生退课
     * @param map
     * @return
     */
    @PostMapping("/quitCourse")
    public String quitCourse(@RequestBody Map<String, Selection> map) {
        Selection selection = map.get("selection");
        System.out.println(selection.toString());
        return courseService.quitCourse(selection);
    }

    @PostMapping("/insertHomework")
    public String insertHomework(@RequestBody Map<String, Homework> map) {
        Homework homework = map.get("homework");
        System.out.println(homework.toString());
        return courseService.insertHomework(homework);
    }

    @PostMapping("/getHomework")
    public String getHomework(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        List<Homework> homeworkList = courseService.getHomework(id);
        return JSONObject.toJSONString(homeworkList);
    }

    @PostMapping("/getSelections")
    public String getSelections(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        List<Selection> selectionList = courseService.getSelections(id);
        return JSONObject.toJSONString(selectionList);
    }

    @PostMapping("/saveSelections")
    public String saveSelections(@RequestBody Map<String, List<Selection>> map) {
        List<Selection> selectionList = map.get("selections");
        courseService.updateSelections(selectionList);
        return "success";
    }

    @PostMapping("/getGrade")
    public double getGrade(@RequestBody Map<String, String> map) {
        String userId = map.get("userId");
        String recordId = map.get("recordId");
        return courseService.getGrade(userId, recordId);
    }

    @PostMapping("/getUnapprovalList")
    public String getUnapprovalList() {
        return JSONObject.toJSONString(courseService.getUnapprovalList());
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        courseService.updateCourse(id);
        return "success";
    }

    @PostMapping("/updateCourseRecord")
    public String updateCourseRecord(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        courseService.updateCourseRecord(id);
        return "success";
    }
}
