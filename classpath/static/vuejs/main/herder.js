new Vue({
    el: "#herdA",
    data: {
        //列表
        user: {},
        personal:{},
        vip:''
    },
    created: function () {
        this.getUser();
        this.getVip();
        this.findPersonal();

    },
    methods: {
        //
        //获取用户信息
        findPersonal: function () {
            var _this = this;
            axios.get('/manage/GetPersonal', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.personal = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        getUser: function () {
            var _this = this;
            axios.get('/main/getUser', {
            })
                .then(function (value) {
                    if (value.data==null){
                        window.location.href="/login";
                    }else
                    _this.user = value.data;
                    if (_this.user.r_id!=1){
                        $("#admin").hide()
                        $("#admin2").hide()
                        $("#admin3").hide()
                        $("#admin4").hide()
                    }
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        getVip: function () {
            var _this = this;
            axios.get('/main/getVip', {
            })
                .then(function (value) {
                    _this.vip = value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //搜索框
        search2: function () {
            var text = $("#texts").val();
            var _this = this;
            window.location.href="/index?name="+text;
        },
        // 截取当前数据到小数点后两位
        numFilter(value) {
            const realVal = parseFloat(value).toFixed(2);
            return realVal;
        },
    }
})


// vue1.findAll(66)

