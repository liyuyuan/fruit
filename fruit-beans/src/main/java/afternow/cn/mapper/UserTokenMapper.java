package afternow.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import afternow.cn.entity.UserToken;
import afternow.cn.entity.example.UserTokenExample;

public interface UserTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    int countByExample(UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    int deleteByExample(UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    int insert(UserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    int insertSelective(UserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    List<UserToken> selectByExample(UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Mon May 14 21:18:27 CST 2018
     */
    int updateByExample(@Param("record") UserToken record, @Param("example") UserTokenExample example);
}