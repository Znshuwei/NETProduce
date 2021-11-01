package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CncunitManageProdeviceMapper;
import com.ruoyi.system.domain.CncunitManageProdevice;
import com.ruoyi.system.service.ICncunitManageProdeviceService;

/**
 * 工艺设备数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-31
 */
@Service
public class CncunitManageProdeviceServiceImpl implements ICncunitManageProdeviceService 
{
    @Autowired
    private CncunitManageProdeviceMapper cncunitManageProdeviceMapper;

    /**
     * 查询工艺设备数据
     * 
     * @param manageProdevId 工艺设备数据ID
     * @return 工艺设备数据
     */
    @Override
    public CncunitManageProdevice selectCncunitManageProdeviceById(String manageProdevId)
    {
        return cncunitManageProdeviceMapper.selectCncunitManageProdeviceById(manageProdevId);
    }

    /**
     * 查询工艺设备数据列表
     * 
     * @param cncunitManageProdevice 工艺设备数据
     * @return 工艺设备数据
     */
    @Override
    public List<CncunitManageProdevice> selectCncunitManageProdeviceList(CncunitManageProdevice cncunitManageProdevice)
    {
        return cncunitManageProdeviceMapper.selectCncunitManageProdeviceList(cncunitManageProdevice);
    }

    /**
     * 新增工艺设备数据
     * 
     * @param cncunitManageProdevice 工艺设备数据
     * @return 结果
     */
    @Override
    public int insertCncunitManageProdevice(CncunitManageProdevice cncunitManageProdevice)
    {
        return cncunitManageProdeviceMapper.insertCncunitManageProdevice(cncunitManageProdevice);
    }

    /**
     * 修改工艺设备数据
     * 
     * @param cncunitManageProdevice 工艺设备数据
     * @return 结果
     */
    @Override
    public int updateCncunitManageProdevice(CncunitManageProdevice cncunitManageProdevice)
    {
        return cncunitManageProdeviceMapper.updateCncunitManageProdevice(cncunitManageProdevice);
    }

    /**
     * 批量删除工艺设备数据
     * 
     * @param manageProdevIds 需要删除的工艺设备数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageProdeviceByIds(String[] manageProdevIds)
    {
        return cncunitManageProdeviceMapper.deleteCncunitManageProdeviceByIds(manageProdevIds);
    }

    /**
     * 删除工艺设备数据信息
     * 
     * @param manageProdevId 工艺设备数据ID
     * @return 结果
     */
    @Override
    public int deleteCncunitManageProdeviceById(String manageProdevId)
    {
        return cncunitManageProdeviceMapper.deleteCncunitManageProdeviceById(manageProdevId);
    }
}
