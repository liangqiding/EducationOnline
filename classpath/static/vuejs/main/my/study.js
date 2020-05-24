new Vue({
    el: "#tableA",
    data: {
        //列表
        studyList: {},
    },
    created: function () {
        this.getStudy();

    },
    methods: {
        //获取收藏
        getStudy: function () {
            var _this = this;
            axios.get('/vip/getStudy', {
            })
                .then(function (value) {
                    _this.studyList = value.data;
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

