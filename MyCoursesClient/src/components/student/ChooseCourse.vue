<template>
    <div class="course-from">
        <mu-container>
            <mu-expansion-panel v-for="course in courses" :key="course.courseRecord.recordId">
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
                    <mu-button color="primary" @click="selectCourse(course.courseRecord.recordId)">选课</mu-button>
                </div>
            </mu-expansion-panel>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "ChooseCourse",
        data () {
            return {
                courses: []
            }
        },
        methods: {
            selectCourse(id) {
                this.$axios.post("/api/course/selectCourse", {
                    "selection": {
                        studentId: window.$state.loginId,
                        courseRecordId: id,
                        grade: 0
                    }
                }).then(res => {
                    console.log(res.data);
                    this.courses = res.data;
                    // refresh
                    this.$axios.post("/api/course/getUnselectedCourse", {
                        id: window.$state.loginId
                    }).then(res => {
                        // console.log(res.data);
                        this.courses = res.data;
                    });
                });
            }
        },
        created: function() {
            this.$axios.post("/api/course/getUnselectedCourse", {
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
