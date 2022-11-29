<template>
  <div class="navbar">
    <i class="el-icon-s-operation" id="switch"></i>
    <p>{{ routeName }}</p>
    <div class="navbar-item-blank-center"></div>
  </div>
</template>

<script>
export default {
  name: "Navbar",
  computed: {
    routeName() {
      const route = this.$route;
      const { meta } = route;
      return meta.name;
    },
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
  display: flex;
  justify-content: start;
  align-items: center;
}

#switch {
  padding: 0 15px;
  font-size: 20px;
}

#switch :hover {
  cursor: pointer;
}

.collapse-icon {
  padding: 0 15px;
}

.collapse-icon:hover {
  cursor: pointer;
}

.navbar p {
  color: #97a8be;
}

/*菜单栏空项*/

.navbar .navbar-item-blank-center {
  flex-grow: 1;
  padding: 0 20px;
}

.el-dropdown {
  margin-right: 20px;
  outline: none;
}

.dropdown-link i:hover {
  cursor: pointer;
}
</style>
