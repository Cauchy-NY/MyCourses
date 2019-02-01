<template>
    <div>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <div id="bar">
            <mu-appbar style="width: 100%;" color="primary">
                <mu-menu slot="left">
                    <mu-button flat>
                        <mu-icon value="menu"></mu-icon>
                    </mu-button>
                    <mu-list slot="content">
                        <mu-list-item button @click="goToApproval">
                            <mu-list-item-content>
                                <mu-list-item-title>审批</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                        <mu-list-item button @click="goToStatistics">
                            <mu-list-item-content>
                                <mu-list-item-title>网站统计</mu-list-item-title>
                            </mu-list-item-content>
                        </mu-list-item>
                    </mu-list>
                </mu-menu>
                My Courses
                <mu-button icon slot="right">
                    <img src="../assets/admin.png" alt="">
                </mu-button>
            </mu-appbar>
        </div>
        <div>
            <router-view/>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Admin",
        data() {
            return {

            }
        },
        methods: {
            goToApproval() {
                this.$router.push("/admin/approval")
            },
            goToStatistics() {
                this.$router.push("/admin/statistics")
            }
        }
    }
</script>

<style scoped>
    img{
        width: auto;
        height: auto;
        max-width: 200%;
        max-height: 200%;
    }
</style>
