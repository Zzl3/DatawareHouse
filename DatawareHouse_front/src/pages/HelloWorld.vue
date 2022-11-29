<template>
  <el-container style="height: 750px">
    <el-aside style="width: 300px; background-color: #545c64">
      <Navigation></Navigation>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <Topnav></Topnav>
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Topnav from "../components/Topnav.vue";
import Navigation from "../components/Navigation.vue";
export default {
  components: { Navigation, Topnav },
};
</script>

<style>
.el-header {
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
