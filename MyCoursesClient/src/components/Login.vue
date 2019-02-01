<template>
    <div id="login">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <mu-container>
            <h2>MyCourses</h2>
            <div class="logo">
                <img src="../assets/logo.png" alt="">
            </div>
            <mu-form ref="form" :model="dataForm" class="login-form">
                <mu-form-item label="南京大学邮箱" help-text="不需要填写后缀哦:-D" prop="id" :rules="idRules">
                    <mu-text-field v-model="dataForm.id" prop="id" suffix="@smail.nju.edu.cn"></mu-text-field>
                </mu-form-item>
                <mu-form-item label="密码" prop="password" :rules="passwordRules">
                    <mu-text-field type="password" v-model="dataForm.password" prop="password"></mu-text-field>
                </mu-form-item>
                <mu-form-item class="button-form">
                    <mu-button color="primary" @click="loginClick">登录</mu-button>
                    <mu-button @click="goToRegister">注册</mu-button>
                </mu-form-item>
            </mu-form>
        </mu-container>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                idRules: [
                    { validate: (val) => !!val, message: '必须填写邮箱'},
                    // { validate: (val) => val.length >= 3, message: '用户名长度大于3'}
                ],
                passwordRules: [
                    { validate: (val) => !!val, message: '必须填写密码'},
                    // { validate: (val) => val.length >= 3 && val.length <= 10, message: '密码长度大于3小于10'}
                ],
                // argeeRules: [{ validate: (val) => !!val, message: '必须同意用户协议'}],
                dataForm: {
                    id: '',
                    password: '',
                    // isAgree: false
                }
            }
        },
        methods: {
            loginClick () {
                if (this.dataForm.id === "admin") {
                    if (this.dataForm.password === "admin") {
                        this.$router.replace({path:'/admin'})
                    } else {
                        alert("用户名或密码错误")
                    }
                } else {
                    this.$axios.post("/api/user/login", {
                        "id": this.dataForm.id,
                        "password": this.dataForm.password
                    }).then(res => {
                        if (res.data.message === "fail") {
                            alert("用户名或密码错误")
                        } else {
                            // console.log(res.data);
                            // console.log(res.data.type);
                            window.$state.login(res.data.id, res.data.type);

                            if (res.data.type === "student")
                                this.$router.replace({path:'/student'});
                            else
                                this.$router.replace({path:'/teacher'});
                        }
                    })
                }
            },
            goToRegister () {
                this.$router.replace({path:'/register'})
            }
        }
    };
</script>
<style>
    .logo {
        width: 200px;
        height: 250px;
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
    .login-form {
        width: 100%;
        max-width: 460px;
        margin-left: auto;
        margin-right: auto;
    }
    .button-form {
        margin: 0 auto;
        width: 210px;
    }
</style>
