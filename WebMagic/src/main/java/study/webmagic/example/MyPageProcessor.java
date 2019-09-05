package study.webmagic.example;

import study.webmagic.GithubRepoPageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class MyPageProcessor implements PageProcessor {

	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        
        //可以通过F12右键copy selector
        String text = page.getHtml().css("#book-search-results > div.search-noresults > section > p:nth-child(7)").regex("^\\<p\\>(.*)\\</p\\>$",1).toString();
        System.out.println("-----" + text);
        page.putField("html", page.getHtml().toString());
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
    	Spider.create(new MyPageProcessor())
        //从"https://github.com/code4craft"开始抓
        .addUrl("http://11.8.124.20/Citrix/DesktopWeb/site/directLaunch.aspx")
        .addPipeline(new JsonFilePipeline("D:\\webmagicfile\\"))
        //开启1个线程抓取
        .thread(1)
        //启动爬虫
        .run();
    }
}
