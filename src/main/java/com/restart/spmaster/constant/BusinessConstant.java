package com.restart.spmaster.constant;


public class BusinessConstant {

    /**
     * 会员验证失败
     */
    public static String MEMBER_MISS_CODE = "0002";
    /**
     * 请求成功
     */
    public static String SYSTEM_SUCESS_CODE = "0000";
    /**
     * 系统异常
     */
    public static String SYSTEM_ERROR_CODE = "9999";
    /**
     * 格式异常
     */
    public static String REQUEST_FORMAT_ERROR_CODE = "9998";
    /**
     * 参数异常
     */
    public static String PARAMETER_ERROR_CODE = "9997";
    /**
     * redis获取连接异常
     */
    public static String REDIS_TIMEOUT_ERROR_CODE = "9995";
    /**
     * 网络繁忙，请重试
     */
    public static String NETWORK_BUSY_ERROR_CODE = "9994";
    /**
     * 活动配置异常
     */
    public static String ACTIVITY_CONFIG_ERROR_CODE = "9993";

    /**
     * 未认证/认证失效
     */
    public static String ACCOUNT_ERROR_OAUTH_CODE = "2000";
    /**
     * 账户或密码错误
     */
    public static String USER_ERROR_PASSWORD_CODE = "2020";

    /**
     * 数据已存在
     */
    public static String DATA_REEOR_EXISTS = "1020";
    /**
     * 数据不存在
     */
    public static String DATA_REEOR_NOT_EXISTS = "1030";
    /**
     * 数据值定义不合法
     */
    public static String DATA_REEOR_NOT_VALUE_EXISTS = "1040";
    /**
     * 业务暂不支持
     */
    public static String BUSINESS_REEOR_NOT_SUPPORT = "1050";


    /**
     * 规则定义不合法
     */
    public static String RULR_DEFINR_UNDEDINED = "3010";

    /**
     * 因当前活动绑定的规则状态不可用，当前活动不可切换至【生效】状态
     */
    public static String QRCODECARD_STATUS_UNUSABLE = "4010";
    /**
     * 活动已关闭
     */
    public static String QRCODECARD_STATUS_CLOSED = "4020";

    /**
     * 活动暂未开启
     */
    public static String QRCODECARD_STATUS_NO_START = "4030";

    /**
     * 参与者暂无可领取的奖励
     */
    public static String PARTICIPANT_NOANY_REWARD = "5010";

    /**
     * 积分不足
     */
    public static String LACK_OF_INTEGRAL = "6010";

    /**
     * 抽奖次数达到上限
     */
    public static String LOTTERY_NUMBER_LIMIT = "6020";


    /**
     * 奖品领取达到上限
     */
    public static String PRIZE_RECEIVE_LIMIT = "6040";

    /**
     * 兑换礼包数量不足，正在补货
     */
    public static String PRIZE_INSUFFICIENT_INVENTORY = "6050";

    /**
     * 富润ERP-地址基础信息
     *
     * @see com.tcbj.maiyoucard.domain.entity.furun.FuRunArea
     */
    public static final class FuRunArea {
        /**
         * 国家
         */
        public static final int TYPE_COUNTRY = 1;

        /**
         * 省
         */
        public static final int TYPE_PROVINCE = 2;

        /**
         * 市
         */
        public static final int TYPE_CITY = 3;

        /**
         * 区
         */
        public static final int TYPE_AREA = 4;
    }

}
