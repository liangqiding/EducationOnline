new Vue({
    el: "#mylike",
    data: {
        //列表
        trendsList: {},
        size:''
    },
    created: function () {
        this.getTrends();


    },
    methods: {
        //获取投稿视频
        getTrends: function () {
            var _this = this;
            axios.get('/vip/getTrends', {
            })
                .then(function (value) {
                    _this.trendsList = value.data;
                    _this.size = value.data.length;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取投稿视频数量



    }
})


// vue1.findAll(66)

