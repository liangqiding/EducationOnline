new Vue({
    el: "#tables",
    data: {
        orderlist:{},
        dateNow:''
    },
    created: function () {
        this.findAll();
    },
    methods: {
        //获取视频
        findAll: function () {
            var _this = this;
            axios.get('/manage/GetOrder', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    var day =new Date();
                    var s = day.toLocaleDateString();
                    var s1="";
                    // var reg = new RegExp("/","g");
                    if (s.length==9){
                        s1 = s.replace("/","0");
                    }else if(s.length==8){
                        s1 = s.replace("/","0");
                        s1 = s1.replace("/","0");
                    }else{
                        s1 = s.replace("/","");
                    }
                        let s2 = s1.replace("/","");
                    _this.dateNow=s2;
                    _this.orderlist = value.data;
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

