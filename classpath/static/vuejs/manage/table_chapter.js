new Vue({
    el: "#tables",
    data: {
        chapterlist: {},
        courseList:{},
        chapter: {},
        class_All: {},
    },
    created: function () {
        this.findAll();
        this.GetCourseid();
        this.getVideo();
        this.getClass();
    },
    methods: {
        //获取视频
        findAll: function () {
            var _this = this;
            axios.get('/manage/GetChapterByCourse_id', {
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
         //课程种类获取
getClass: function () {
    var _this = this;
    axios.get('/main/getClass', {
        params: {
            id:0
        }
    })
        .then(function (value) {
        
            _this.class_All=value.data; 
        })
        .catch(function () {
            console.log("error")
        })

},
        //获取课程id
        GetCourseid: function () {
            var _this = this;
            axios.get('/manage/GetCourse', {
                params: {
                    id: 0
                }
            })
                .then(function (value) {
                    _this.courseList = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //获取视频
        getVideo: function (cha_id) {
            var _this = this;
            axios.get('/manage/getVideo', {
                params: {
                    cha_id: cha_id
                }
            })
                .then(function (value) {
                    _this.chapter = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        //删除章节
        del: function (cha_id) {
            var _this = this;
            var msg="您真的要删除该章节吗";
            if(confirm(msg)) {
                axios.get('/manage/del_chapter', {
                    params: {
                        cha_id: cha_id
                    }
                })
                    .then(function (value) {
                        alert(value.data)
                        _this.findAll();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
            }
        },

        numFilter(value) {
            const realVal = parseFloat(value).toFixed(2);
            return realVal;
        },

    }
})


// vue1.findAll(66)

