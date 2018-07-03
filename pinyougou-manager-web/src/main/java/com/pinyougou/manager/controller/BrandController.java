package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.Result;
import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cicinnus
 * @date 2018/6/27
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<TbBrand> getAll() {
        List<TbBrand> allBrand = brandService.getAllBrand();
        return allBrand;
    }

    @RequestMapping("/findPage")
    public PageResult<TbBrand> findPage(int page, int size) {
        return brandService.findByPage(page, size);
    }

    /**
     * 更新
     *
     * @param tbBrand
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.addBrand(tbBrand);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(long id) {
        return brandService.findOne(id);
    }

    /**
     * 更新
     *
     * @param tbBrand
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public Result deleteByIds(Long[] ids) {
        try {
            brandService.deleteByIds(ids);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @RequestMapping("/search")
    public PageResult<TbBrand> search(@RequestBody TbBrand brand, int page, int size) {
        return brandService.findByPage(brand, page, size);
    }
}
