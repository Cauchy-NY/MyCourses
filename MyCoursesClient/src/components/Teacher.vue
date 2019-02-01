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
                        <mu-list-item button @click="goToAdmin">
                            <mu-list-item-content>
                                <mu-list-item-title>管理课程</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                        <mu-list-item button @click="goToCreate">
                            <mu-list-item-content>
                                <mu-list-item-title>创建课程</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                        <mu-list-item button @click="goToPost">
                            <mu-list-item-content>
                                <mu-list-item-title>发布课程</mu-list-item-title>
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
                <mu-button icon slot="right" @click="goToTeacherDetail">
                    <img src="../assets/teacher.png" alt="">
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
        name: "Teacher",
        data() {

        },
        methods: {
            goToPost() {
                this.$router.push("/teacher/postCourse")
            },
            goToAdmin() {
                this.$router.push("/teacher/adminCourse")
            },
            goToCreate() {
                this.$router.push("/teacher/createCourse")
            },
            goToTeacherDetail() {
                this.$router.push("/teacher/teacherDetail")
            },
            goToForum() {
                this.$router.push("/teacher/forum")
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
        color: white;
    }
</style>
