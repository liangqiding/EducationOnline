new Vue({
    el: "#tables",
    data: {
        rateList:{},
        dateNow:''
    },
    created: function () {
        this.findAll();
    },
    methods: {
        //获取视频
        findAll: function () {
            var _this = this;
            axios.get('/vip/getRate', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.rateList = value.data;
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

