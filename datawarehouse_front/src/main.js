// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import * as echarts from 'echarts';
Vue.config.productionTip = false
Vue.prototype.$echarts = echarts
import axios from 'axios';

//设置端口
Vue.prototype.$axios = axios
axios.defaults.baseURL = 'http://localhost:8443/api'





Vue.use(ElementUI);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
