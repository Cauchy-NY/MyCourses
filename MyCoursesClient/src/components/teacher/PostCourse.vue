<template>
    <div>
        <mu-container>
            <mu-form :model="dataForm" class="post-form" :label-position="labelPosition" label-width="100">
                <mu-form-item prop="select" label="已创建课程">
                    <mu-select v-model="dataForm.courseId">
                        <mu-option v-for="option,index in courses" :key="option.courseId" :label="option.courseName" :value="option.courseId"></mu-option>
                    </mu-select>
                </mu-form-item>
                <mu-form-item prop="select" label="选择学期">
                    <mu-select v-model="dataForm.semester">
                        <mu-option v-for="option,index in semesters" :key="option" :label="option" :value="option"></mu-option>
                    </mu-select>
                </mu-form-item>
                <mu-form-item prop="select" label="选择学年">
                    <mu-select v-model="dataForm.year">
                        <mu-option v-for="option,index in years" :key="option" :label="option" :value="option"></mu-option>
                    </mu-select>
                </mu-form-item>
                <mu-form-item prop="radio" label="选择班次">
                    <mu-radio v-model="dataForm.classes" value="一班" label="一班"></mu-radio>
                    <mu-radio v-model="dataForm.classes" value="二班" label="二班"></mu-radio>
                    <mu-radio v-model="dataForm.classes" value="全部" label="全部"></mu-radio>
                </mu-form-item>
                <mu-form-item prop="switch" label="是否限制人数">
                    <mu-switch v-model="dataForm.isNumLimited"></mu-switch>
                </mu-form-item>
                <mu-form-item prop="textarea" label="选课说明">
                    <mu-text-field multi-line :rows="4" :rows-max="6" v-model="dataForm.state"></mu-text-field>
                </mu-form-item>
                <mu-form-item prop="button">
                    <mu-button @click="reset">重置</mu-button>
                    <mu-button color="primary" @click="postCourse">发布课程</mu-button>
                </mu-form-item>
            </mu-form>
        </mu-container>
    </div>
</template>

<script>
    export default {
        name: "PostCourse",
        data () {
            return {
                courses: [],
                years: [
                    '2020', '2019', '2018', '2017', '2016', '2015'
                ],
                semesters: [
                    'Spring', 'Summer', 'Winter'
                ],
                labelPosition: 'left',
                dataForm: {
                    courseId: '',
                    semester: '',
                    year: '',
                    classes: '',
                    isNumLimited: false,
                    state: ''
                }
            }
        },
        methods: {
            reset() {
                // console.log(this.dataForm.course);
                this.dataForm = {
                    recordId:'',
                    courseId: '',
                    semester: '',
                    year: '',
                    classes: '',
                    isNumLimited: false,
                    state: ''
                };
                // console.log(this.dataForm)
            },
            postCourse() {
                console.log(this.dataForm);

                this.$axios.post("/api/course/insertCourseRecord", {courseRecord: this.dataForm})
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
        },
        created: function() {
            this.$axios.post("/api/course/getCourseList", {
                id: window.$state.loginId
            }).then(res => {
                console.log(res.data);
                this.courses = res.data;
            });
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
