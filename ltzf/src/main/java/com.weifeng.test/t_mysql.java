package com.weifeng.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 * @description：TODO
 * @USER ：weifeng
 * @date ：2025/1/18 下午 04:02
 */
public class t_mysql {
    public static void main(String[] args) throws SQLException, IOException {
        String url = "jdbc:mysql://172.18.174.11:6308/sit_ttlq";
        String username = "sit_ttlq";
        String password = "f2N#Xewfn*1zqvr";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("数据库连接成功！");



//        select_mysql();




        long a = 999000000;
        for (int i = 0; i < 148; i++) {
            String filePath = "E:\\JAVA\\java练习\\AutoTest\\ltzf\\t_applet_store_202501211014.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String sql = "INSERT INTO sit_ttlq.t_applet_goods\n" +
                        "(id, goods_id, goods_name, goods_description, goods_price, goods_full, goods_sell_price, cost_price," +
                        " logo_url, check_state, goods_state, put_start_date, put_end_date, put_end_time, put_start_time, " +
                        "source_channel, jump_link, goods_validity, use_limit_context, use_context, can_use_prov, " +
                        "can_use_city, if_show, if_charg_flg, if_link_pwk, mkt_id, cap_id, merc_type, qy_seq, create_time, " +
                        "update_time, if_sell_out, gift_bag_table_id, goods_num, user_limit_num, goods_used_num, " +
                        "ecology_act_mode, pre_act_id, business_hall_id, business_hall_name, business_hall_address, " +
                        "business_province_code, business_city_code, auditor, audit_date, check_msg, valid_type, start_time, " +
                        "end_time, product_id, product_type, product_effect_time, coupon_name, send_type, send_periods, " +
                        "mkt_introduce, user_usage_mode, product_name, goods_class_id, goods_class_name, goods_type, " +
                        "goods_label, unicom_flg)\n" +
                        "VALUES("+a+", NULL, '测试审核导出脏数据', '请在营业时间内到店消费使用，具体使用规则可联系商家确认。', 100, 0, 0, 0, '', 'WAIT', " +
                        "'WAIT_PUT'," +
                        " '20250118', '20250120', NULL, NULL, 'OUT_MERC', NULL, '30', '每人限领1张', NULL, '18', '720', 'Y', 'N', " +
                        "NULL, NULL, '"+line+"', NULL, 9999, '2025-01-18 16:21:03', '2025-01-18 16:22:22', 'N', NULL, " +
                        "1, 1, 0, '01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '02', NULL, NULL, NULL, NULL, " +
                        "NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', 'COUPON', '');";
                a++;
//                System.out.println(sql);
                inset_mysql(connection,sql);
            }

        }


//        inset_mysql(connection,sql);
    }



    public static void select_mysql() throws SQLException {

        String url = "jdbc:mysql://172.18.174.11:6308/sit_ttlq";
        String username = "sit_ttlq";
        String password = "f2N#Xewfn*1zqvr";

        String sql = "select * from sit_ttlq.t_applet_goods tag where tag.goods_id ='03testWM2MjgtZjJh'";


        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("数据库连接成功！");

        PreparedStatement  preSql = connection.prepareStatement(sql);
        ResultSet  rs = preSql.executeQuery();

        if (rs.next()) {
            String id = rs.getString("id"); // 或者 String id = rs.getString(1); 用以获取第一列的数据
            System.out.println(id);
        }


    }


    public static void inset_mysql(Connection connection,String sql) throws SQLException {

        PreparedStatement prepsInsertProduct = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prepsInsertProduct.execute();
    }
}
