package designpattern.behavioral.AKchain.ext;

import lombok.Data;

@Data
public class Response {
    String content;
    public Response(String content){
        this.content = content;
    }
}
