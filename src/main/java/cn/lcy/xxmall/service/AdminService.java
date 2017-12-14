package cn.lcy.xxmall.service;

import cn.lcy.xxmall.pojo.Admin;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface AdminService {
    /**
     * 执行添加管理员请求
     * @param adminId 执行该请求的管理员id
     * @param record 要添加的管理员对象
     * @param adminHeader 需要上传的管理员头像图片
     * @return 0:添加失败； 1：添加成功；2:没有操作权限
     */
    int insert(Integer adminId,Admin record,MultipartFile adminHeader);

    /**
     * 执行登录请求
     * @param adminName 管理员账号
     * @param password 管理员密码
     * @return 返回管理员对象，null值表示找不到
     */
    Admin login(String adminName,String password);

    /**
     * 根据管理员账号获取管理员对象
     * @param adminName
     * @return null表示获取失败
     */
    Admin getAdminByAdminName(String adminName);

    /**
     * 根据管理员昵称获取管理员对象
     * @param nickname
     * @return null表示获取失败
     */
    Admin getAdminByNickname(String nickname);

    /**
     * 根据管理员邮箱获取管理员对象
     * @param email
     * @return null表示获取失败
     */
    Admin getAdminByEmail(String email);

    /**
     * 获取所有管理员
     * @return
     */
    List<Admin> getAdmins();

    /**
     *
     * 修改管理员禁止登陆时间
     * @param adminId 执行该动作的管理员ID
     * @param targetId 被执行该动作的管理员ID
     * @param newProhibitLoginTime 新的禁止登陆的时间
     * @return 0：没有操作权限， 1：更新成功。 -1:不能对自己操作
     * @return
     */
    Integer updataAdminOfprohibitLoginTime(Integer adminId, Integer targetId, Date newProhibitLoginTime);

    /**
     * 修改管理员昵称
     * @param adminId 执行该动作的管理员ID
     * @param targetId 被执行该动作的管理员ID
     * @param newNickname 新的昵称
     * @return 0：修改失败; -1:修改失败，该管理员不存在； 1：修改成功； 2：修改失败，没有权限；（不会返回null）
     */
    Integer updataAdminOfNickname(Integer adminId, Integer targetId, String newNickname);

    /**
     * 修改管理员昵称
     * @param adminId 执行该动作的管理员ID
     * @param targetId 被执行该动作的管理员ID
     * @param newEmail 新的昵称
     * @return 0：修改失败; -1:修改失败，该管理员不存在； 1：修改成功； 2：修改失败，没有权限；（不会返回null）
     */
    Integer updataAdminOfEmail(Integer adminId, Integer targetId, String newEmail);

    /**
     * 把指定管理员放到回收站
     * @param targetId 要放到回收站的管理员id
     * @param adminId 操作该动作的管理员id
     * @return 0：传入非法值； 1：回收成功； 2：回收失败，没有权限回收； 3:回收失败，不能删除自己；4:删除失败，该管理员id不存在；（不会返回null）
     */
    Integer deleteAdminByAdminId(Integer targetId, Integer adminId);
}
