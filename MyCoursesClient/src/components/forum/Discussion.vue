<template>
    <div>
        <mu-paper :z-depth="1" class="demo-list-wrap">
            <mu-list textline="three-line">
                <mu-sub-header>{{this.discussions[0].title}}</mu-sub-header>
                <div v-for="discussion in discussions" :key="discussion.id">
                    <mu-list-item avatar :ripple="false" @click="reply(discussion.seq)" button>
                        <mu-list-item-action>
                            <mu-avatar>
                                <img v-if="discussion.userType === 'student'" src="../../assets/student.png">
                                <img v-if="discussion.userType === 'teacher'" src="../../assets/teacher.png">
                            </mu-avatar>
                        </mu-list-item-action>
                        <mu-list-item-content>
                            <mu-list-item-title>
                                <span style="color: rgba(0, 0, 0, .87)" v-if="discussion.ansTo !== 0">回复{{discussion.ansTo}}楼 </span>
                                {{discussion.content}}
                            </mu-list-item-title>
                            <mu-list-item-sub-title>
                                <span style="color: rgba(0, 0, 0, .87)">{{discussion.seq}}楼 -</span> {{discussion.userId}}@smail.nju.edu.cn
                            </mu-list-item-sub-title>
                        </mu-list-item-content>
                    </mu-list-item>
                    <mu-divider></mu-divider>
                </div>
                <mu-container>
                    <mu-form :model="dataForm" :label-position="labelPosition" label-width="100">
                        <mu-form-item prop="textarea" label="回复">
                            <mu-text-field multi-line :rows="3" :rows-max="6" v-model="dataForm.content" placeholder="输入回复内容"></mu-text-field>
                        </mu-form-item>
                        <mu-form-item prop="button" align="center">
                            <mu-button @click="reset">重置</mu-button>
                            <mu-button color="primary" @click="postReply(0)">回复</mu-button>
                        </mu-form-item>
                    </mu-form>
                </mu-container>
            </mu-list>
        </mu-paper>
    </div>
</template>

<script>
    export default {
        name: "Discussion",
        data() {
            return {
                discussions: [],
                labelPosition: 'right',
                dataForm: {
                    id: this.$route.params.id,
                    userId: window.$state.loginId,
                    userType: window.$state.loginType,
                    title: '',
                    content:'',
                    seq: 1,
                    ansTo: 0,
                    hasTitle: false
                }
            }
        },
        methods: {
            reset() {
                this.dataForm = {
                    id: this.$route.params.id,
                    userId: window.$state.loginId,
                    userType: window.$state.loginType,
                    title: '',
                    content:'',
                    seq: 1,
                    ansTo: 0,
                    hasTitle: false
                }
            },
            reply(seq) {
                this.$prompt('快速回复 '+seq+' 楼', '回复')
                    .then(({ result, value }) => {
                    if (result) {
                        this.dataForm.content = value;
                        this.postReply(seq);
                        this.$toast.message('你输入的回复：' + value);
                    } else {
                        this.$toast.message('点击了取消');
                    }
                });
            },
            postReply(ansTo) {
                this.dataForm.seq = this.discussions.length+1;
                this.dataForm.ansTo = ansTo;
                this.$axios.post("/api/discussion/insertDiscussion", {
                    discussion: this.dataForm
                }).then(res => {
                    // console.log(res.data)
                    if (res.data === 'success') {
                        alert('发布成功');
                        this.reset();
                        this.$axios.post("/api/discussion/getPostDetail", {
                            id: this.$route.params.id
                        }).then(res => {
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
            this.$axios.post("/api/discussion/getPostDetail", {
                id: this.$route.params.id
            }).then(res => {
                // console.log(res.data);
                this.discussions = res.data;
            });
        }
    }
</script>

<style scoped>

</style>
