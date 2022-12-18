<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <el-row> 输入要查询的电影名称： </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入电影名称"
              prefix-icon="el-icon-search"
              v-model="value"
            >
            </el-input>
          </el-row>
          <br />
          <el-button type="info" @click="search">开始搜索</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="film_time_new.film_name" label="电影名称">
        </el-table-column>
        <el-table-column prop="film_time_new.vision" label="电影版本"> </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: "", //查询饿电影名称
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search() {
      console.log(this.value);
      this.$axios({
        url: "/SearchByFilmName",
        method: "post",
        data: vm.value,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
        for (let item of res.data.result) {
          vm.tableData.push(item);
        }
      });
    },
  },
};
</script>

<style scoped>
.stockcost_container {
  margin-top: 10px;
  margin-left: 10px;
  margin-right: 10px;
}
</style>
