package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CompanyInfor;

/**
 * 用户信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-01
 */
public interface CompanyInforMapper 
{
    /**
     * 查询用户信息
     * 
     * @param companyId 用户信息ID
     * @return 用户信息
     */
    public CompanyInfor selectCompanyInforById(Integer companyId);

    /**
     * 查询用户信息列表
     * 
     * @param companyInfor 用户信息
     * @return 用户信息集合
     */
    public List<CompanyInfor> selectCompanyInforList(CompanyInfor companyInfor);

    /**
     * 新增用户信息
     * 
     * @param companyInfor 用户信息
     * @return 结果
     */
    public int insertCompanyInfor(CompanyInfor companyInfor);

    /**
     * 修改用户信息
     * 
     * @param companyInfor 用户信息
     * @return 结果
     */
    public int updateCompanyInfor(CompanyInfor companyInfor);

    /**
     * 删除用户信息
     * 
     * @param companyId 用户信息ID
     * @return 结果
     */
    public int deleteCompanyInforById(Integer companyId);

    /**
     * 批量删除用户信息
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCompanyInforByIds(Integer[] companyIds);
}
