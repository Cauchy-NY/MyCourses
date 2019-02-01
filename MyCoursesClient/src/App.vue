<!-- 模板：html结构 -->
<template>
    <div id="app">
        <div class="main">
            <router-view/>
        </div>

        <div class="footer">
            <footer>&copy; 2019 Cauchy-Ny.</footer>
        </div>
    </div>
</template>
<!-- 行为：处理逻辑 -->
<script>
    import Login from './components/Login'
    export default {
        name: 'App',
        data: {

        },
        components: {
            "login": Login
        }
    }
</script>
<!-- 样式：解决样式 -->
<style scoped>
    html,body {
        height: 100%;
        width:100%;
        position: absolute;
    }
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 0px;
        height: 100vh;
    }
</style>
