package com.dao;

import com.entity.KuandaiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuandaiLiuyanView;

/**
 * 宽带留言 Dao 接口
 *
 * @author 
 */
public interface KuandaiLiuyanDao extends BaseMapper<KuandaiLiuyanEntity> {

   List<KuandaiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
