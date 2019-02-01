<template>
    <div class="course-from">
        <mu-container>
            <mu-expansion-panel v-for="course in courses" :key="course.courseId">
                <div slot="header">
                    {{course.course.courseName}}
                    <span v-if="course.courseRecord.year != new Date().getFullYear()" color="red">
                        已结课
                    </span><br>
                    学期: {{course.courseRecord.year}}-{{course.courseRecord.semester}}
                </div>
                <div>
                    {{course.course.courseDes}}
                </div>
                <div slot="action" flat >
                    <mu-button @click="uploadCourseware(course.courseRecord.recordId)" v-if="course.courseRecord.year == new Date().getFullYear()">上传课件</mu-button>
                    <mu-button @click="sendEmail(course.courseRecord.recordId)" v-if="course.courseRecord.year == new Date().getFullYear()">群发邮件</mu-button>
                    <mu-button @click="postHomework(course.courseRecord.recordId)" v-if="course.courseRecord.year == new Date().getFullYear()">发布作业</mu-button>
                    <mu-button @click="postGrade(course.courseRecord.recordId)" v-if="course.courseRecord.year == new Date().getFullYear()">发布成绩</mu-button>
                    <mu-button @click="downloadHomework(course.courseRecord.recordId)" color="primary">下载作业</mu-button>
                </div>
            </mu-expansion-panel>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "AdminCourse",
        data () {
            return {
                courses: []
            }
        },
        methods: {
            sendEmail(id) {
                this.$router.push("/teacher/sendEmail/"+id);
            },
            postHomework(id) {
                this.$router.push("/teacher/postHomework/"+id);
            },
            uploadCourseware(id) {
                this.$router.push("/teacher/uploadCourseware/"+id);
            },
            postGrade(id) {
                this.$router.push("/teacher/postGrade/"+id);
            },
            downloadHomework(id) {
                this.$router.push("/teacher/downloadHomework/"+id);
            }
        },
        created: function() {
            this.$axios.post("/api/course/getCourseDetailList", {
                id: window.$state.loginId
            }).then(res => {
                console.log(res.data);
                this.courses = res.data;
            });
        }
    }
</script>

<style scoped>
    .course-from {
        width: 100%;
        max-width: 800px;
        margin: 80px auto;
    }
    span {
        color: red;
    }
</style>
