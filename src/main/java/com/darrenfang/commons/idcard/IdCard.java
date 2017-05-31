package com.darrenfang.commons.idcard;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 身份证信息
 */
public class IdCard {

    /**
     * 身份证号码
     */
    private String card;
    /**
     * 是否男性
     */
    private boolean isMale;
    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 实例化身份证信息
     *
     * @param card 身份证号码
     */
    private IdCard(String card) {
        this.card = card;
    }

    /**
     * 解析身份证信息
     *
     * @param card 身份证号码
     * @return 身份证信息
     * @throws IdCardParseException 身份证号码为空，或长度不正确，或身份证号码无效时抛出 IdCardParseException
     */
    public static IdCard parse(String card) throws IdCardParseException {

        if (StringUtils.isBlank(card)) {
            throw new IdCardParseException("身份证号码不能为空");
        }

        if (card.length() != 15 && card.length() != 18) {
            throw new IdCardParseException("身份证号码长度不正确，应该是15位或18位。");
        }

        card = formatCardNumber(card);
        IdCard idCard = new IdCard(card);
        if (!idCard.isValid()) {
            throw new IdCardParseException("身份证号码无效。");
        }

        try {
            idCard.setBirthday(DateUtils.parseDate(idCard.getCard().substring(6, 14), "yyyyMMdd"));
        } catch (ParseException e) {
        }
        if (Integer.parseInt(idCard.getCard().substring(16, 17), 10) % 2 == 0) {
            idCard.setMale(false);
        } else {
            idCard.setMale(true);
        }

        return idCard;
    }

    /**
     * 获取身份证号码
     *
     * @return 身份证号码
     */
    public String getCard() {
        return card;
    }

    /**
     * 设置身份证号码
     *
     * @param card 身份证号码
     */
    private void setCard(String card) {
        this.card = card;
    }

    /**
     * 是否男性
     *
     * @return 如果是男性返回 true, 否则返回 false
     */
    public boolean isMale() {
        return isMale;
    }

    /**
     * 设置是否男性
     *
     * @param male 如果是男性则为 true, 否则为 false
     */
    private void setMale(boolean male) {
        isMale = male;
    }

    /**
     * 获取出生日期
     *
     * @return 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    private void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 验证身份证是否有效
     *
     * @return 如果有效返回 true, 否则返回 false
     */
    private boolean isValid() {
        String checkCode = computeCheckCode(card);
        return checkCode.equals(card.substring(17));
    }

    /**
     * 格式化身份证号码, 如果是 15 位身份证则转换为 18 位
     *
     * @param card 身份证号码
     * @return 18位身份证号码
     */
    private static String formatCardNumber(String card) {
        if (card.length() == 15) {
            card = card.substring(0, 6) + "19" + card.substring(6);
            card = card + computeCheckCode(card);
        }
        return card;
    }

    /**
     * 计算身份证校验位
     *
     * @param idCard 身份证号码
     * @return 身份证校验位
     */
    private static String computeCheckCode(String idCard) {
        String[] checkCodes = new String[]{"1", "0", "X", "9", "8", "7", "6",
                "5", "4", "3", "2"};

        if (idCard.length() < 17) {
            return null;
        }

        long sum = 0L;
        for (int i = 1; i <= 17; i++) {
            int w = (int) (Math.pow(2, 18 - i) % 11);
            sum += w * Integer.parseInt(idCard.substring(i - 1, i));
        }

        return checkCodes[(int) (sum % 11)];
    }

}
