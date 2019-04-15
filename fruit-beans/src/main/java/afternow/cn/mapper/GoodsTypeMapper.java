package afternow.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import afternow.cn.entity.GoodsType;
import afternow.cn.entity.example.GoodsTypeExample;

public interface GoodsTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int countByExample(GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int deleteByExample(GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int deleteByPrimaryKey(Integer catId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int insert(GoodsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int insertSelective(GoodsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    List<GoodsType> selectByExample(GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    GoodsType selectByPrimaryKey(Integer catId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByPrimaryKeySelective(GoodsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_type
     *
     * @mbggenerated Wed May 09 19:30:24 CST 2018
     */
    int updateByPrimaryKey(GoodsType record);
}