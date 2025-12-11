package com.weifeng.test;

/**
 * @description：TODO
 * @USER ：weifeng
 * @date ：2025/2/6 下午 03:53
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JingdongPriceChecker {

    // 京东 iPhone 16 Pro Max 商品页面 URL，需要根据实际情况调整
    private static final String PRODUCT_URL = "https://item.jd.com/100129544353.html#crumb-wrap";

    public static void main(String[] args) {
        // 创建一个单线程的定时任务执行器
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // 延迟 0 秒开始执行，然后每天执行一次
        executor.scheduleAtFixedRate(() -> {
            try {
                // 调用查询价格的方法
                checkPrice();
            } catch (IOException e) {
                System.err.println("查询价格时发生错误: " + e.getMessage());
            }
        }, 0, 1, TimeUnit.DAYS);
    }

    private static void checkPrice() throws IOException {
        // 发送 HTTP 请求并获取网页文档
        Document doc = Jsoup.connect(PRODUCT_URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                .get();

        // 根据京东页面的 HTML 结构提取价格信息
        System.out.println(doc.outerHtml());
        Elements priceElements = doc.select("#J-price");
        if (!priceElements.isEmpty()) {
            Element priceElement = priceElements.first();
            String price = priceElement.text();
            System.out.println("当前 iPhone 16 Pro Max 的价格是: " + price);
        } else {
            System.out.println("未找到价格信息。");
        }
    }
}