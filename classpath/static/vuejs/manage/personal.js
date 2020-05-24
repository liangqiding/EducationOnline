new Vue({
    el: "#tables",
    data: {
        personals:{},
    },
    created: function () {
        this.findAll();
    },
    methods: {
        //获取用户信息
        findAll: function () {
            var _this = this;
            axios.get('/manage/GetPersonal', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.personals = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
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

