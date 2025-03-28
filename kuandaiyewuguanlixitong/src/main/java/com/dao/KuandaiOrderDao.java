package com.dao;

import com.entity.KuandaiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuandaiOrderView;

/**
 * 宽带开户 Dao 接口
 *
 * @author 
 */
public interface KuandaiOrderDao extends BaseMapper<KuandaiOrderEntity> {

   List<KuandaiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
