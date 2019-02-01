<template>
    <div>
        <mu-container>
            <mu-form :model="dataForm" class="post-form" :label-position="labelPosition" label-width="100">
                <mu-form-item prop="input" label="主题">
                    <mu-text-field v-model="dataForm.title" placeholder="输入作业主题"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="date" label="截止时间">
                    <mu-date-input v-model="dataForm.endTime" type="dateTime" actions></mu-date-input>
                </mu-form-item>
                <mu-form-item prop="textarea" label="说明">
                    <mu-text-field multi-line :rows="3" :rows-max="6" v-model="dataForm.state" placeholder="输入作业具体说明"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="button" align="center">
                    <mu-button @click="reset">重置</mu-button>
                    <mu-button color="primary" @click="postHomework">发布</mu-button>
                </mu-form-item>
            </mu-form>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "PostHomework",
        data() {
            return {
                labelPosition: 'right',
                dataForm: {
                    recordId: this.$route.params.id,
                    title: '',
                    endTime:'',
                    state:''
                }
            }
        },
        methods: {
            reset() {
                this.dataForm = {
                    recordId: this.$route.params.id,
                    title: '',
                    endTime:'',
                    state:''
                }
            },
            postHomework() {
                this.$axios.post("/api/course/insertHomework", {homework: this.dataForm})
                    .then(res => {
                        // console.log(res.data)
                        if (res.data.message === 'success') {
                            alert('发布成功');
                            this.reset();
                        } else {
                            alert('发布失败，好像出了点问题orz')
                        }
                    });
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
