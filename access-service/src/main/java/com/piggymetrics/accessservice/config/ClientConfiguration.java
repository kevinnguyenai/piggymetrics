package com.piggymetrics.accessservice.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
//import feign.okhttp.OkHttpClient;
import feign.httpclient.ApacheHttpClient;

import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient.Builder;
import okhttp3.OkHttpClient;
import com.piggymetrics.accessservice.util.HttpClient;

import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin
 */
@Configuration
public class ClientConfiguration {

    private static final TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
              return new java.security.cert.X509Certificate[]{};
            }
        }
    };

    private static final SSLContext trustAllSslContext;
    static {
        try {
            trustAllSslContext = SSLContext.getInstance("SSL");
            trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static final SSLSocketFactory trustAllSslSocketFactory = trustAllSslContext.getSocketFactory();

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default();
    }

    @Bean
    public OkHttpClient client() {
        OkHttpClient client = new OkHttpClient();
        HttpClient ctx = new HttpClient();
        return ctx.trustAllSslClient(client);

    }


    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", "admin");
            requestTemplate.header("pass", "admin@123");
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }

    // @Bean - uncomment to use this interceptor and remove @Bean from the requestInterceptor()
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "admin@123");
    }
}
