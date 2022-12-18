<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="12" :xs="24">
        <el-card>
          <el-row> 选择要查询的年份： </el-row>
          <br />
          <div class="block">
            <!-- <el-date-picker
              v-model="specitime"
              type="datetime"
              placeholder="选择日期时间"
              align="right"
              :picker-options="pickerOptions1"
            >
            </el-date-picker> -->
            <el-input
              placeholder="输入日期年份"
              prefix-icon="el-icon-search"
              v-model="year"
            >
            </el-input>
            <el-input placeholder="输入星期" prefix-icon="el-icon-search" v-model="week">
            </el-input>
            <el-input placeholder="输入月份" prefix-icon="el-icon-search" v-model="month">
            </el-input>
          </div>
          <br />
          <el-button type="info" @click="search1">开始搜索</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
      <el-col :span="12" :xs="24">
        <el-card>
          <el-row> 选择要查询的年份和季度： </el-row>
          <br />
          <!-- <div class="block">
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
          </div> -->
          <el-input
            placeholder="输入日期年份"
            prefix-icon="el-icon-search"
            v-model="year"
          >
          </el-input>
          <br />
          <el-input
            placeholder="输入日期季度"
            prefix-icon="el-icon-search"
            v-model="section"
          >
          </el-input>
          <br />
          <el-button type="info" @click="search2">开始搜索</el-button>
          <p>共计{{ count }}条查询结果</p>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="film_time_new.film_name" label="年份"> </el-table-column>
        <el-table-column prop="film_time_new.film_month" label="月份"> </el-table-column>
        <el-table-column prop="film_time_new.film_day" label="日份"> </el-table-column>
        <el-table-column prop="film_time_new.film_week" label="星期"> </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      // pickerOptions1: {
      //   shortcuts: [
      //     {
      //       text: "今天",
      //       onClick(picker) {
      //         picker.$emit("pick", new Date());
      //       },
      //     },
      //     {
      //       text: "昨天",
      //       onClick(picker) {
      //         const date = new Date();
      //         date.setTime(date.getTime() - 3600 * 1000 * 24);
      //         picker.$emit("pick", date);
      //       },
      //     },
      //     {
      //       text: "一周前",
      //       onClick(picker) {
      //         const date = new Date();
      //         date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
      //         picker.$emit("pick", date);
      //       },
      //     },
      //   ],
      // },
      // pickerOptions2: {
      //   shortcuts: [
      //     {
      //       text: "最近一周",
      //       onClick(picker) {
      //         const end = new Date();
      //         const start = new Date();
      //         start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
      //         picker.$emit("pick", [start, end]);
      //       },
      //     },
      //     {
      //       text: "最近一个月",
      //       onClick(picker) {
      //         const end = new Date();
      //         const start = new Date();
      //         start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
      //         picker.$emit("pick", [start, end]);
      //       },
      //     },
      //     {
      //       text: "最近三个月",
      //       onClick(picker) {
      //         const end = new Date();
      //         const start = new Date();
      //         start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
      //         picker.$emit("pick", [start, end]);
      //       },
      //     },
      //   ],
      // },
      year: "", //这里是选择特定的日期
      week: "",
      month: "",
      section: "", //这是选择日期
      count: 0, //这是返回数据的条数
    };
  },
  created() {},
  methods: {
    search1() {
      //按照年份查询
      console.log(this.year);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      if (this.year != "") {
        if (this.month != "") {
          this.$axios
            .post("/SearchByYearMonth", {
              year: vm.year,
              month: vm.month,
            })
            .then((res) => {
              for (let item of res.data.result) {
                vm.tableData.push(item);
              }
            });
        } else {
          this.$axios({
            url: "/SearchByYear",
            method: "post",
            data: vm.year,
            headers: {
              "Content-Type": "text/plain",
            },
          }).then((res) => {
            for (let item of res.data.result) {
              console.log(item)
              vm.tableData.push(item);
            }
          });
        }
      } else if (week != "") {
        this.$axios({
          url: "/SearchByWeek",
          method: "post",
          data: vm.week,
          headers: {
            "Content-Type": "text/plain",
          },
        }).then((res) => {
          for (let item of res.data.result) {
            vm.tableData.push(item);
          }
        });
      }
    }, //点击按钮触发搜索方法
    search2() {
      console.log(this.year);
      console.log(this.section);
      let vm = this;
      // console.log(this.date[0].split("-")[0]);
      // console.log(this.date[1].split("-")[0]);
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      this.$axios
        .post("/SearchByYearSeason", {
          year: vm.year,
          season: vm.section,
        })
        .then((res) => {
          for (let item of res.data) {
            vm.tableData.push(item);
          }
        });
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
