<template>
    <div>
        <div id="login">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
                  rel="stylesheet">
            <mu-container>
                <h3>个人资料</h3>
                <mu-button @click="edit">编辑</mu-button>
                <div class="logo">
                    <img src="../../assets/student.png" alt="">
                </div>
                <div class="info-form">
                    账号: {{userProfile.userId}}@smail.nju.edu.cn<br>
                    名称: {{userProfile.userName}}<br>
                    备用邮箱: {{userProfile.backupEmail}}<br>
                    宣言: {{userProfile.state}}<br>
                </div>
                <div class="button-form">
                    <mu-button @click="logout" color="primary">登出</mu-button>
                    <mu-button @click="eliminate">注销</mu-button>
                </div>
            </mu-container>
        </div>
    </div>
</template>

<script>
    export default {
        name: "StudentDetail",
        data() {
            return {
                userProfile: {}
            }
        },
        methods: {
            edit() {
                this.$router.push("/student/editStudentDetail");
            },
            eliminate() {
                this.$axios.post("/api/user/deleteUser", {
                    id: window.$state.loginId
                }).then(res => {
                    // console.log(res.data)
                    if (res.data === 'success') {
                        this.router.push("/login");
                    } else {
                        alert('注销失败，好像出了点问题orz');
                    }
                });
                this.$router.push("/");
            },
            logout() {
                window.$state.logout();
                this.$router.push("/");
            }
        },
        created: function() {
            this.$axios.post("/api/user/getUserProfile", {
                id: window.$state.loginId
            }).then(res => {
                console.log(res.data);
                this.userProfile = res.data;
            });
        }
    }
</script>

<style scoped>
    .logo {
        width: 200px;
        height: 200px;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 20px;
    }
    img{
        width: auto;
        height: auto;
        max-width: 100%;
        max-height: 100%;
    }
    h2{
        font-size: 48px;
        font-weight: 400;
    }
    .info-form {
        font-size: 25px;
        font-weight: 400;
        width: 100%;
        max-width: 460px;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 30px;
    }
    .button-form {
        margin: 20px auto;
        width: 210px;
    }
</style>
