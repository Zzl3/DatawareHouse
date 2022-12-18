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
        <el-table-column prop="film_name" label="电影名称">
        </el-table-column>
        <el-table-column prop="type" label="电影类型">
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
          value: "Action",
          label: "动作电影",
        },
        {
          value: "Adventure",
          label: "冒险电影",
        },
        {
          value: "Fantasy",
          label: "艺术电影",
        },
        {
          value: "Documentaries",
          label: "纪实电影",
        },
        {
          value: "Horror",
          label: "恐怖电影",
        },
        {
          value: "Suspense",
          label: "悬疑电影",
        },
        {
          value: "Science Fiction",
          label: "科幻电影",
        },
        {
          value: "Anime",
          label: "动漫电影",
        },
        {
          value: "Kids",
          label: "儿童电影",
        },
        {
          value: "Comedy",
          label: "喜剧电影",
        },
        {
          value: "Manga",
          label: "奇幻电影",
        },
        {
          value: "Drama",
          label: "戏剧电影",
        },
        {
          value: "War",
          label: "战争电影",
        },
        {
          value: "Sports",
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
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
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
