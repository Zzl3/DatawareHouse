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
          <el-button type="info" @click="search">开始搜索</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="film_id" label="电影id"> </el-table-column>
        <el-table-column prop="film_name" label="电影名称"> </el-table-column>
        <el-table-column prop="type" label="电影类型"> </el-table-column>
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
    search() {
      console.log(this.ifactive);
      console.log(this.radio);
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
