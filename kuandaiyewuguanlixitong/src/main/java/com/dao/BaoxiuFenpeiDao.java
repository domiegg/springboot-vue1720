package com.dao;

import com.entity.BaoxiuFenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxiuFenpeiView;

/**
 * 报修分配 Dao 接口
 *
 * @author 
 */
public interface BaoxiuFenpeiDao extends BaseMapper<BaoxiuFenpeiEntity> {

   List<BaoxiuFenpeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
