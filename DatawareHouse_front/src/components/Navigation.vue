<template>
  <div id="aa">
    <el-col :span="20">
      <el-menu
        text-align="right"
        router
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
      >
        <el-menu-item index="/Compare">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>查询对比</span>
          </template>
        </el-menu-item>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-user"></i>
            <span>单个查询</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/Time">按时间查询</el-menu-item>
            <el-menu-item index="/Moviename">按电影名称查询</el-menu-item>
            <el-menu-item index="/Director">按导演查询</el-menu-item>
            <el-menu-item index="/Actor">按演员查询</el-menu-item>
            <el-menu-item index="/Movietype">按电影类别查询</el-menu-item>
            <el-menu-item index="/Userreview">按用户评价查询</el-menu-item>
            <el-menu-item index="/ActorandDirector">按演员和导演关系查询</el-menu-item>
            <el-menu-item index="/Popular">按类型欢迎度查询</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="/Compose">
          <i class="el-icon-setting"></i>
          <span slot="title">组合查询</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </div>
</template>

<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>
<style scoped>
#aa {
  height: 100%;
}
</style>
