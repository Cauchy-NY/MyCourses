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
                <div slot="action" flat>
                    <mu-button @click="lookupHomework(course.courseRecord.recordId)">查看作业</mu-button>
                    <mu-button @click="downloadCourseware(course.courseRecord.recordId)">查看课件</mu-button>
                    <mu-button color="primary" @click="quitCourse(course.courseRecord.recordId)">退课</mu-button>
                    <mu-button color="primary" @click="lookupGrade(course.courseRecord.recordId)">查看成绩</mu-button>
                </div>
            </mu-expansion-panel>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "MyCourse",
        data () {
            return {
                courses: []
            }
        },
        methods: {
            quitCourse(id) {
                this.$axios.post("/api/course/quitCourse", {
                    "selection": {
                        studentId: window.$state.loginId,
                        courseRecordId: id,
                        grade: 0
                    }
                }).then(res => {
                    console.log(res.data);
                    this.courses = res.data;
                    // refresh
                    this.$axios.post("/api/course/getSelectedCourse", {
                        id: window.$state.loginId
                    }).then(res => {
                        // console.log(res.data);
                        this.courses = res.data;
                    });
                });
            },
            downloadCourseware(id) {
                this.$router.push("/student/downloadCourseware/"+id);
            },
            lookupHomework(id) {
                this.$router.push("/student/lookupHomework/"+id);
            },
            lookupGrade(id) {
                this.$axios.post("/api/course/getGrade", {
                    userId: window.$state.loginId,
                    recordId: id
                }).then(res => {
                    console.log(res.data);
                    if (res.data === 0.0) {
                        this.$alert('成绩还未公布，请耐心等待', '成绩查看', {
                            okLabel: '知道了'
                        }).then(() => {
                            this.$toast.message('提示信息');
                        });
                    } else {
                        this.$alert('你的成绩是 '+res.data+" 分!", '成绩查看', {
                            okLabel: '知道了'
                        }).then(() => {
                            this.$toast.message('提示信息');
                        });
                    }
                });
            }
        },
        created: function() {
            this.$axios.post("/api/course/getSelectedCourse", {
                id: window.$state.loginId
            }).then(res => {
                // console.log(res.data);
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
