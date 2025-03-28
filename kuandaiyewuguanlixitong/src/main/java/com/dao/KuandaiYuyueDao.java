package com.dao;

import com.entity.KuandaiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuandaiYuyueView;

/**
 * 宽带预约安装 Dao 接口
 *
 * @author 
 */
public interface KuandaiYuyueDao extends BaseMapper<KuandaiYuyueEntity> {

   List<KuandaiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
