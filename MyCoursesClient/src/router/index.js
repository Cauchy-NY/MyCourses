import Vue from 'vue'
import Router from 'vue-router'
import Login from "@/components/Login";
import Register from "@/components/Register";
import Admin from "@/components/Admin";
import Student from "@/components/Student";
import Teacher from "@/components/Teacher";
import PostCourse from "@/components/teacher/PostCourse";
import AdminCourse from "@/components/teacher/AdminCourse";
import CreateCourse from "@/components/teacher/CreateCourse";
import TeacherDetail from "@/components/teacher/TeacherDetail";
import MyCourse from "@/components/student/MyCourse";
import ChooseCourse from "@/components/student/ChooseCourse";
import StudentDetail from "@/components/student/StudentDetail";
import SendEmail from "@/components/teacher/course/SendEmail";
import PostHomework from "@/components/teacher/course/PostHomework";
import UploadCourseware from "@/components/teacher/course/UploadCourseware";
import DownloadCourseware from "@/components/student/course/DownloadCourseware";
import LookupHomework from "@/components/student/course/LookupHomework";
import DownloadHomework from "@/components/teacher/course/DownloadHomework";
import EditTeacherDetail from "@/components/teacher/EditTeacherDetail";
import EditStudentDetail from "@/components/student/EditStudentDetail";
import PostGrade from "@/components/teacher/course/PostGrade";
import Approval from "@/components/admin/Approval";
import Forum from "@/components/Forum";
import Statistics from "@/components/admin/Statistics";
import Discussion from "@/components/forum/Discussion";

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path:"/student",
            name:'Student',
            component: Student,
            children: [
                {
                    path:"",
                    name:'MyCourse',
                    component:MyCourse
                },
                {
                    path:"myCourse",
                    name:'MyCourse',
                    component:MyCourse
                },
                {
                    path:"chooseCourse",
                    name:'ChooseCourse',
                    component:ChooseCourse
                },
                {
                    path:"studentDetail",
                    name:'StudentDetail',
                    component:StudentDetail
                },
                {
                    path:"downloadCourseware/:id",
                    name:"DownloadCourseware",
                    component:DownloadCourseware
                },
                {
                    path:"lookupHomework/:id",
                    name:"LookupHomework",
                    component:LookupHomework
                },
                {
                    path: "editStudentDetail",
                    name: "EditStudentDetail",
                    component:EditStudentDetail
                },
                {
                    path: "forum",
                    name: "Forum",
                    component: Forum
                },
                {
                    path: "discussion/:id",
                    name: "Discussion",
                    component: Discussion
                }
            ]
        },
        {
            path:"/teacher",
            name:'Teacher',
            component: Teacher,
            children: [
                {
                    path:"",
                    name:'AdminCourse',
                    component:AdminCourse
                },
                {
                    path:"adminCourse",
                    name:'AdminCourse',
                    component:AdminCourse
                },
                {
                    path:"createCourse",
                    name:'CreateCourse',
                    component:CreateCourse
                },
                {
                    path:"postCourse",
                    name:'PostCourse',
                    component:PostCourse
                },
                {
                    path:"teacherDetail",
                    name:'TeacherDetail',
                    component:TeacherDetail
                },
                {
                    path:"sendEmail/:id",
                    name:'SendEmail',
                    component:SendEmail
                },
                {
                    path:"postHomework/:id",
                    name:'PostHomework',
                    component:PostHomework
                },
                {
                    path:"uploadCourseware/:id",
                    name:'UploadCourseware',
                    component:UploadCourseware
                },
                {
                    path:"downloadHomework/:id",
                    name:'DownloadHomework',
                    component:DownloadHomework

                },
                {
                    path: "editTeacherDetail",
                    name: "EditTeacherDetail",
                    component:EditTeacherDetail
                },
                {
                    path: "postGrade/:id",
                    name: "PostGrade",
                    component: PostGrade
                },
                {
                    path: "forum",
                    name: "Forum",
                    component: Forum
                },
                {
                    path: "discussion/:id",
                    name: "Discussion",
                    component: Discussion
                }
            ]
        },
        {
            path:"/admin",
            name:'Admin',
            component: Admin,
            children: [
                {
                    path:"",
                    name:'Approval',
                    component: Approval
                },
                {
                    path:"approval",
                    name:'Approval',
                    component: Approval
                },
                {
                    path: "statistics",
                    name: "Statistics",
                    component: Statistics
                }
            ]
        },
        {
            path:"/login",
            name:'Login',
            component: Login
        },
        {
            path:"/register",
            name:'Register',
            component: Register
        }
    ],
    mode:"history"
})
