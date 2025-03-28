const base = {
    get() {
        return {
            url : "http://localhost:8080/kuandaiyewuguanlixitong/",
            name: "kuandaiyewuguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/kuandaiyewuguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "宽带业务管理系统"
        } 
    }
}
export default base
