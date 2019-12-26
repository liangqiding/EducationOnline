new Vue({
    el: "#table",
    data: {
        msg: '',
        mycourseAndChapter: {},
        course: {},
        videolist: {        //获取课程信息
        },
        courselist: [],
    },
    created: function () {
        window.findAll = this.findAll;
        this.findAll();
        this.active();
        this.selectCourse();
        this.selectCourseAndChapter();
        this.state();
    },
    methods: {
        //获取课程视频子课程 课程目录信息
        findAll: function (course_cha_id) {
            var _this = this;
            axios.get('/AIChapter', {
                params: {
                    course_cha_id: course_cha_id
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
        //切换视频
        active: function (cha_id,c_chapter_id) {
            var _this = this;
            if (c_chapter_id==null){
                c_chapter_id=$("#c_chapter_id").val();
            }
            axios.get('/AVideo', {
                params: {
                    cha_id: cha_id,
                    c_chapter_id:c_chapter_id
                }
            })
                .then(function (value) {
                    // alert("aaa"+value.data.cha_date)
                    _this.videolist = value.data;
                    $("#listmy").hide();
                    $("#video").show();
                    $("#kc").show();
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取单个课程视频信息
        selectCourse: function (c_chapter_id) {

            var _this = this;
            if (c_chapter_id != null) {
                _this.state("学习中心");
                _this.findAll(c_chapter_id);
                _this.active(null,c_chapter_id);
            } else {
                var c_chapter_id = $("#c_chapter_id").val();
            }

            axios.get('/SelectCourse', {
                params: {
                    c_chapter_id: c_chapter_id
                }
            })
                .then(function (value) {
                    // alert("aaa"+value.data.cha_date)
                    _this.course = value.data;
                    _this.findAll(c_chapter_id);

                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取课程和子课程信息
        selectCourseAndChapter: function () {
            var _this = this;
            axios.get('/SelMyCourseAndChapter', {
                params: {}
            })
                .then(function (value) {
                    // alert("aaa"+value.data.cha_date)
                    _this.mycourseAndChapter = value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },//获取状态
        state: function (sta) {
            var _this = this;
            if (sta==null){
              var sta=$("#msg").val();
            }
            axios.get('/VideoState', {
                params: {
                    sta: sta,
                }
            })
                .then(function (value) {
                    _this.msg = value.data;
                    _this.selectCourseAndChapter();
                    var s = value.data;
                    if (s == '我的课程') {
                        $("#video").hide();
                        $("#kc").hide();
                        $("#listmy").show();
                    } else {
                        $("#listmy").hide();
                        $("#video").show();
                        $("#kc").show();

                    }
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        DelMyCourse: function (c_chapter_id) {
            var msg="您确定要删除吗？删除后，您的学习进度将不会保存！！"
            if (confirm(msg)) {

            }else {
                return false;
            }
            var _this = this;
            axios.get('/DelMycourse', {
                params: {
                    c_chapter_id: c_chapter_id,
                }
            })
                .then(function (value) {
                    alert(value.data);
                    _this.selectCourseAndChapter();
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
    }
})


