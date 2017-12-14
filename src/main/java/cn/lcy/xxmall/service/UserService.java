package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @Author LCY
 * @Date 2017/11/8 9:31
 */
public interface UserService {
    /**
     * 获取所有用户
     * @return
     */
    List<User> getUsers();

    /**
     * 实现登录请求
     * @param userName 用户账号
     * @param password 用户密码
     * @return null表示登录失败
     */
    User login(String userName,String password);

    /**
     * 根据标识获取指定用户对象
     * @param userName 用户账号
     * @return null表示没有找到
     */
    User getUserByUsername(String userName);

    /**
     * 根据标识获取指定用户对象
     * @param nickname 用户昵称
     * @return null表示没有找到
     */
    User getUserByNickname(String nickname);

    /**
     * 根据标识获取指定用户对象
     * @param email 邮箱
     * @return null表示没有找到
     */
    User getUserByEmail(String email);

    /**
     * 根据标识获取指定用户对象
     * @param question 邮箱
     * @return null表示没有找到
     */
    User getUserByQuestion(String question);

    /**
     * 根据标识获取指定用户对象
     * @param answer 邮箱
     * @return null表示没有找到
     */
    User getUserByAnswer(String answer);

    /**
     * 根据标识将指定用户放置回收站内
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户id
     * @return -1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int deleteUserByUserId(int adminId, int userId);

    /**
     * 更新用户信息。用于前台操作
     * @param targetId 需要更新的用户id
     * @param userId 操作该动作的用户id
     * @param user 用户对象
     * @return 0:更新失败,未知原因。 -2：更新的用户id不是自己； 1：更新成功。
     */
    int updateUser(int targetId, int userId, User user);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param password 用户密码
     * @return -2：密码格式不对；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfPassword(int adminId, int userId, String password);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param nickname 用户昵称 (昵称长度为：5~15之间。包括5、15)
     * @return -3该用户名已存在； -2：昵称格式不对；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfNickname(int adminId, int userId, String nickname);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param email 用户邮箱
     * @return -2：邮箱格式不对；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfEmail(int adminId, int userId, String email);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param level 用户等级 长度为0~20 包含0、20
     * @return -2：等级格式不对；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfLevel(int adminId, int userId, int level);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param question 用户问题 （长度为5~20，包含5、20）
     * @return -2：用户问题格式不对；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfQuestion(int adminId, int userId, String question);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param answer 用户答案 （长度为3~20，包含3、20）
     * @return -2：用户答案格式不对；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfAnswer(int adminId, int userId, String answer);

    /**
     * 根据标识更新指定用户指定信息
     * @param adminId 执行该操作的管理员ID
     * @param userId 用户ID
     * @param prohibitLoginTime 禁止登陆时间
     * @return -2：禁止登陆时间为空；-1：用户ID不存在；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int updateUserOfProhibitLoginTime(int adminId, int userId, Date prohibitLoginTime);

    /**
     * 根据标识添加指定用户
     * @param adminId 执行该操作的管理员ID
     * @param user 用户对象
     * @param userHeaderFile 用户头像文件
     * @return -2：用户对象为空；0：操作失败,未知原因； 1：操作成功；2：操作失败，没有权限；
     */
    int insertUser(int adminId,User user,MultipartFile userHeaderFile);
}
