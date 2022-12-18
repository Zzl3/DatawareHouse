<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <br />
          <!-- <el-row> 输入导演和演员名称： </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入导演/演员名称"
              prefix-icon="el-icon-search"
              v-model="man1"
            >
            </el-input>
          </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入导演/演员名称"
              prefix-icon="el-icon-search"
              v-model="man2"
            >
            </el-input>
          </el-row> -->
          <br />
          <el-button type="info" @click="search1">演员-演员</el-button>
          <el-button type="info" @click="search2">演员-导演</el-button>
          <el-button type="info" @click="search3">导演-导演</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="a1" label="人名1">
        </el-table-column>
        <el-table-column prop="a2" label="人名2">
        </el-table-column>
        <el-table-column prop="amount" label="合作次数">
        </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      man1: "",
      man2: "",
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search1() {
      //如果导演和演员都输入了，则返回联合查询
      //如果只输入导演，返回导演的全部电影和演员
      //如果只输入演员，返回导演的全部电影和导演
      //受欢迎程度大概按照之前的来
      console.log(this.man1);
      console.log(this.man2);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios.post("/SearchByAA").then((res) => {
        for (let item of res.data.result) {
          vm.count = vm.count + 1;
          vm.tableData.push(item);
        }
      });
      vm.count = 0;
    },
    search2() {
      //如果导演和演员都输入了，则返回联合查询
      //如果只输入导演，返回导演的全部电影和演员
      //如果只输入演员，返回导演的全部电影和导演
      //受欢迎程度大概按照之前的来
      console.log(this.man1);
      console.log(this.man2);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios.post("/SearchByDA").then((res) => {
        for (let item of res.data.result) {
          vm.count = vm.count + 1;
          let item2 = {
            a1: "",
            a2: "",
            amount:""
          };
          item2.a1 = item.director
          item2.a2 = item.star
          item2.amount=item.amount
          vm.tableData.push(item2);
        }
      });
      vm.count = 0;
    },
    search3() {
      //如果导演和演员都输入了，则返回联合查询
      //如果只输入导演，返回导演的全部电影和演员
      //如果只输入演员，返回导演的全部电影和导演
      //受欢迎程度大概按照之前的来
      console.log(this.man1);
      console.log(this.man2);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios.post("/SearchByDD").then((res) => {
        for (let item of res.data.result) {
          let item2 = {
            a1: "",
            a2: "",
            amount:""
          };
          item2.a1 = item.d1
          item2.a2 = item.d2
          item2.amount=item.amount
          vm.tableData.push(item2);
        }
      });
      vm.count = 0;
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
