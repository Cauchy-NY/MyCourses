<template>
    <div>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <div id="bar">
            <mu-appbar style="width: 100%;" color="primary">
                <mu-menu slot="left">
                    <mu-button flat>
                        <mu-icon value="menu"></mu-icon>
                    </mu-button>
                    <mu-list slot="content">
                        <mu-list-item button @click="goToMyCourse">
                            <mu-list-item-content>
                                <mu-list-item-title>我的课程</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                        <mu-list-item button @click="goToChoose">
                            <mu-list-item-content>
                                <mu-list-item-title>选择课程</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                        <mu-list-item button @click="goToForum">
                            <mu-list-item-content>
                                <mu-list-item-title>论坛</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                    </mu-list>
                </mu-menu>
                My Courses
                <mu-button icon slot="right" @click="goToStudentDetail">
                    <img src="../assets/student.png" alt="">
                </mu-button>
            </mu-appbar>
        </div>
        <div>
            <router-view/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Student",
        data() {

        },
        methods: {
            goToMyCourse() {
                this.$router.push("/student/myCourse")
            },
            goToChoose() {
                this.$router.push("/student/chooseCourse")
            },
            goToStudentDetail() {
                this.$router.push("/student/studentDetail")
            },
            goToForum() {
                this.$router.push("/student/forum")
            }
        }
    }
</script>

<style scoped>
    img{
        width: auto;
        height: auto;
        max-width: 200%;
        max-height: 200%;
    }
</style>
