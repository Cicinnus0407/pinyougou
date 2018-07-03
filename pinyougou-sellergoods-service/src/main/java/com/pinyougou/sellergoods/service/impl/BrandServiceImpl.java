package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cicinnus
 * @date 2018/6/27
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    public List<TbBrand> getAllBrand() {
        return tbBrandMapper.selectByExample(null);
    }

    public PageResult<TbBrand> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return PageResult.success(page.getTotal(), page.getResult());
    }


    public void addBrand(TbBrand brand) {
        tbBrandMapper.insert(brand);
    }

    public TbBrand findOne(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    public void update(TbBrand brand) {
        tbBrandMapper.updateByPrimaryKey(brand);
    }

    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    public PageResult<TbBrand> findByPage(TbBrand brand, int pageNum, int pageSize) {
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand != null) {

            if (brand.getName() != null && brand.getName().length() > 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {

                criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
            }
        }

        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        return PageResult.success(page.getTotal(), page.getResult());
    }
}
