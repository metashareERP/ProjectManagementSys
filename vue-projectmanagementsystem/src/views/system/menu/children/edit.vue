<!--
 * @Author: Misaka.chen
 * @Date: 2020-01-19 10:21:57
 * @LastEditors  : Misaka.chen
 * @LastEditTime : 2020-01-19 15:53:25
 * @Description: 修改菜单的表单
 * @Version: 1.0
 -->
<template>
    <el-dialog title="修改菜单" :visible.sync="addMenuDialogVisible" width="600" :before-close="handleToClose" :close-on-click-modal="false">
        <!-- <el-form ref="typeForm" :model="typeForm" label-width="80px" disabled>
      <el-row>
        <el-col :span="12">
          <el-form-item label="类型">
            <el-radio-group v-model="typeForm.type" style="margin-bottom: 30px;">
              <el-radio-button label="0">菜单</el-radio-button>
              <el-radio-button label="1">按钮</el-radio-button>
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form> -->
        <!-- 菜单表单 -->
        <el-form ref="form" :model="form" :rules="rules" label-width="80px" v-show="typeForm.type == '0'">
            <el-form-item label="是否显示">
                <el-radio-group v-model="form.isShow">
                    <el-radio-button id="system-menu-edit-yes" label="1">是</el-radio-button>
                    <el-radio-button id="system-menu-edit-no" label="0">否</el-radio-button>
                </el-radio-group>
            </el-form-item>
            <el-form-item v-if="form.type == '0'" label="图标">
                <el-popover placement="bottom-start" width="450" trigger="click" @show="$refs['iconSelect'].reset()">
                    <IconSelect ref="iconSelect" @selected="selected" />
                    <el-input slot="reference" v-model="form.icon" style="width: 100%;" placeholder="点击选择图标" readonly>
                        <svg-icon v-if="form.icon" slot="prefix" :icon-class="form.icon" class="el-input__icon" style="height: 32px;width: 16px;" />
                        <i v-else slot="prefix" class="el-icon-search el-input__icon" />
                    </el-input>
                </el-popover>
            </el-form-item>
            <el-form-item label="名称" prop="name" v-if="form.type == '0'">
                <el-input id="system-menu-edit-name" v-model.trim="form.name" placeholder="请输入名称" maxlength="8" show-word-limit></el-input>
            </el-form-item>
            <el-form-item label="路由地址" prop="url" v-if="form.type == '0'">
                <el-input id="system-menu-edit-url" v-model.trim="form.url" placeholder="请输入路由地址" maxlength="100" show-word-limit>
                    <template slot="prepend">/</template>
                </el-input>
            </el-form-item>
            <el-form-item label="顺序" prop="sort" v-if="form.type == '0'">
                <el-input-number id="system-menu-edit-sort" v-model.number="form.sort" :min="0" controls-position="right" style="width: 100%;"></el-input-number>
                <!-- <el-input v-model.number="form.sort" type="number" :min="0" :max="999"></el-input> -->
            </el-form-item>
            <el-form-item label="菜单">
                <treeselect id="system-menu-edit-menu" v-model="form.menu" :options="menuData.children" :normalizer="normalizer" placeholder="点击选择菜单,默认为一级菜单" />
            </el-form-item>
            <el-form-item label="备注" prop="remark">
                <el-input id="system-menu-edit-remark" v-model.trim="form.remark" placeholder="请输入备注" type="textarea" rows="5" maxlength="100" show-word-limit resize="none"></el-input>
            </el-form-item>
        </el-form>
        <!-- 按钮表单 -->
        <el-form ref="btnForm" :model="btnForm" :rules="btnFormRules" label-width="80px" v-show="typeForm.type == '1'">
            <el-form-item label="按钮类型" prop="btn">
                <el-radio v-model="btnForm.btnType" v-for="item in btnTypeList" :key="item.id" :label="item.id">{{item.name}}</el-radio>
            </el-form-item>
            <el-form-item label="按钮标识" prop="btn">
                <el-input v-model="btnForm.btn" placeholder="请输入按钮标识" maxlength="30" show-word-limit></el-input>
            </el-form-item>
            <el-form-item label="菜单">
                <treeselect v-model="btnForm.menu" :options="menuData.children" :normalizer="normalizer" placeholder="点击选择菜单,默认为一级菜单" />
            </el-form-item>
            <el-form-item label="备注" prop="remark">
                <el-input v-model="btnForm.remark" placeholder="请输入备注" type="textarea" rows="5" maxlength="100" show-word-limit resize="none"></el-input>
            </el-form-item>
        </el-form>
        <div class="dialog-footer">
            <el-button id="system-menu-edit-cancel" type="text" @click="handleToClose">取 消</el-button>
            <el-button id="system-menu-edit-save" type="primary" @click="handleToSave">确 定</el-button>
        </div>
    </el-dialog>
</template>

<script>
import Treeselect from '@riophae/vue-treeselect';
import '@riophae/vue-treeselect/dist/vue-treeselect.css';
import IconSelect from '@/components/common/IconSelect';

export default {
    components: {
        Treeselect,
        IconSelect
    },
    data() {
        var checkMenuName = (rule, value, callback) => {
            let data = {};
            data.menuName = this.form.name;
            data.menuId = this.form.id;
            data.type = '0';
            data.menuParentId = this.form.menu == null ? 1 : this.form.menu;
            this.$axios.post('sys/menu/checkMenuName', data).then((res) => {
                if (res.data.code != 0) {
                    callback(new Error('菜单名称已存在'));
                    this.addForm.dicName = '';
                } else {
                    callback();
                }
            });
        };
        var checkUrlName = (rule, value, callback) => {
            let data = {};
            data.url = this.form.url;
            data.menuId = this.form.id;
            data.menuParentId = this.form.menu == null ? 1 : this.form.menu;
            this.$axios.post('sys/menu/checkUrl', data).then((res) => {
                if (res.data.code != 0) {
                    callback(new Error('路由地址已存在'));
                    this.addForm.dicName = '';
                } else {
                    callback();
                }
            });
        };
        return {
            // 控制新增菜单的显示与隐藏 默认隐藏
            addMenuDialogVisible: false,
            // 菜单数据
            menuData: [],
            typeForm: {
                type: '0'
            },
            // 新增菜单的表单
            form: {
                // 菜单类型 0=>菜单 1=>按钮
                type: '0',
                // 菜单名称
                name: '',
                // 路由地址
                url: '',
                // 菜单是否显示 1=>显示 0=>不显示
                isShow: '1',
                // 父节点
                menu: null,
                // 菜单icon
                icon: '',
                // 按钮标识
                btn: '',
                // 菜单排序
                sort: 0,
                // 备注
                remark: '',
                // 当前id
                id: ''
            },
            btnForm: {
                // 菜单类型 0=>菜单 1=>按钮
                type: '1',
                // 按钮类型
                btnType: '',
                // 按钮标识
                btn: '',
                // 父节点
                menu: null,
                // 备注
                remark: '',
                id: ''
            },
            rules: {
                name: [
                    {
                        required: true,
                        message: '请输入菜单名称',
                        trigger: 'blur'
                    },
                    {
                        validator: checkMenuName,
                        trigger: 'blur'
                    }
                ],
                url: [
                    {
                        required: true,
                        message: '请输入路由地址',
                        trigger: 'blur'
                    },
                    // 自定义正则验证
                    // {
                    //     pattern: /^[a-zA-Z_-]+$/,
                    //     message: 'url只能输入字母和-'
                    // },
                    {
                        validator: checkUrlName,
                        trigger: 'blur'
                    }
                ],
                sort: [
                    {
                        required: true,
                        message: '请输入顺序',
                        trigger: 'blur'
                    }
                ],
                remark: [
                    {
                        required: false,
                        message: '请输入备注',
                        trigger: 'blur'
                    }
                ]
            },
            btnFormRules: {
                btn: [
                    {
                        required: true,
                        message: '请输入按钮标识',
                        trigger: 'blur'
                    }
                ],
                btnType: [
                    {
                        required: true,
                        message: '请选择按钮类型',
                        trigger: 'change'
                    }
                ],
                remark: [
                    {
                        required: false,
                        message: '请输入备注',
                        trigger: 'blur'
                    }
                ]
            },
            // 按钮类型
            btnTypeList: [
                {
                    id: '0',
                    name: '新增'
                },
                {
                    id: '1',
                    name: '编辑'
                },
                {
                    id: '2',
                    name: '删除'
                },
                {
                    id: '3',
                    name: '搜索'
                },
                {
                    id: '4',
                    name: '发布'
                },
                {
                    id: '5',
                    name: '查看'
                },
                {
                    id: '6',
                    name: '导出'
                },
                {
                    id: '7',
                    name: '重置密码'
                },
                {
                    id: '8',
                    name: '菜单授权'
                },
                {
                    id: '9',
                    name: '按钮授权'
                },
                {
                    id: '10',
                    name: '数据授权'
                }
            ]
        };
    },
    created() {},
    methods: {
        /**
         * @Author: Misaka.chen
         * @description:
         * @param {type}
         * @return:
         * @Version: 1.0
         */
        openDialog(menuData, row) {
            console.log(row);
            if (row.type == 0) {
                this.form.type = 0;
                this.typeForm.type = 0;
                this.form.id = row.id;
                this.form.name = row.name;
                this.form.isShow = row.isShow;
                this.form.icon = row.iconClass;
                this.form.url = row.url == null ? '' : row.url.slice(1);
                this.form.menu = row.parentId == 1 ? null : row.parentId;
                this.form.remark = row.remark;
                this.form.sort = row.sort;
            } else {
                this.btnTypeList.forEach((item) => {
                    if (item.id == row.btnTypeCode) {
                        this.btnForm.btnType = row.btnTypeCode;
                    }
                });
                this.btnForm.id = row.id;
                this.btnForm.type = 1;
                this.typeForm.type = 1;
                this.btnForm.btn = row.name;
                // this.btnForm.btn = row.btnType;
                this.btnForm.menu = row.parentId == 1 ? null : row.parentId;
                this.btnForm.remark = row.remark;
            }

            this.menuData = menuData;
            this.addMenuDialogVisible = true;
        },
        /**
         * @Author: Misaka.chen
         * @description: 点击按钮关闭dialog
         * @param {type}
         * @return:
         * @Version: 1.0
         */
        handleToClose() {
            this.addMenuDialogVisible = false;
            this.$refs.form.resetFields();
            this.form.menu = null;
            this.form.icon = '';
        },
        /**
         * @Author: Misaka.chen
         * @description: 后台返回的数据字段不符合VueTreeselect的要求的，需要进行转换
         * @param {type}
         * @return:
         * @Version: 1.0
         */
        normalizer(node) {
            //去掉children=[]的children属性
            // if (node.children && !node.children.length) {
            if (node.children == null) {
                delete node.children;
            }
            return {
                id: node.id,
                label: node.name,
                children: node.children
            };
        },
        // 选中图标
        selected(name) {
            this.form.icon = name;
        },
        /**
         * @Author: Misaka.chen
         * @description:
         * @param {type}
         * @return:
         * @Version: 1.0
         */

        handleToSave() {
            if (this.form.type == 0) {
                let info = {};
                info.id = this.form.id;
                info.type = this.form.type;
                info.isShow = this.form.isShow;
                info.iconClass = this.form.icon;
                info.name = this.form.name;
                info.url = '/' + this.form.url;
                info.sort = this.form.sort;
                info.parentId = this.form.menu;
                info.remark = this.form.remark;
                this.$refs.form.validate(async (valid) => {
                    if (valid) {
                        const res = await this.$axios.post('sys/menu/update', info);
                        if (res.data.code == 0) {
                            this.$message.success(`${res.data.data}`);
                            this.handleToClose();
                            this.$emit('getTreeData');
                        } else {
                            this.$message.error(`${res.data.data}`);
                            this.handleToClose();
                            // this.$emit('getTreeData');
                        }
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            } else {
                let info = {};
                info.id = this.btnForm.id;
                info.name = this.btnForm.btn;
                info.type = 1;
                info.isShow = 1;
                info.parentId = this.btnForm.menu;
                info.remark = this.btnForm.remark;
                this.$refs.btnFormRules.validate(async (valid) => {
                    if (valid) {
                        const res = await this.$axios.post('sys/menu/update', info);
                        if (res.data.code == 0) {
                            this.$message.success(`${res.data.data}`);
                            this.handleToClose();
                            this.$emit('getTreeData');
                        } else {
                            this.$message.error(`${res.data.data}`);
                            this.handleToClose();
                            // this.$emit('getTreeData');
                        }
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
};
</script>

<style lang="less" scoped>
.el-radio-group {
    margin-bottom: 0 !important;
}

/deep/.el-input-number .el-input__inner {
    text-align: left;
}

.dialog-footer {
    text-align: right;
}
</style>