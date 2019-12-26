new Vue({
    el:"#register",
        data:{
            msg:'',
        },
        created:function () {

        },
        methods:{
        //获取课程信息
            test:function () {
              var username =$("#form-username").val();
            var _this = this;
            axios.get('/RigTest', {
                params: {
                    username: username
                }
            })
                .then(function (value) {
                    if(value.data!=null){
                        _this.msg=value.data;
                    }
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
    }
})



// vue1.findAll(66)

