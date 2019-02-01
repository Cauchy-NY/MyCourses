<template>
    <div class="create-form">
        <div class="step-form">
            <mu-stepper :active-step="activeStep">
                <mu-step>
                    <mu-step-label>
                        填写课程名称
                    </mu-step-label>
                </mu-step>
                <mu-step>
                    <mu-step-label>
                        填写课程简介
                    </mu-step-label>
                </mu-step>
                <mu-step>
                    <mu-step-label>
                        宣传活动
                    </mu-step-label>
                </mu-step>
            </mu-stepper>
            <div>
                <p v-if="finished">
                    基本信息填写完成啦！只需审批通过即可发布啦！<br>
                    <mu-button flat @click="reset"> 重置 </mu-button>
                    <mu-button color="primary" @click="createCourse"> 提交审批 </mu-button>
                </p>
                <template v-if="!finished">
                    <p>
                        <mu-container v-if="activeStep === 0">
                            <mu-text-field v-model="courseName" placeholder="输入课程名称"></mu-text-field>
                        </mu-container>
                        <mu-container v-if="activeStep === 1">
                            <mu-text-field v-model="courseDes" placeholder="输入课程简介" multi-line :rows="4" :rows-max="6"></mu-text-field>
                        </mu-container>
                        <mu-container v-if="activeStep === 2">
                            <mu-text-field v-model="courseNum" type="number" placeholder="选课人数" icon="people"></mu-text-field>
                        </mu-container>
                    </p>
                    <div>
                        <mu-button flat :disabled="activeStep === 0" @click="handlePrev"> 上一步 </mu-button>
                        <mu-button color="primary" @click="handleNext"> {{activeStep === 2 ? '完成' : '下一步'}} </mu-button>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "CreateCourse",
        data () {
            return {
                activeStep: 0,
                courseName: '',
                courseDes: '',
                courseNum: '',
            };
        },
        computed: {
            finished () {
                return this.activeStep > 2;
            }
        },
        methods: {
            handleNext () {
                this.activeStep++;
            },
            handlePrev () {
                this.activeStep--;
            },
            reset () {
                this.activeStep = 0;
            },
            createCourse() {
                // console.log(this.courseName);
                // console.log(this.courseDes);
                // console.log(this.courseNum);
                // console.log(localStorage.loginId);

                this.$axios.post("/api/course/insertCourse", {course: {
                    "courseName": this.courseName,
                    "courseDes": this.courseDes,
                    "courseNum": this.courseNum,
                    "courseId": new Date().getTime(),
                    "teacherId": window.$state.loginId
                }}).then(res => {
                    // console.log(res.data)
                    if (res.data.message === "success") {
                        alert("发布成功");
                        this.reset();
                    } else {
                        alert("好像出了一点问题orz")
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .create-form {
        height: 500px;
        width: 720px;
        margin: auto;
    }
    .step-form {
        margin-top: 20%;
    }
</style>
