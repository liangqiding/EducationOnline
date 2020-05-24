new Vue({
    el: "#tables",
    data: {
        //列表
        videolist: {},
        class_All: {},
        class_id:'',
        limit: {}
    },
    created: function () {
        this.findAll();
        this.getLimit(1);
        this.getClass_id();
        this.getClass();
    },
    methods: {
        //模糊查询
        findAll: function () {
            var _this = this;
            axios.get('/main/GetCourse', {
                params: {}
            })
                .then(function (value) {
                    _this.videolist = value.data;
                    _this.getLimit(1);
                    _this.getClass_id();
                       //隐藏搜索数量显示框
                       $("#hideAA").hide();
                })
                .catch(function () {
                })

        },
        //收藏视频
        toLike: function (course_id) {
            var _this = this;
            axios.get('/vip/toLike', {
                params: {
                    course_id:course_id,
                }
            })
                .then(function (value) {
                    alert(value.data)
                    console.log(value);
                })
                .catch(function () {
                })
        },
        //搜索框
        search: function () {
            var text = $("#texts").val();
            var _this = this;
            axios.get('/main/search', {
                params: {
                    mohu: text,
                }
            })
                .then(function (value) {
                    _this.pageNext(1, 1);
                    _this.getLimit(1);
                    $("#hideAA").show()
                })
                .catch(function () {
                })

        },
        //导航栏种类选择 切换
        getClassTO: function (class_id) {
            var _this = this;
            axios.get('/main/getClassTO', {
                params: {
                    class_id: class_id,
                }
            })
                .then(function (value) {
                    _this.pageNext(1, 1);
                    _this.getLimit(1);
                    _this.getClass_id();
                })
                .catch(function () {
                })

        },
        //课程种类获取
        getClass: function () {
        
            var _this = this;
            axios.get('/main/getClass', {
                params: {
                    id:0
                }
            })
                .then(function (value) {
                    console.log("1111")
                    _this.class_All=value.data;
                    
                })
                .catch(function () {
                    console.log("error")
                })

        },
        //判断当前active
        getClass_id: function () {
            var _this = this;
            axios.get('/main/getClass_id', {
                params: {
                }
            })
                .then(function (value) {
                    _this.class_id = value.data;
                })
                .catch(function () {
                })

        },

        //返回 清楚搜索结果
        returnA: function () {
            var _this = this;
            axios.get('/main/search', {
                params: {
                }
            })
                .then(function (value) {
                    _this.findAll(1, 1);
                })
                .catch(function () {
                })

        },
        //获取翻页参数
        getLimit: function (pageNum) {
            var _this = this;
            axios.get('/main/getLimit', {
                params: {
                    pageNum: pageNum
                }
            })
                .then(function (value) {
                    _this.limit = value.data;
                })
                .catch(function () {
                })
        },
        //执行翻页
        pageNext: function (pages, pageNum) {
            if (pageNum > pages || pageNum <= 0) {
                return;
            }
            var page = pageNum;
            var _this = this;
            axios.get('/main/pageNext', {
                params: {
                    pageNum: pageNum
                }
            })
                .then(function (value) {
                    _this.videolist = value.data;
                    _this.getLimit(page);
                })
                .catch(function () {
                })
        },
        // 截取当前数据到小数点后两位
        numFilter(value) {
            const realVal = parseFloat(value).toFixed(2);
            return realVal;
        },

    }
})


// vue1.findAll(66)

