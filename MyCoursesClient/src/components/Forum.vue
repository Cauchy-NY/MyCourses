<template>
    <div>
        <mu-paper :z-depth="1" class="demo-list-wrap">
            <mu-list textline="three-line">
                <div v-for="discussion in discussions" :key="discussion.id">
                    <mu-list-item avatar :ripple="false" @click="goToDetail(discussion.id)" button>
                        <mu-list-item-action>
                            <mu-avatar>
                                <img v-if="discussion.userType === 'student'" src="../assets/student.png">
                                <img v-if="discussion.userType === 'teacher'" src="../assets/teacher.png">
                            </mu-avatar>
                        </mu-list-item-action>
                        <mu-list-item-content>
                            <mu-list-item-title>{{discussion.title}}</mu-list-item-title>
                            <mu-list-item-sub-title>
                                <span style="color: rgba(0, 0, 0, .87)">{{discussion.userId}}@smail.nju.edu.cn -</span> {{discussion.content}}
                            </mu-list-item-sub-title>
                        </mu-list-item-content>
                    </mu-list-item>
                    <mu-divider></mu-divider>
                </div>
                <mu-container>
                    <mu-form :model="dataForm" :label-position="labelPosition" label-width="100">
                        <mu-form-item prop="input" label="主题">
                            <mu-text-field v-model="dataForm.title" placeholder="输入帖子主题"></mu-text-field>
                        </mu-form-item>
                        <mu-form-item prop="textarea" label="内容">
                            <mu-text-field multi-line :rows="3" :rows-max="6" v-model="dataForm.content" placeholder="输入帖子内容"></mu-text-field>
                        </mu-form-item>
                        <mu-form-item prop="button" align="center">
                            <mu-button @click="reset">重置</mu-button>
                            <mu-button color="primary" @click="postNew">发布</mu-button>
                        </mu-form-item>
                    </mu-form>
                </mu-container>
            </mu-list>
        </mu-paper>
    </div>
</template>

<script>
    export default {
        name: "Forum",
        data() {
            return {
                discussions: [],
                labelPosition: 'right',
                dataForm: {
                    id: '',
                    userId: window.$state.loginId,
                    userType: window.$state.loginType,
                    title: '',
                    content:'',
                    seq: 1,
                    ansTo: 0,
                    hasTitle: true
                }
            }
        },
        methods: {
            goToDetail(id) {
                this.$router.push("/"+window.$state.loginType+"/discussion/"+id);
            },
            reset() {
                this.dataForm = {
                    id: '',
                    userId: window.$state.loginId,
                    userType: window.$state.loginType,
                    title: '',
                    content:'',
                    seq: 1,
                    ansTo: 0,
                    hasTitle: true
                }
            },
            postNew() {
                this.dataForm.id = new Date().getTime();
                this.$axios.post("/api/discussion/insertDiscussion", {
                    discussion: this.dataForm
                }).then(res => {
                    // console.log(res.data)
                    if (res.data === 'success') {
                        alert('发布成功');
                        this.reset();
                        this.$axios.post("/api/discussion/getPostList").then(res => {
                            // console.log(res.data);
                            this.discussions = res.data;
                        });
                    } else {
                        alert('发布失败，好像出了点问题orz')
                    }
                });
            }
        },
        created: function() {
            this.$axios.post("/api/discussion/getPostList").then(res => {
                // console.log(res.data);
                this.discussions = res.data;
            });
        }
    }
</script>

<style scoped>

</style>
