// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import MuseUI from 'muse-ui'
import 'muse-ui/dist/muse-ui.css'
import Message from 'muse-ui-message';
import 'muse-ui-message/dist/muse-ui-message.css';
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'

import echarts from 'echarts'

Vue.prototype.$echarts = echarts;

Vue.use(MuseUI);
Vue.use(ElementUI);

Vue.use(Message);

Vue.prototype.$axios = axios;

axios.defaults.headers.common["Content-Type"] = "application/x-www-dataForm-urlencoded";

Vue.config.productionTip = false;

window.$state = new Vue({
    data: {
        loginId: localStorage.loginId,
        loginType: localStorage.loginType,
        loggedIn: !!localStorage.loginType
    },
    methods: {
        login (id, type) {
            this.loginId = localStorage.loginId = id;
            this.loginType = localStorage.loginType = type;
            this.loggedIn = true;
        },
        logout () {
            delete localStorage.loginName;
            delete localStorage.loginType;
            this.loginId = '';
            this.loginType = '';
            this.loggedIn = false
        }
    }
});

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>'
});
