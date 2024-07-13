package test;

public class T889 {
    public static void main(String[] args) {
    String name=  "id\n" +
              "store_code\n" +
              "store_name\n" +
              "store_name_en\n" +
              "store_type\n" +
              "province\n" +
              "city\n" +
              "area\n" +
              "address\n" +
              "address_en\n" +
              "longitude\n" +
              "latitude\n" +
              "telephone\n" +
              "price_tier_code\n" +
              "preparation_status\n" +
              "store_status\n" +
              "description\n" +
              "expect_open_date\n" +
              "actual_open_date\n" +
              "close_date\n" +
              "user_code\n" +
              "franchisee_code\n" +
              "koubei_shopid\n" +
              "meituan_shopid\n" +
              "jddj_shopid\n" +
              "meituan_poi\n" +
              "eleme_shopid\n" +
              "shunfeng_delivery_shopid\n" +
              "anubis_delivery_shopid\n" +
              "dada_delivery_shopid\n" +
              "dada_city_code\n" +
              "invoice_status\n" +
              "invoice_account\n" +
              "candao_delivery_shopid\n" +
              "tiktok_store\n" +
              "sdx_config_id\n" +
              "tenant_id\n" +
              "creator_id\n" +
              "modifier_id\n" +
              "deleted\n" +
              "created_time\n" +
              "modified_time";
        String[] split = name.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s);
            sb.append(",");
        }
        System.out.println(sb.toString());
    }
}
