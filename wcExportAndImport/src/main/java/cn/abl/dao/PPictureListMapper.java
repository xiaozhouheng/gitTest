package cn.abl.dao;

import cn.abl.pojo.PPictureList;
import cn.abl.pojo.PPictureListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PPictureListMapper {
    int countByExample(PPictureListExample example);

    int deleteByExample(PPictureListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PPictureList record);

    int insertSelective(PPictureList record);

    List<PPictureList> selectByExample(PPictureListExample example);

    PPictureList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PPictureList record, @Param("example") PPictureListExample example);

    int updateByExample(@Param("record") PPictureList record, @Param("example") PPictureListExample example);

    int updateByPrimaryKeySelective(PPictureList record);

    int updateByPrimaryKey(PPictureList record);
    
    int uploadFile(List<PPictureList> list);
}