<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="24" :xs="24">
        <el-card>
          <el-row> 输入要查询的电影信息： </el-row>
          <br />
          <el-row>
            <el-row :gutter="20">
              <el-col :span="6" :xs="24">
                <el-input
                  placeholder="请输入电影名称"
                  prefix-icon="el-icon-search"
                  v-model="moviename"
                ></el-input>
              </el-col>
              <el-col :span="6" :xs="24">
                <el-input
                  placeholder="请输入演员名字"
                  prefix-icon="el-icon-search"
                  v-model="actor"
                ></el-input>
              </el-col>
              <el-col :span="6" :xs="24">
                <el-input
                  placeholder="请输入导演名字"
                  prefix-icon="el-icon-search"
                  v-model="director"
                ></el-input>
              </el-col>
              <el-col :span="6" :xs="24">
                <el-select v-model="movietype" placeholder="请选择电影种类">
                  <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  >
                  </el-option>
                </el-select>
              </el-col>
            </el-row>
            <br />
            <el-row> 选择要查询的评分和是否是积极评价： </el-row>
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
            <el-row :gutter="5">
              <el-col :span="24" :xs="24">
                <el-row> 输入要查询的年份： </el-row>
                <br />
                <el-input
                  placeholder="请输入年份"
                  prefix-icon="el-icon-search"
                  v-model="year"
                ></el-input>
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
                <br />
                <el-button type="info" @click="search">开始搜索</el-button>
                <p>共计{{ count }}条查询结果</p>
              </el-col>
            </el-row>
          </el-row>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column prop="film_name" label="电影名称">
        </el-table-column>
        <el-table-column prop="film_year" label="电影日期"> </el-table-column>
        <el-table-column prop="director" label="电影导演">
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
      colors: ["#99A9BF", "#F7BA2A", "#FF9900"],
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
      year: "",
      moviename: "",
      movietype: "",
      actor: "",
      director: "",
      duringtime: "",
      radio: null,
      ifactive: false,
      count: 0,
      tableData: [],
    };
  },
  created() {},
  methods: {
    search() {
      console.log(this.moviename);
      console.log(this.movietype);
      console.log(this.actor);
      console.log(this.director);
      console.log(this.year);
      console.log(this.radio);
      console.log(this.ifactive);
      let vm = this;
      vm.tableData = undefined;
      vm.tableData = new Array(); //先清空再进行筛选
      if (vm.year != "" && vm.director != "") {
        this.$axios
          .post("/SearchByTD", {
            year: vm.year,
            director: vm.director,
          })
          .then((res) => {
            for (let item of res.data.result) {
              vm.count = vm.count + 1;
              vm.tableData.push(item);
            }
          });
      } else if (vm.year != "" && vm.movietype != "") {
        this.$axios
          .post("/SearchByTT", {
            year: vm.year,
            type: vm.movietype,
          })
          .then((res) => {
            for (let item of res.data.result) {
              vm.count = vm.count + 1;
              vm.tableData.push(item);
            }
          });
      }
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
