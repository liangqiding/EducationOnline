new Vue({
    el: "#mylike",
    data: {
        //列表
        vipList: {},
        userList: {},
    },
    created: function () {
        this.getVipList();
        this.getUser();

    },
    methods: {
        //获取VIP
        getVipList: function () {
            var _this = this;
            axios.get('/vip/getVipList', {
            })
                .then(function (value) {
                    _this.vipList = value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        //获取User
        getUser: function () {
            var _this = this;
            axios.get('/vip/GetUserMain', {
            })
                .then(function (value) {
                    _this.userList = value.data;
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

