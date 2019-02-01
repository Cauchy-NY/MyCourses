<template>
    <div>
        <mu-container>
            <mu-form :model="dataForm" class="post-form" :label-position="labelPosition" label-width="100">
                <mu-form-item prop="input" label="主题">
                    <mu-text-field v-model="dataForm.subject" placeholder="输入邮件主题"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="textarea" label="内容">
                    <mu-text-field multi-line :rows="3" :rows-max="6" v-model="dataForm.content" placeholder="输入邮件内容"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="button" align="center">
                    <mu-button @click="reset">重置</mu-button>
                    <mu-button color="primary" @click="postEmail">发送</mu-button>
                </mu-form-item>
            </mu-form>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "SendEmail",
        data() {
            return {
                labelPosition: 'right',
                dataForm: {
                    subject: '',
                    content:''
                }
            }
        },
        methods: {
            reset() {
                this.dataForm = {
                    input: '',
                    textarea:''
                }
            },
            postEmail() {
                //todo
                console.log(this.$route.params.id);
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
