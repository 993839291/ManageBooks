package cn.lightina.managebooks.pojo;

public interface ResponseCode {
    /**
     * 成功
     **/
    public static final int SUCCESS = 10000;


    /************************************************************/

    /************************************************************/

    /**
     * 失败
     **/
    public static final int ERROR = 20000;

    /**用户验证失败码--无权限**/
    public static final int ACCOUNT_NOPERMISSION_ERROR = 20001;
    /**用户验证失败码--未登录**/
    public static final int ACCOUNT_NOLOGIN_ERROR = 20002;
    /**用户验证失败码--验证异常**/
    public static final int ACCOUNT_VERIFY_ERROR = 20003;

    /**学习资料失败--已经学习过异常**/
    public static final int LMATERIALS_LEARNED_ERROR = 21001;

    /**开户注册手机号已经激活过了**/
    public static final int OPEN_ACCOUNT_ACTIVED = 22000;
}
