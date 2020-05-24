new Vue({
    el: "#tableA",
    data: {
        //列表
        chapter: {},
        course: {},
        chapterlist: {},
        courselist: {},
        brr:{}
    },
    created: function () {
        this.findAll();
        this.getCourse();
        this.getChapterList();
        this.getcourseList();
        //判断是否可以点赞收藏
        this.toGetLikeAndGoodLater();
        window.findAll=this.findAll;
        window.getChapterList=this.getChapterList;
    },
    methods: {
        //获取视频
        findAll: function () {
            var _this = this;
            axios.get('/vip/getVideoForVideo', {
            })
                .then(function (value) {
                    _this.chapter = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //获取课程介绍
        getCourse: function () {
            var _this = this;
            axios.get('/vip/getCourseForVideo', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.course = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //获取章节列表
        getChapterList: function () {
            var _this = this;
            axios.get('/vip/GetChapterForVideo', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.chapterlist = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //切换视频
        getVideo: function (cha_id,percent) {
            var _this = this;
            axios.get('/vip/getVideoForVideo', {
                params: {
                    cha_id: cha_id
                }
            })
                .then(function (value) {
                    _this.chapter = value.data;
                    window.go(percent);
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取推荐视频
        getcourseList: function () {
            var _this = this;
            axios.get('/vip/getCourseListForVideo', {
                params: {
                }
            })
                .then(function (value) {
                    _this.courselist = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //收藏视频
        toLike: function (course_id) {
            var _this = this;
            axios.get('/vip/toLike', {
                params: {
                    course_id:course_id,
                }
            })
                .then(function (value) {
                    alert(value.data)
                    _this.toGetLikeAndGoodLater();
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //点赞视频
        toGood: function (course_id) {
            var _this = this;
            axios.get('/vip/toGood', {
                params: {
                    course_id:course_id,
                }
            })
                .then(function (value) {
                    _this.getCourse();
                    _this.toGetLikeAndGoodLater();
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

        toSub: function (u_id) {
            var _this = this;
            axios.get('/vip/toSub', {
                params: {
                    u_id:u_id,
                }
            })
                .then(function (value) {
                    // _this.getCourse();
                    //判断是否可以点赞+收藏+关注
                    _this.toGetLikeAndGoodLater();
                    alert(value.data)
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //判断是否可以点赞+收藏+关注
        toGetLikeAndGoodLater: function (course_id) {
            var _this = this;
            axios.get('/vip/getLikeAndGoodLater', {
                params: {
                }
            })
                .then(function (value) {
                    _this.brr=value.data;
                   console.log(_this.brr[1])
                })
                .catch(function () {
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

