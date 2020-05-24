new Vue({
    el: "#mylike",
    data: {
        //列表
        likeList: {},
        size: {}
    },
    created: function () {
        this.getLike();
        this.getSize();

    },
    methods: {
        //获取收藏
        getLike: function () {
            var _this = this;
            axios.get('/vip/getLike', {
            })
                .then(function (value) {
                    _this.likeList = value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取收藏数量
        getSize: function () {
            var _this = this;
            axios.get('/vip/getMyLikeSize', {
            })
                .then(function (value) {
                    _this.size = value.data;
                })
                .catch(function (error) {
                    console.log(error);
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

