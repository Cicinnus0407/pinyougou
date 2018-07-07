package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * @author cicinnus
 * @date 2018/6/27
 */
public interface BrandService {

    List<TbBrand> getAllBrand();

    /**
     * 品牌分页
     *
     * @param pageNum  页码
     * @param pageSize 条数
     * @return
     */
    PageResult<TbBrand> findByPage(int pageNum, int pageSize);

    /**
     * 插入一条
     *
     * @param brand
     * @return
     */
    void addBrand(TbBrand brand);

    /**
     * 根据id查询实体
     *
     * @param id 主键
     * @return
     */
    TbBrand findOne(long id);

    void update(TbBrand brand);

    /**
     * 删除ids
     *
     * @param ids
     */
    void deleteByIds(Long[] ids);

    /**
     * tiaojiansousuo
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult<TbBrand> findByPage(TbBrand brand, int pageNum, int pageSize);

    List<Map<String,Object>> selectOptionList();
}
