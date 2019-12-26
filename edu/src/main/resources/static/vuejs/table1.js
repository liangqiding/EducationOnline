new Vue({
    el:"#table1",
        data:{
            pagelist: {
            },
            courselist:[],
        },
        created:function () {
            this.findAll();

        },
        methods:{
        //获取课程信息
        findAll:function () {
            var _this = this;
            axios.get('/AMCourse', {
                params: {
                    id: -2
                }
            })
                .then(function (value) {
                    _this.courselist=value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
            delC:function (c_chapter_id) {
                var _this = this;
                var msg="您真的要删除吗，删除后，改课程下所有子课程都会删除！！！";
                if(confirm(msg)){
                    //执行删除
                    axios.get('/DELCourse', {
                        params: {
                            c_chapter_id: c_chapter_id
                        }
                    })
                        .then(function (value) {
                            alert(value.data)
                            //刷新页面
                            _this.findAll();
                            console.log(value);
                        })
                        .catch(function (error) {
                            console.log(error);
                        })
                }else {
                    return false;
                }
            }
    }
})



// vue1.findAll(66)

