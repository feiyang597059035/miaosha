package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.common.vo.GoodsVo;
import com.example.demo.model.MiaoshaGoods;

@Mapper
public interface GoodsDao {

    @Select("select g.*,mg.stockCount, mg.startDate, mg.endDate,mg.miaoshaPrice from miaosha_goods mg left join goods g on mg.goodsId = g.id")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*,mg.stockCount, mg.startDate, mg.endDate,mg.miaoshaPrice from miaosha_goods mg left join goods g on mg.goodsId = g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update miaosha_goods set stockCount = stockCount - 1 where goodsId = #{goodsId} and stockCount > 0")
    public int reduceStock(MiaoshaGoods g);

    @Update("update miaosha_goods set stockCount = #{stockCount} where goodsId = #{goodsId}")
    public int resetStock(MiaoshaGoods g);

}
