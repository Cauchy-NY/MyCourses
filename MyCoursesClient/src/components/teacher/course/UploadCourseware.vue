<template>
    <div class="upload-form">
        <h2>上传课件</h2>
        <el-upload drag action="" :http-request='postFile' multiple>
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
    </div>
</template>

<script>
    export default {
        name: "UploadCourseware",
        data() {
            return {
                fileList: []
            }
        },
        methods: {
            postFile(param) {
                let fileObject = param.file;
                let formData = new FormData();
                formData.append("id", this.$route.params.id);
                formData.append("file", fileObject);
                console.log(param.file);
                let config = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                };

                this.$axios.post("/api/file/uploadCourseware", formData, config).then(res => {
                    console.log(res.data);
                    if (res.data === 'success') {
                        alert('发布成功');
                    } else {
                        alert('发布失败，好像出了点问题orz')
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .upload-form {
        width: 100%;
        max-width: 500px;
        margin: 80px auto;
    }
    h2{
        font-size: 48px;
        font-weight: 400;
    }
</style>
