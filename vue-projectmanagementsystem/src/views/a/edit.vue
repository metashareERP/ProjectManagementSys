<template>
  <el-dialog title="编辑" :visible.sync="editDialogVisible" :close-on-click-modal="false" width="30%" :before-close="handleToClose">
    <el-form ref="editForm" :model="editForm" :rules="rules" label-width="80px" >
      <el-form-item label="Name" prop="Name">
        <el-input v-model.trim="editForm.Name" placeholder="请输入内容" maxlength="50" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="project" prop="project">
        <el-select v-model="editForm.projectId" placeholder="请选择" >
            <el-option v-for="item in projectSelectData" :key="item.id" :label="item.Name" :value="item.id">
            </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="enterprise" prop="enterprise">
        <el-select v-model="editForm.enterpriseId" placeholder="请选择" >
            <el-option v-for="item in enterpriseSelectData" :key="item.id" :label="item.Name" :value="item.id">
            </el-option>
        </el-select>
      </el-form-item>
      <div class="dialog-footer">        <el-button type="text" @click="handleToClose">取 消</el-button>        <el-button type="primary" @click="handleToUpdate">确 定</el-button>      </div>    </el-form>  </el-dialog></template>

<script>export default {    props:['projectSelectData','enterpriseSelectData',],    data() {        return {            editDialogVisible: false,            editForm: {
                Name:'',
                projectId: '',
                projectName: '',
                enterpriseId: '',
                enterpriseName: '',
                id:''
            },
            rules: {
            },
        };
    },
    created() {},
    methods: {
        openDialog(row) {            this.editDialogVisible = true;
            this.editForm.Name = row.Name;
            this.editForm.projectId = row.projectId;
            this.editForm.projectName = row.projectName;
            this.editForm.enterpriseId = row.enterpriseId;
            this.editForm.enterpriseName = row.enterpriseName;
            this.editForm.id = row.id;		        },        handleToClose() {            this.editDialogVisible = false;            this.$refs.editForm.resetFields();        },        async handleToUpdate() {
           const res = await this.$axios.post('generate/a/update', this.editForm);
           if (res.data.code == 0) {                        this.$message.success(`${res.data.data}`);                        this.$emit('getTableData');                        this.handleToClose();                    } else {                        this.$message.error(`${res.data.data}`);                        this.handleToClose();                    }        },
    }};</script><style lang="less" scoped>/deep/.el-input-number .el-input__inner {    text-align: left;}.dialog-footer {    text-align: right;}.el-select {    width: 100%;}.el-date-editor.el-input,.el-date-editor.el-input__inner {    width: 100%;}</style>