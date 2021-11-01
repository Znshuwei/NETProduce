package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CompanyInforMapper;
import com.ruoyi.system.domain.CompanyInfor;
import com.ruoyi.system.service.ICompanyInforService;

/**
 * 用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-01
 */
@Service
public class CompanyInforServiceImpl implements ICompanyInforService 
{
    @Autowired
    private CompanyInforMapper companyInforMapper;

    /**
     * 查询用户信息
     * 
     * @param companyId 用户信息ID
     * @return 用户信息
     */
    @Override
    public CompanyInfor selectCompanyInforById(Integer companyId)
    {
        return companyInforMapper.selectCompanyInforById(companyId);
    }

    /**
     * 查询用户信息列表
     * 
     * @param companyInfor 用户信息
     * @return 用户信息
     */
    @Override
    public List<CompanyInfor> selectCompanyInforList(CompanyInfor companyInfor)
    {
        return companyInforMapper.selectCompanyInforList(companyInfor);
    }

    /**
     * 新增用户信息
     * 
     * @param companyInfor 用户信息
     * @return 结果
     */
    @Override
    public int insertCompanyInfor(CompanyInfor companyInfor)
    {
        return companyInforMapper.insertCompanyInfor(companyInfor);
    }

    /**
     * 修改用户信息
     * 
     * @param companyInfor 用户信息
     * @return 结果
     */
    @Override
    public int updateCompanyInfor(CompanyInfor companyInfor)
    {
        return companyInforMapper.updateCompanyInfor(companyInfor);
    }

    /**
     * 批量删除用户信息
     * 
     * @param companyIds 需要删除的用户信息ID
     * @return 结果
     */
    @Override
    public int deleteCompanyInforByIds(Integer[] companyIds)
    {
        return companyInforMapper.deleteCompanyInforByIds(companyIds);
    }

    /**
     * 删除用户信息信息
     * 
     * @param companyId 用户信息ID
     * @return 结果
     */
    @Override
    public int deleteCompanyInforById(Integer companyId)
    {
        return companyInforMapper.deleteCompanyInforById(companyId);
    }
}
