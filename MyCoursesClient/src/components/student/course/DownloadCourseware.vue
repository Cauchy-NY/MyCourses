<template>
    <div class="main-form">
        <mu-container>
            <mu-paper :z-depth="1">
                <mu-data-table selectable select-all :selects.sync="selects" checkbox :columns="columns" :data="coursewares">
                    <template slot-scope="scope">
                        <td>{{scope.row}}</td>
                    </template>
                </mu-data-table>
                <mu-flex align-items="center" style="padding: 8px;" wrap="wrap">
                    selects: <mu-chip delete v-for="selectIndex in selects" @delete="removeSelect(selectIndex)" style="margin: 8px;" color="green" :key="selectIndex">{{coursewares[selectIndex]}}</mu-chip>
                </mu-flex>
            </mu-paper>
        </mu-container>
        <mu-button class="button-form" @click="downloadCourseware">下载</mu-button>
    </div>
</template>

<script>
    export default {
        name: "DownloadCourseware",
        data() {
            return {
                coursewares:[],
                selects: [],
                columns: [
                    { title: '文件名', width: 400, name: 'name' }
                ]
            }
        },
        methods: {
            downloadCourseware() {
                for (var index in this.selects) {
                    this.$axios.post("/api/file/downloadCourseware", {
                        "id": this.$route.params.id,
                        "type": "courseware",
                        "name": this.coursewares[index]
                    }, {responseType: 'arraybuffer'}).then(res => {
                        // console.log(res.data);
                        console.log("download===",res);
                        const blob = new Blob([res]);
                        if (window.navigator.msSaveOrOpenBlob) {
                            // 兼容IE10
                            navigator.msSaveBlob(blob, this.coursewares[index]);
                        } else {
                            //  chrome/firefox
                            let aTag = document.createElement('a');
                            aTag.download = this.coursewares[index];
                            aTag.href = URL.createObjectURL(blob);
                            aTag.click();
                            URL.revokeObjectURL(aTag.href);
                        }
                    })
                }
            },
            removeSelect (selectIndex) {
                const index = this.selects.indexOf(selectIndex);
                this.selects.splice(index, 1);
            }
        },
        created: function() {
            this.$axios.post("/api/file/getCourseware", {
                id: this.$route.params.id
            }).then(res => {
                console.log(res.data);
                this.coursewares = res.data;
            });
        }
    }
</script>

<style scoped>
    .main-form {
        width: 100%;
        max-width: 500px;
        margin: 80px auto;
    }
    .button-form {
        margin-top: 50px;
        max-width: 50px;
    }
</style>
