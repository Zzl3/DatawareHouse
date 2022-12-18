<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <el-row> 输入要查询的演员： </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入演员"
              prefix-icon="el-icon-search"
              v-model="value"
            >
            </el-input>
          </el-row>
          <br />
          <el-button type="info" @click="search1">普通电影</el-button>
          <el-button type="info" @click="search2">主演电影</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="film_name" label="电影名称"> </el-table-column>
        <el-table-column prop="star" label="电影演员"> </el-table-column>
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
    search1() {
      console.log(this.value);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios({
        url: "/SearchByStar",
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
    search2() {
      console.log(this.value);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios({
        url: "/SearchByMainStar",
        method: "post",
        data: vm.value,
        headers: {
          "Content-Type": "text/plain",
        },
      }).then((res) => {
        for (let item of res.data.result) {
          let item2 = {
            star: "",
            film_name: "",
          };
          item2.star = item.starMain
          item2.film_name=item.film_name
          console.log(item2);
          vm.tableData.push(item2);
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
