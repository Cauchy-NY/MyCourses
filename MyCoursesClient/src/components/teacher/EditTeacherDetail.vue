<template>
    <div>
        <mu-container>
            <mu-form :model="dataForm" class="post-form" :label-position="labelPosition" label-width="100">
                <mu-form-item prop="input" label="名称">
                    <mu-text-field v-model="dataForm.userName" placeholder="输入名称"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="input" label="备用邮箱">
                    <mu-text-field v-model="dataForm.backupEmail" placeholder="输入备用邮箱"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="textarea" label="宣言">
                    <mu-text-field multi-line :rows="3" :rows-max="6" v-model="dataForm.state" placeholder="输入个人宣言"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="button" align="center">
                    <mu-button @click="reset">重置</mu-button>
                    <mu-button color="primary" @click="postHomework">确定</mu-button>
                </mu-form-item>
            </mu-form>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "EditTeacherDetail",
        data() {
            return {
                labelPosition: 'right',
                dataForm: {
                    userId: window.$state.loginId,
                    userName: '',
                    backupEmail:'',
                    state:''
                }
            }
        },
        methods: {
            reset() {
                this.dataForm = {
                    userId: window.$state.loginId,
                    userName: '',
                    backupEmail:'',
                    state:''
                }
            },
            postHomework() {
                this.$axios.post("/api/user/updateUserProfile", {userProfile: this.dataForm})
                    .then(res => {
                        // console.log(res.data)
                        if (res.data === 'success') {
                            alert('发布成功');
                            this.reset();
                        } else {
                            alert('发布失败，好像出了点问题orz');
                        }
                    });
                this.$router.push("/teacher");
            }
        }
    }
</script>

<style scoped>
    .post-form {
        width: 100%;
        max-width: 500px;
        margin: 80px auto;
    }
</style>
