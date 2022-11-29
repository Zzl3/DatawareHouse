<template>
  <div>
    <el-row>
      <div class="Echarts">
        <div class="charts" id="table" style="width: 1500px; height: 600px"></div>
      </div>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  created() {},
  methods: {
    myEcharts() {
      var myChart = this.$echarts.init(document.getElementById("table"));
      const posList = [
        "left",
        "right",
        "top",
        "bottom",
        "inside",
        "insideTop",
        "insideLeft",
        "insideRight",
        "insideBottom",
        "insideTopLeft",
        "insideTopRight",
        "insideBottomLeft",
        "insideBottomRight",
      ];
      app.configParameters = {
        rotate: {
          min: -90,
          max: 90,
        },
        align: {
          options: {
            left: "left",
            center: "center",
            right: "right",
          },
        },
        verticalAlign: {
          options: {
            top: "top",
            middle: "middle",
            bottom: "bottom",
          },
        },
        position: {
          options: posList.reduce(function (map, pos) {
            map[pos] = pos;
            return map;
          }, {}),
        },
        distance: {
          min: 0,
          max: 100,
        },
      };
      app.config = {
        rotate: 90,
        align: "left",
        verticalAlign: "middle",
        position: "insideBottom",
        distance: 15,
        onChange: function () {
          const labelOption = {
            rotate: app.config.rotate,
            align: app.config.align,
            verticalAlign: app.config.verticalAlign,
            position: app.config.position,
            distance: app.config.distance,
          };
          myChart.setOption({
            series: [
              {
                label: labelOption,
              },
              {
                label: labelOption,
              },
              {
                label: labelOption,
              },
            ],
          });
        },
      };
      const labelOption = {
        show: true,
        position: app.config.position,
        distance: app.config.distance,
        align: app.config.align,
        verticalAlign: app.config.verticalAlign,
        rotate: app.config.rotate,
        formatter: "{c}  {name|{a}}",
        fontSize: 16,
        rich: {
          name: {},
        },
      };
      var option = {
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "shadow",
          },
        },
        legend: {
          data: ["mysql", "neo4j", "hive"],
        },
        toolbox: {
          show: true,
          orient: "vertical",
          left: "right",
          top: "center",
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ["line", "bar", "stack"] },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        xAxis: [
          {
            type: "category",
            axisTick: { show:false },
            data: ["时间查询", "电影名称查询", "导演查询", "演员查询", "电影类别查询","用户评价查询","导演演员关系查询","组合查询"],
          },
        ],
        yAxis: [
          {
            type: "value",
          },
        ],
        series: [
          {
            name: "mysql",
            type: "bar",
            barGap: 0,
            label: labelOption,
            emphasis: {
              focus: "series",
            },
            data: [320, 332, 301, 334, 390,123,345,453],
          },
          {
            name: "neo4j",
            type: "bar",
            label: labelOption,
            emphasis: {
              focus: "series",
            },
            data: [220, 182, 191, 234, 290, 390,123,345,453],
          },
          {
            name: "hive",
            type: "bar",
            label: labelOption,
            emphasis: {
              focus: "series",
            },
            data: [150, 232, 201, 154, 190, 390,123,345,453],
          },

        ],
      };
      myChart.setOption(option);
    },
  },
  mounted() {
    this.myEcharts();
  },
};
</script>

<style scoped>
.Echarts {
  width: 90%;
  display: flex;
  pedding: 20px;
}
</style>
