new Vue({
    el: "#tables",
    data: {
        courselist:{},
        class_All:{},
    },
    created: function () {
        this.findAll();
        this.getClass();
    },
    methods: {
        //获取视频
        findAll: function () {
            var _this = this;
            axios.get('/manage/GetCourseByUser', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.courselist = value.data;
                    console.log(value);
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
        //删除课程
        del: function (course_id) {
            var _this = this;
            var msg="您真的要删除该章节吗";
            if(confirm(msg)) {
                axios.get('/manage/DelCourse', {
                    params: {
                        course_id: course_id
                    }
                })
                    .then(function (value) {
                        alert(value.data)
                        _this.findAll();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
            }
        },

        // 截取当前数据到小数点后两位
        numFilter(value) {
            const realVal = parseFloat(value).toFixed(2);
            return realVal;
        },

    }
})


// vue1.findAll(66)

