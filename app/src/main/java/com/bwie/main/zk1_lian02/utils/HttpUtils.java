package com.bwie.main.zk1_lian02.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2018/9/2.
 */

public class HttpUtils {
    //成员变量
    private static HttpUtils httpUtils;
    private OkHttpClient okHttpClient;
    //私有构造
    private HttpUtils(){
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new longinterceptor())
                .build();
    }
    //拦截器方法
    class longinterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            //请求对象
            Request request = chain.request();
            //创建方法
            String method = request.method();
            //添加日志信息
            Log.i("xxx",method+"");
            //接收对象
            Response response = chain.proceed(request);
            return response;
        }
    }
    //单例
    public static HttpUtils getinstance(){
        if (httpUtils == null){
            synchronized (HttpUtils.class){
                if (httpUtils == null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    //post方法
    public void getpost(String path, Callback callback){
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
