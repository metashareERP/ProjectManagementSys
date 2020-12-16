<template>  <div class="box">    <el-row :gutter="10">      <el-col :span="24">          <el-button type="primary" title="新增配置" icon="el-icon-plus"  style="margin-left:20px" @click="$refs.add.openDialog()">新增</el-button>      </el-col>    </el-row>
        <el-table :data="tableData" style="width: 100%" height="calc(100% - 110px)" border>            <el-table-column :resizable="false" type="index" label="序号" ></el-table-column>
            <el-table-column prop="Name" label=Name :resizable="false"></el-table-column>
            <el-table-column prop="enterpriseName" label=enterprise :resizable="false"></el-table-column>
            <el-table-column prop="projectName" label=project :resizable="false"></el-table-column>
            <el-table-column :resizable="false" label="操作" >                <template slot-scope="scope">                    <el-button size="mini" type="primary" title="编辑数据" icon="el-icon-edit" @click="$refs.edit.openDialog(scope.row)" v-has="'system-config-edit'">编辑</el-button>                    <el-button size="mini" type="danger" title="删除数据" icon="el-icon-delete" @click="handleToDel(scope.row.id)"v-has="'system-config-del'">删除</el-button>                </template>            </el-table-column>        </el-table>        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="searchInfo.pageNum" :page-size="searchInfo.pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total"></el-pagination>        <Add ref="add" @getTableData="getTableData" :enterpriseSelectData="enterpriseSelectData" :projectSelectData="projectSelectData" ></Add>
        <Edit ref="edit" @getTableData="getTableData" :enterpriseSelectData="enterpriseSelectData" :projectSelectData="projectSelectData" ></Edit>    </div></template>

<script>import Add from './add';import Edit from './edit';
export default {        components: { Add, Edit },    data() {        return {                      searchInfo: {                               pageNum: 1,                pageSize: 10,            },            tableData: [],            total: 0,
            enterpriseSelectData:[],
            projectSelectData:[],
        };    },    created() {        this.getTableData();
        this.getenterpriseSelectData();
        this.getprojectSelectData();
    },    methods: {
        async getTableData() {
           const res = await this.$axios.post('generate/a/list', this.searchInfo);
            if (res.data.code == 0) {                this.tableData = res.data.data;                this.total = res.data.total;            }        },
        async getenterpriseSelectData() {
           const res = await this.$axios.post( 'generate/enterprise/allList', {});
            if (res.data.code == 0) {                this.enterpriseSelectData = res.data.data;            }        },
        async getprojectSelectData() {
           const res = await this.$axios.post( 'generate/project/allList', {});
            if (res.data.code == 0) {                this.projectSelectData = res.data.data;            }        },
        handleToDel(id) {            this.$confirm('确定删除吗？', '提示', {                confirmButtonText: '确定',                cancelButtonText: '取消',                type: 'warning'            })                .then(async () => {
           const res = await this.$axios.post('generate/a/del', { id });
           if (res.data.code == 0) {                        this.$message.success('删除成功');                        this.getTableData();                    } else {                        this.$message.error(`${res.data.msg}`);                    }                })                .catch(() => {                    this.$message.info('已取消删除');                });        },        handleSizeChange(pageSize) {            this.searchInfo.pageSize = pageSize;            this.getTableData();        },        handleCurrentChange(pageNum) {            this.searchInfo.pageNum = pageNum;            this.getTableData();        }
    }};</script><style lang="less" scoped>.el-table {    margin-top: 20px;}.el-pagination {    text-align: center;    margin-top: 20px;}</style>