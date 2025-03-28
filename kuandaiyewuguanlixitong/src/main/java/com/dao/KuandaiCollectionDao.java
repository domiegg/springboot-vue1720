package com.dao;

import com.entity.KuandaiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuandaiCollectionView;

/**
 * 宽带收藏 Dao 接口
 *
 * @author 
 */
public interface KuandaiCollectionDao extends BaseMapper<KuandaiCollectionEntity> {

   List<KuandaiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
