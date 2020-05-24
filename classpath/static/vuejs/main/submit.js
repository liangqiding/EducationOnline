new Vue({
    el: "#submitA",
    data: {
        //列表
        courseList: {},
        class_All: {},
    },
    created: function () {
        this.getCourse();
        this.getClass();

    },
    methods: {
        //获取收藏
        getCourse: function () {
            var _this = this;
            axios.get('/vip/getCourseSubmit', {
            })
                .then(function (value) {
                    _this.courseList = value.data;
                })
                .catch(function (error) {
                    console.log(error);
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
        
            _this.class_All=value.data; 
        })
        .catch(function () {
            console.log("error")
        })

},
        del: function (id) {
            var _this = this;
            axios.get('/vip/delLike', {
                params:{
                    id:id,
                }
            })
                .then(function (value) {
                    alert(value.data)
                    _this.getLike();
                })
                .catch(function (error) {
                    console.log(error);
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

