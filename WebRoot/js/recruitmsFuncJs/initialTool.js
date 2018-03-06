/*=====================================================================================|
 *                                                                                     |
 * description: 关初始化列表通用脚本      |
 * dependencies： load.js   fpmUtils.js  fundReport.common.js                          |
 * openSourceDependencies：jQuery v1.11.1   bootstrap.js v3  bootstrap-table           |
 * createTime:  2017/03/07                                                             |
 * author:      chenjt                                                                 |                                                                               |
 * ====================================================================================|
 */
/*
 * 初始化所有基金产品列表
 * @param {Object} resultObj Ajax查询结果返回的对象
 */
function initAllDataListTable(resultObj) {
    var result = resultObj.data;
    var opt = {
        columns: [{
                field: "number",
                title: "序号",
                formatter: function(value, row, index) {
                    return index + 1;
                }
            },
            // {
            //     field: "edit",
            //     title: "编辑",
            //     formatter: function(value, row, index) {
            //         var link = $("#basePath").val() + "/fplc/fundinfoPage!mainPage.action?LFundNo=" + row["LFundNo"] + "&lite=1";
            //         return "<a href='" + link + "' target='_blank' class='glyphicon glyphicon-pencil'></a>";
            //     }
            // },
            {
                field: "vcFundName",
                title: "基金名字",
                formatter: function(value, row, index) {
                    var link = "/AppComponent/fplc/readFundInfos.do?LFundNo=" + row["LFundNo"];
                    return "<a href='" + link + "' target='_blank'>" + value + "</a>";
                }
            }, {
                field: "CFundTypeName",
                title: "组合类型"
            }, {
                field: "domesticBankName",
                title: "托管行"
            }, {
                field: "productManagerName",
                title: "基金经理"
            }, {
                field: "acceptTime",
                title: "受理时间"
            }, {
                field: "approvedTime",
                title: "获批时间"
            }, {
                field: "fundWfnodeName",
                title: "进展情况"
            }, {
                field: "managermentFee",
                title: "管理费"
            }, {
                field: "trusteeFee",
                title: "托管费"
            }, {
                field: "salesServiceFee",
                title: "销售服务费"
            }, {
                field: "startOrgName",
                title: "发起部门"
            }, {
                field: "customerManagerName",
                title: "客户经理"
            }, {
                field: "vcCustomSource",
                title: "客户"
            }, {
                field: "vcFundSource",
                title: "资金来源及产品性质"
            }, {
                field: "enPreScale",
                title: "预期规模"
            }, {
                field: "productDeptMgrName",
                title: "产品经理"
            }
        ],
        data: []
    };
    if (result) {
        var resultData = result.resultData;
        if (FPMUtils.isArray(resultData) && !FPMUtils.isEmptyArray(resultData)) {
            opt.data = resultData;
        }
    }
    initBootstrapTable($("#all-fund-list-table"), opt);
}

//reRenderTable fundReport.common.js中定义的渲染列表的函数，以下两种情况被自动调用：
//1. 点击class属性为fplc-sp-search-btn的查询按钮时会被回调重新渲染的函数；
//2、页面刚加载成功；
function reRenderTable() {
    showLoadingModal();
    simpleQueryAndRenderTable({
        url: "/AppComponent/fplc/client/page/fundReport/ajaxGetAllFundProductList.do",
        data: {
            cFundType: "ALL"
        }
    }, [initAllFundListTable], [failLog, initAllFundListTable], [hideLoadingModal], true);
}



/*
 * 初始化`导出条件`下拉框
 */
function initExportConditionSelect() {
    var optionsObj = {
        vcFundName: "基金名字",
        CFundTypeName: "组合类型",
        domesticBankName: "托管行",
        productManagerName: "基金经理",
        acceptTime: "受理时间",
        approvedTime: "获批时间",
        fundWfnodeName: "进展情况",
        managermentFee: "管理费",
        trusteeFee: "托管费",
        salesServiceFee: "销售服务费",
        startOrgName: "发起部门",
        customerManagerName: "客户经理",
        vcCustomSource: "客户",
        vcFundSource: "资金来源及产品性质",
        enPreScale: "预期规模",
        productDeptMgrName: "产品经理"
    };
    var sort = ["vcFundName", "CFundTypeName", "domesticBankName", "productManagerName", "acceptTime", "approvedTime",
        "fundWfnodeName", "managermentFee", "trusteeFee", "salesServiceFee", "startOrgName", "customerManagerName",
        "vcCustomSource", "vcFundSource", "enPreScale", "productDeptMgrName"
    ];
    $("#fplc-sp-export-condition").html(FPMUtils.parseObjectToSelectOptionsStr(optionsObj, sort))
        .selectpicker({
            liveSearch: true,
            actionsBox: true,
            selectAllText: "勾选全部",
            deselectAllText: "取消全部"
        }).selectpicker("selectAll");
}
