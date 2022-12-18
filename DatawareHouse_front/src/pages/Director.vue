<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <el-row> 输入要查询的导演： </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入导演名字"
              prefix-icon="el-icon-search"
              v-model="director"
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
        <el-table-column prop="film_name" label="电影名称">
        </el-table-column>
        <el-table-column prop="director" label="电影导演">
        </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      director: "",
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search() {
      console.log(this.director);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios({
        url: "/SearchByDirector",
        method: "post",
        data: vm.director,
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
