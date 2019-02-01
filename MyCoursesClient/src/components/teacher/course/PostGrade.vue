<template>
    <div>
        <template>
            <el-table
                :data="selections.filter(data => !search || selections.studentId.includes(search))"
                style="width: 100%">
                <el-table-column
                    label="学号"
                    prop="studentId">
                </el-table-column>
                <el-table-column
                    label="成绩"
                    prop="grade">
                </el-table-column>
                <el-table-column>
                    <template slot-scope="scope" v-if="isEdited === scope.$index">
                        <el-input v-model="tmpGrade" type="number"></el-input>
                    </template>
                </el-table-column>
                <el-table-column
                    align="right">
                    <template slot="header" slot-scope="scope">
                        <el-input
                            v-model="search"
                            size="mini"
                            placeholder="输入学号搜索"/>
                    </template>
                    <template slot-scope="scope">
                        <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                            size="mini"
                            type="primary"
                            @click="handleSave(scope.$index, scope.row)">保存</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-button @click="save" class="button-form">保存</el-button>
        </template>
    </div>
</template>

<script>
    export default {
        name: "PostGrade",
        data() {
            return {
                selections: [],
                search: '',
                tmpGrade: '',
                isEdited: '-1',
            }
        },
        methods: {
            handleEdit(index, row) {
                this.isEdited = index;
                console.log(index);
                console.log(row);
            },
            handleSave(index, row) {
                this.isEdited = -1;
                row.grade = this.tmpGrade;
                console.log(index);
                console.log(row.grade);
            },
            save() {
                this.$axios.post("/api/course/saveSelections", {
                    selections: this.selections
                }).then(res => {
                    console.log(res.data);
                    if (res.data === "success") {
                        alert("保存成功！");
                    } else {
                        alert("好像出了点问题orz");
                    }
                });
            }
        },
        created: function() {
            this.$axios.post("/api/course/getSelections", {
                id: this.$route.params.id
            }).then(res => {
                console.log(res.data);
                this.selections = res.data;
            });
        }
    }
</script>

<style scoped>
    .button-form {
        margin-top: 25px;
    }
</style>
