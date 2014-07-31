package doudou.learn.ex01;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Zhengxin on 14-7-31.
 */
public class Request {

    private InputStream input;
    private String uri;

    public Request(InputStream input){
        this.input = input;
    }

    public void parse(){
        StringBuffer request = new StringBuffer(1024);
        int i;

        byte[] buffer = new byte[2048];
        try{
            i = input.read(buffer);
        }
        catch (IOException e){
            e.printStackTrace();
            i = -1;
        }

        for(int j = 0;j<i;j++){
            request.append((char)buffer[j]);
        }

        System.out.print(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requeststring){

        int index1, index2;
        index1 = requeststring.indexOf(' ');
        if(index1 != -1){
            index2 = requeststring.indexOf(' ',index1+1);

            if(index2 > index1)
                return requeststring.substring(index1 + 1,index2);
        }

        return null;

    }

    public String getUri(){
        return uri;
    }

}
