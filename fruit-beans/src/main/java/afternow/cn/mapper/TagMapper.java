package afternow.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import afternow.cn.entity.Tag;
import afternow.cn.entity.example.TagExample;

public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int countByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int deleteByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int deleteByPrimaryKey(Integer tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    Tag selectByPrimaryKey(Integer tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByPrimaryKey(Tag record);
}