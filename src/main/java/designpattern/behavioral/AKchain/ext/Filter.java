package designpattern.behavioral.AKchain.ext;

public interface Filter {

    void doFilter(Request request,Response response,FilterChain chain);
}
