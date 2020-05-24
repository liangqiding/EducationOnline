new Vue({
    el: "#tableA",
    data: {
        //列表
        subList: {},
        size:''
    },
    created: function () {
        this.getSub();

    },
    methods: {
        //获取收藏
        getSub: function () {
            var _this = this;
            axios.get('/vip/getSub', {
            })
                .then(function (value) {
                    _this.subList = value.data;
                    _this.size = value.data.length;
                    console.log(value.data.length)
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        delSub: function (s_id) {
            var _this = this;
            axios.get('/vip/delSub', {
                params:{
                    s_id:s_id,
                }
            })
                .then(function (value) {
                    _this.getSub();
                    alert(value.data)
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
    }
})


// vue1.findAll(66)

