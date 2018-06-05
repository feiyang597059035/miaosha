package com.example.demo.common.task;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.common.redis.GoodsKey;
import com.example.demo.common.util.RedisUtil;
import com.example.demo.common.vo.GoodsVo;
import com.example.demo.service.impl.GoodsService;

@Component
public class SpikeGoodsTask {
    @Autowired
    private GoodsService GoodsService;
    @Autowired
    private RedisUtil redisUtil;

    public static HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();

    /**
     * 定时将秒杀商品的数量写入缓存中
     */
    @Scheduled(cron = "0 48 17 * * ?")
    public void addGoodsRedisTask() {
        List<GoodsVo> goodsList = GoodsService.listGoodsVo();
        if (goodsList != null && goodsList.size() > 0) {
            int size = goodsList.size();
            GoodsVo goodsVo = null;
            for (int i = 0; i < size; i++) {
                goodsVo = goodsList.get(i);
                if (goodsVo != null) {
                    redisUtil.set(GoodsKey.getMiaoshaGoodsStock, "" + goodsVo.getId(), goodsVo.getStockCount());
                }
            }
        }

    }

    @Scheduled(cron = "0 50 18 * * ?")
    public void delGoodsRedisTask() {
        localOverMap.clear();
    }

}
