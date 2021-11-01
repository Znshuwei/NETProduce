package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CncunitManageProdevice;

/**
 * 工艺设备数据Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-31
 */
public interface CncunitManageProdeviceMapper 
{
    /**
     * 查询工艺设备数据
     * 
     * @param manageProdevId 工艺设备数据ID
     * @return 工艺设备数据
     */
    public CncunitManageProdevice selectCncunitManageProdeviceById(String manageProdevId);

    /**
     * 查询工艺设备数据列表
     * 
     * @param cncunitManageProdevice 工艺设备数据
     * @return 工艺设备数据集合
     */
    public List<CncunitManageProdevice> selectCncunitManageProdeviceList(CncunitManageProdevice cncunitManageProdevice);

    /**
     * 新增工艺设备数据
     * 
     * @param cncunitManageProdevice 工艺设备数据
     * @return 结果
     */
    public int insertCncunitManageProdevice(CncunitManageProdevice cncunitManageProdevice);

    /**
     * 修改工艺设备数据
     * 
     * @param cncunitManageProdevice 工艺设备数据
     * @return 结果
     */
    public int updateCncunitManageProdevice(CncunitManageProdevice cncunitManageProdevice);

    /**
     * 删除工艺设备数据
     * 
     * @param manageProdevId 工艺设备数据ID
     * @return 结果
     */
    public int deleteCncunitManageProdeviceById(String manageProdevId);

    /**
     * 批量删除工艺设备数据
     * 
     * @param manageProdevIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCncunitManageProdeviceByIds(String[] manageProdevIds);
}
