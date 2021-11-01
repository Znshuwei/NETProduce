<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="工艺设备名称" prop="manageProdevName">
        <el-input
          v-model="queryParams.manageProdevName"
          placeholder="请输入工艺设备名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属车间ID" prop="manageProdevWkshopid">
        <el-input
          v-model="queryParams.manageProdevWkshopid"
          placeholder="请输入所属车间ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="数量" prop="manageProdevNumber">
        <el-input
          v-model="queryParams.manageProdevNumber"
          placeholder="请输入数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="删除标志" prop="manageProdevDelflag">
        <el-input
          v-model="queryParams.manageProdevDelflag"
          placeholder="请输入删除标志"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="manageProdevRemark">
        <el-input
          v-model="queryParams.manageProdevRemark"
          placeholder="请输入备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:prodevice:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:prodevice:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:prodevice:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
		  :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:prodevice:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="prodeviceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="工艺设备ID" align="center" prop="manageProdevId" />
      <el-table-column label="工艺设备名称" align="center" prop="manageProdevName" />
      <el-table-column label="所属车间ID" align="center" prop="manageProdevWkshopid" />
      <el-table-column label="数量" align="center" prop="manageProdevNumber" />
      <el-table-column label="删除标志" align="center" prop="manageProdevDelflag" />
      <el-table-column label="备注" align="center" prop="manageProdevRemark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:prodevice:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:prodevice:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改工艺设备数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="工艺设备名称" prop="manageProdevName">
          <el-input v-model="form.manageProdevName" placeholder="请输入工艺设备名称" />
        </el-form-item>
        <el-form-item label="所属车间ID" prop="manageProdevWkshopid">
          <el-input v-model="form.manageProdevWkshopid" placeholder="请输入所属车间ID" />
        </el-form-item>
        <el-form-item label="数量" prop="manageProdevNumber">
          <el-input v-model="form.manageProdevNumber" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="删除标志" prop="manageProdevDelflag">
          <el-input v-model="form.manageProdevDelflag" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="manageProdevRemark">
          <el-input v-model="form.manageProdevRemark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProdevice, getProdevice, delProdevice, addProdevice, updateProdevice, exportProdevice } from "@/api/system/prodevice";

export default {
  name: "Prodevice",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 工艺设备数据表格数据
      prodeviceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        manageProdevName: null,
        manageProdevWkshopid: null,
        manageProdevNumber: null,
        manageProdevDelflag: null,
        manageProdevRemark: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        manageProdevName: [
          { required: true, message: "工艺设备名称不能为空", trigger: "blur" }
        ],
        manageProdevWkshopid: [
          { required: true, message: "所属车间ID不能为空", trigger: "blur" }
        ],
        manageProdevNumber: [
          { required: true, message: "数量不能为空", trigger: "blur" }
        ],
        manageProdevDelflag: [
          { required: true, message: "删除标志不能为空", trigger: "blur" }
        ],
        manageProdevRemark: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询工艺设备数据列表 */
    getList() {
      this.loading = true;
      listProdevice(this.queryParams).then(response => {
        this.prodeviceList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        manageProdevId: null,
        manageProdevName: null,
        manageProdevWkshopid: null,
        manageProdevNumber: null,
        manageProdevDelflag: null,
        manageProdevRemark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.manageProdevId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加工艺设备数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const manageProdevId = row.manageProdevId || this.ids
      getProdevice(manageProdevId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改工艺设备数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.manageProdevId != null) {
            updateProdevice(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProdevice(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const manageProdevIds = row.manageProdevId || this.ids;
      this.$confirm('是否确认删除工艺设备数据编号为"' + manageProdevIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delProdevice(manageProdevIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有工艺设备数据数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportProdevice(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
