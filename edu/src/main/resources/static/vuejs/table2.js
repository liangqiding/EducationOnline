new Vue({
    el:"#table2",
    data:{
        pagelist: {
        },
        courselist:[],
    },
    created:function () {
        this.findAll(-1);
    },
    methods:{
        //获取课程信息
        findAll:function (cha_id) {
            var _this = this;
            axios.get('/AMChapter', {
                params: {
                    cha_id: cha_id
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
        del:function (cha_id) {
            var msg = "您真的确定要删除吗？\n\n请确认！";
            if (confirm(msg)==true){
                this.findAll(cha_id)
            }else{
                return false;
            }

        }

    }
})



// vue1.findAll(66)

