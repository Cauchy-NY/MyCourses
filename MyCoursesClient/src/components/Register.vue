<template>
    <div id="login">
        <mu-container>
            <h2>MyCourses</h2>
            <div class="logo">
                <img src="../assets/logo.png" alt="">
            </div>
            <mu-form ref="form" :model="dataForm" class="login-form">
                <mu-form-item label="邮箱" help-text="南京大学邮箱" prop="id" :rules="idRules">
                    <mu-text-field v-model="dataForm.id" prop="id" suffix="@smail.nju.edu.cn"></mu-text-field>
                </mu-form-item>
                <mu-form-item label="密码" prop="password" :rules="passwordRules">
                    <mu-text-field type="password" v-model="dataForm.password" prop="password"></mu-text-field>
                </mu-form-item>
                <mu-form-item label="选择身份" prop="radio" class="radio-from">
                    <mu-radio v-model="dataForm.type" value="student" label="学生"></mu-radio>
                    <mu-radio v-model="dataForm.type" value="teacher" label="老师"></mu-radio>
                </mu-form-item>
                <mu-form-item label="验证码" prop="verificationCode" :rules="verificationCodeRules">
                    <mu-text-field v-model="dataForm.verificationCode" prop="verificationCode"></mu-text-field>
                </mu-form-item>
                <mu-form-item class="button-form">
                    <mu-button color="primary" @click="submit">注册</mu-button>
                    <mu-button @click="sendVerificationCode">获取验证码</mu-button>
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
                    { validate: (val) => !!val, message: '必须填写邮箱'}
                ],
                passwordRules: [
                    { validate: (val) => !!val, message: '必须填写密码'}
                ],
                verificationCodeRules: [
                    { validate: (val) => !!val, message: '必须填写正确验证码'}
                ],
                dataForm: {
                    id: '',
                    password: '',
                    verificationCode: '',
                    type:'',
                    encoded:''
                }
            }
        },
        methods: {
            submit () {
                console.log(this.dataForm);
                this.$axios.post("/api/user/register", {
                    id: this.dataForm.id,
                    password: this.dataForm.password,
                    verificationCode: this.dataForm.verificationCode,
                    type: this.dataForm.type,
                    encoded: this.dataForm.encoded
                }).then(res => {
                    console.log(res.data);
                    if (res.data.message === "success") {
                        alert("注册成功！");
                        this.$router.push("/");
                    } else {
                        alert(res.data.message);
                    }
                })
            },
            sendVerificationCode () {
                if (this.dataForm.id === '') {
                    alert("获取验证码时邮箱不能为空")
                } else {
                    this.$axios.post("/api/user/sendVerificationCode", {
                        "id": this.dataForm.id
                    }).then(res => {
                        console.log(res.data);
                        this.dataForm.encoded = res.data;
                    })
                }
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
        width: 230px;
    }
    .radio-from {
        align-content: center;
    }
</style>
