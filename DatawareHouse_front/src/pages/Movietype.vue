<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <el-row> 选择查询的电影种类： </el-row>
          <br />
          <el-row>
            <el-select v-model="value" placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
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
        <el-table-column prop="film_time_new.type" label="电影类型">
        </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      method: "",
      options: [
        {
          value: "action",
          label: "动作电影",
        },
        {
          value: "adventure",
          label: "冒险电影",
        },
        {
          value: "arthoust",
          label: "艺术电影",
        },
        {
          value: "documentary",
          label: "纪实电影",
        },
        {
          value: "horror",
          label: "恐怖电影",
        },
        {
          value: "special interest",
          label: "特殊爱好电影",
        },
        {
          value: "suspense",
          label: "悬疑电影",
        },
        {
          value: "science fiction",
          label: "科幻电影",
        },
        {
          value: "animation",
          label: "动漫电影",
        },
        {
          value: "kids",
          label: "儿童电影",
        },
        {
          value: "comedy",
          label: "喜剧电影",
        },
        {
          value: "drama",
          label: "戏剧电影",
        },
        {
          value: "war",
          label: "战争电影",
        },
        {
          value: "sports",
          label: "运动电影",
        },
      ],
      value: "",
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search() {
      console.log(this.value);
      this.$axios({
            url: "/SearchByType",
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
