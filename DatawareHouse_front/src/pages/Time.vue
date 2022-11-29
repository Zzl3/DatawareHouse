<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12" :xs="24">
        <el-card>
          <el-row> 选择要查询的日期： </el-row>
          <br />
          <div class="block">
            <el-date-picker
              v-model="specitime"
              type="datetime"
              placeholder="选择日期时间"
              align="right"
              :picker-options="pickerOptions1"
            >
            </el-date-picker>
          </div>
          <br />
          <el-button type="info" @click="search">开始搜索</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
      <el-col :span="12" :xs="24">
        <el-card>
          <el-row> 选择要查询的日期范围： </el-row>
          <br />
          <div class="block">
            <el-date-picker
              v-model="duringtime"
              type="datetimerange"
              :picker-options="pickerOptions2"
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              align="right"
            >
            </el-date-picker>
          </div>
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
      tableData: [],
      pickerOptions1: {
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            },
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            },
          },
          {
            text: "一周前",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", date);
            },
          },
        ],
      },
      pickerOptions2: {
        shortcuts: [
          {
            text: "最近一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            },
          },
          {
            text: "最近一个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit("pick", [start, end]);
            },
          },
          {
            text: "最近三个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit("pick", [start, end]);
            },
          },
        ],
      },
      specitime: "", //这里是选择特定的日期
      duringtime: "", //这是选择日期范围
      count: 0, //这是返回数据的条数
    };
  },
  created() {},
  methods: {
    search() {
      console.log(this.specitime);
      console.log(this.duringtime);
    }, //点击按钮触发搜索方法
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
