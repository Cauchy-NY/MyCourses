<template>
    <div class="course-from">
        <p v-if="courseList.length == 0 && courseRecordList.length == 0">暂时无需要审批项目</p>
        <mu-container class="container-from">
            <mu-expansion-panel v-for="course in courseList" :key="course.courseId">
                <div slot="header">
                    申请创建课程
                </div>
                <div>
                    课程名称: {{course.courseName}}<br>
                    老师邮箱: {{course.teacherId}}@smail.nju.edu.cn<br>
                    课程说明: {{course.courseDes}}<br>
                    预计每次开课人数: {{course.courseNum}}<br>
                </div>
                <div slot="action" flat >
                    <mu-button @click="approvalCourse(course.courseId)" color="primary">审批通过</mu-button>
                </div>
            </mu-expansion-panel>
        </mu-container>
        <mu-container>
            <mu-expansion-panel v-for="courseRecord in courseRecordList" :key="courseRecord.recordId">
                <div slot="header">
                    申请开课
                </div>
                <div>
                    开课编号: {{courseRecord.recordId}}<br>
                    班级限制: {{courseRecord.classes}}<br>
                    选课说明: {{courseRecord.state}}<br>
                    开课学期: {{courseRecord.year}}-{{courseRecord.semester}}<br>
                    是否限制人数: {{courseRecord.numLimited}}<br>
                </div>
                <div slot="action" flat >
                    <mu-button @click="approvalCourseRecord(courseRecord.recordId)" color="primary">审批通过</mu-button>
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
                courseList: [],
                courseRecordList: []
            }
        },
        methods: {
            approvalCourse(id) {
                this.$axios.post("/api/course/updateCourse", {
                    id: id
                }).then(res => {
                    console.log(res.data);
                    if (res.data === "success") {
                        alert("审批成功");
                        this.$axios.post("/api/course/getUnapprovalList").then(res => {
                            this.courseList = res.data.courseList;
                            this.courseRecordList = res.data.courseRecordList;
                            console.log(this.courseList);
                            console.log(this.courseRecordList);
                        });
                    } else {
                        alert("好像出了一点问题orz");
                    }
                });
            },
            approvalCourseRecord(id) {
                this.$axios.post("/api/course/updateCourseRecord", {
                    id: id
                }).then(res => {
                    console.log(res.data);
                    if (res.data === "success") {
                        alert("审批成功");
                        this.$axios.post("/api/course/getUnapprovalList").then(res => {
                            this.courseList = res.data.courseList;
                            this.courseRecordList = res.data.courseRecordList;
                            console.log(this.courseList);
                            console.log(this.courseRecordList);
                        });
                    } else {
                        alert("好像出了一点问题orz");
                    }
                });
            }
        },
        created: function() {
            this.$axios.post("/api/course/getUnapprovalList").then(res => {
                this.courseList = res.data.courseList;
                this.courseRecordList = res.data.courseRecordList;
                console.log(this.courseList);
                console.log(this.courseRecordList);
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
    .container-from {
        margin-bottom: 20px;
    }
    span {
        color: red;
    }
</style>
