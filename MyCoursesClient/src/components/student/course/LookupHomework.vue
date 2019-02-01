<template>
    <div class="course-from">
        <mu-container>
            <mu-expansion-panel v-for="homework in homeworks" :key="homework.id">
                <div slot="header">
                    {{homework.title}}
                    <span v-if="new Date(homework.endTime).getTime() < new Date().getTime()" color="red">
                        已截止
                    </span><br>
                    截止日期: {{new Date(homework.endTime).getFullYear()}}-{{new Date(homework.endTime).getMonth()+1}}-{{new Date(homework.endTime).getDate()+1}} {{new Date(homework.endTime).getHours()}}:{{new Date(homework.endTime).getMinutes()}}
                </div>
                <div>
                    {{homework.state}}
                </div>
                <div slot="action" flat v-if="new Date(homework.endTime).getTime() > new Date().getTime()">
                    <el-upload action="" :http-request='postFile' :file-list="fileList">
                        <el-button size="small" type="primary">点击上传</el-button>
                        <div slot="tip" class="el-upload__tip">单件上传，且不超过1024kb</div>
                    </el-upload>
                </div>
            </mu-expansion-panel>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "LookupHomework",
        data () {
            return {
                homeworks: [],
                fileList: []
            }
        },
        methods: {
            postFile(param) {
                let fileObject = param.file;
                let formData = new FormData();
                formData.append("id", window.$state.loginId);
                formData.append("recordId", this.$route.params.id);
                formData.append("file", fileObject);
                console.log(formData);
                let config = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                };

                this.$axios.post("/api/file/uploadHomework", formData, config).then(res => {
                    console.log(res.data);
                    if (res.data === 'success') {
                        alert('发布成功');
                    } else {
                        alert('发布失败，好像出了点问题orz')
                    }
                });
            }
        },
        created: function() {
            this.$axios.post("/api/course/getHomework", {
                id: this.$route.params.id
            }).then(res => {
                // console.log(res.data);
                this.homeworks = res.data;
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
