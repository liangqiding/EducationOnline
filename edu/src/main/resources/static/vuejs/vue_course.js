new Vue({
    el:"#course",
    data:{
        searchmsg:'',
        mycourselist:[],
        pagelist: {},
        courselist:[],
        pagelist2:[],
    },
    created:function () {
        this.findAll();
        this.page1(1);
        this.SelMyCourse();
    },
    methods:{
        //获取课程信息
        findAll:function (course_name) {
            var _this = this;
            axios.get('/Course', {
                params: {
                    course_name: course_name,
                }
            })
                .then(function (value) {

                    _this.courselist=value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //控制分页-翻页 返回课程内容
        page:function(pageNum) {
            if (pageNum<=0){return false;}
            var _this = this;
            axios.get('/Course', {
                params: {
                    pageNum: pageNum
                }
            })
                .then(function (value) {
                    _this.courselist=value.data;
                    _this.page1(pageNum);
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //获取页面数量  返回分页按钮显示信息
        page1:function (pageNum) {
            if (pageNum<=0){return false;}
            var _this = this;
            axios.get('/page1', {
                params: {
                    pageNum: pageNum
                }
            })
                .then(function (value) {
                    _this.pagelist=value.data;
                    // alert("page1成功了!");
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
    //    添加课程AddMyCourse
        AddMyCourse:function (c_chapter_id) {
            var _this = this;
            axios.get('/AddMyCourse', {
                params: {
                    c_chapter_id: c_chapter_id
                }
            })
                .then(function (value) {
                   alert(value.data);
                   _this.SelMyCourse();
                   console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //   我的课程
        SelMyCourse:function () {
            var _this = this;
            axios.get('/SelMyCourse', {
                params: {
                }
            })
                .then(function (value) {
                    _this.mycourselist=value.data;
                    // if(value.data.mycourselist==null){alert("空值!");}

                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        //搜索课程
        search:function (searchmsg){
            var _this=this;
            this.findAll(searchmsg);
            this.page1(1);
            axios.get('/page1', {
                params: {
                    pageNum: 1
                }
            })
                .then(function (value) {
                    _this.pagelist2=value.data;
                    console.log(value);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        returns:function (){
            var _this = this;
            axios.get('/return', {
                params: {
                }
            })
                .then(function (value) {
                    // if(value.data.mycourselist==null){alert("空值!");}
                    console.log(value);
                    _this.pagelist2='';
                    _this.findAll();
                    _this.page1(1);
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
    }
})



// vue1.findAll(66)

