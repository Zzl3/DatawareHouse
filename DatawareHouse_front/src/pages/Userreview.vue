<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <el-row> 请点击评分和选择评价的正面性： </el-row>
          <br />
          <el-row>
            <div class="block">
              <el-rate v-model="radio" :colors="colors"> </el-rate>
            </div>
          </el-row>
          <br />
          <el-row
            ><el-switch
              style="display: block"
              v-model="ifactive"
              active-color="#13ce66"
              inactive-color="#ff4949"
              active-text="积极评价"
              inactive-text="消极评价"
            >
            </el-switch
          ></el-row>
          <br />
          <el-button type="info" @click="search1">正面评价</el-button>
          <el-button type="info" @click="search2">评分筛选</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="film_name" label="电影名称"> </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'] ,
      ifactive: false, //如果是false就是消极评价，true就是积极评价
      radio: null, //评分
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search1() {
      console.log(this.ifactive);
      console.log(this.radio);
      if (this.ifactive == true) {
        this.$axios.post("/SearchByActive").then((res) => {
        for (let item of res.data) {
          vm.tableData.push(item);
        }
      });
      }
    },
    search2() {
      console.log(this.ifactive);
      console.log(this.radio);
      this.$axios({
        url: "/SearchByScore",
        method: "post",
        data: vm.radio,
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
