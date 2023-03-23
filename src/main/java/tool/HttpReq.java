package tool;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public class HttpReq {
    public static void main(String[] args) {
        HttpRequest httpRequest = HttpRequest.get("https://www.baidu.com");
        HttpResponse execute = httpRequest.execute();
        System.out.println(execute);
    }
}
