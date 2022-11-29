<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <br />
          <el-row> 输入导演和演员名称： </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入导演名称"
              prefix-icon="el-icon-search"
              v-model="director"
            >
            </el-input>
          </el-row>
          <br />
          <el-row>
            <el-input
              placeholder="请输入演员名称"
              prefix-icon="el-icon-search"
              v-model="actor"
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
        <el-table-column prop="actorName" label="演员名称"> </el-table-column>
        <el-table-column prop="directorName" label="导演名称"> </el-table-column>
        <el-table-column prop="times" label="合作次数"> </el-table-column>
        <el-table-column prop="popular" label="受欢迎程度"> </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      director: "",
      actor: "",
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search() {
      //如果导演和演员都输入了，则返回联合查询
      //如果只输入导演，返回导演的全部电影和演员
      //如果只输入演员，返回导演的全部电影和导演
      //受欢迎程度大概按照之前的来
      console.log(this.director);
      console.log(this.actor);
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
