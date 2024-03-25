package com.nuist.medical.Config;

import com.nuist.medical.Annotation.LoginRequired;
import com.nuist.medical.Annotation.LoginUser;
import com.nuist.medical.Utils.JwtConfig;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;


/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-25-10:27
 * @Modified By:
 */
@Configuration
public class WebMvcConifg implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserHandlerArgumentResolvers());
    }

    @Bean
    public LoginUserHandlerArgumentResolvers loginUserHandlerArgumentResolvers(){
        return new LoginUserHandlerArgumentResolvers();
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }

    private class AuthenticationInterceptor implements HandlerInterceptor{

        @Resource
        private JwtConfig jwtConfig;

        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            //如果不是加在方法上的直接通行
            if(!(handler instanceof HandlerMethod)){
                return true;
            }

            HandlerMethod handlerMethod=(HandlerMethod)handler;
            Method method=handlerMethod.getMethod();
            LoginRequired methodAnnotation=method.getAnnotation(LoginRequired.class);
            if(methodAnnotation!=null){
                String token=request.getHeader("Token");
                if(StringUtils.isEmpty(token)){
                    return false;
                }
                Claims claims=jwtConfig.jwtParse(token);
                System.out.println(claims.get("user_id"));
                Date expireDate=claims.getExpiration();
                Date now =new Date(System.currentTimeMillis());
                //如果未到结束日期则放行
                if(expireDate.compareTo(now)==1)
                    return true;
                else
                    return false;
            }
            return true;
        }
    }

    public class LoginUserHandlerArgumentResolvers implements HandlerMethodArgumentResolver{

        @Resource
        private JwtConfig jwtConfig;

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.hasParameterAnnotation(LoginUser.class);
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
            String token=webRequest.getHeader("Token");
            String user_id=(String)jwtConfig.jwtParse(token).get("user_id");
            return user_id;
        }
    }
}


