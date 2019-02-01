<template>
    <div class="content-from">
        <div id="myChart" :style="{width: '600px', height: '600px', margin: 'auto'}"></div>
    </div>
</template>

<script>
    export default {
        name: 'Statistics',
        data () {
            return {
                char: null,
                statisticData: []
            }
        },
        methods: {
            drawLine(){
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart'));
                // 绘制图表
                myChart.setOption({
                    title: { text: '                                My course 网站使用统计' },
                    tooltip: {},
                    xAxis: {
                        data: ["学生人数","老师人数","课程数量","开课数量","作业数量"]
                    },
                    yAxis: {},
                    series: [{
                        name: '数量',
                        type: 'bar',
                        data: this.statisticData
                    }]
                });
            }
        },
        mounted() {
            this.$axios.post("/api/webStatistics/getWebStatistics").then(res => {
                console.log(res.data);
                this.statisticData = [res.data.studentNum, res.data.teacherNum,
                    res.data.courseNum, res.data.courseRecordNum, res.data.homeworkNum];
                // console.log(this.statisticData);
                this.drawLine()
            });
        }
    }
</script>

<style scoped>
    .content-from {
        width: 100%;
        margin-left: auto;
        margin-right: auto;
    }
</style>
