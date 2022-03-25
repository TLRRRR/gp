package com.wang.gp.service.Impl;

import com.wang.gp.dao.LoginDao;
import com.wang.gp.dao.UserDao;
import com.wang.gp.pojo.Login;
import com.wang.gp.pojo.User;
import com.wang.gp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginDao loginDao;

    @Autowired
    HttpServletRequest request;


    public User selectUserById(int userId){
        return userDao.selectUserById(userId);
    }

    public User queryUser(User user){
        return userDao.queryUser(user);
    }

    public User registerQueryUser(String userName){
        return userDao.registerQueryUser(userName);
    }

    public User queryUserByTel(String tel){
        return userDao.queryUserByTel(tel);
    }

    public int registerUser(String userName,String pwd,String tel){
        return userDao.registerUser(userName,pwd,tel);
    }
    @Override
    public int updatePwd(String userName, String pwd, String tel) {
        return userDao.updatePwd(userName, pwd, tel);
    }

    //注册
    @Override
    public String register(User user) {
//        //查询用户表中是否存在此用户
//        User t_user = userDao.registerQueryUser(user.getUserName());
//
//        if (t_user == null) {
//            //用户表中不存在此用户，注册成功
//            userDao.registerUser(user.getUserName(), user.getPwd(), user.getTel());
//            return "redirect:/tologin";
//        } else {
//            //注册失败
//            return "de";
//        }
        System.out.println("ssssservice");
        User user_n = userDao.registerQueryUser(user.getUserName());
        User user_tel = userDao.queryUserByTel(user.getTel());
        System.out.println(user);

        if(user_n!=null){
            String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"用户名存在\"}";
            return jsonStr;
        }else if(user_tel!=null){
            String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"该手机号已注册\"}";
            return jsonStr;
        } else {
            userDao.registerUser(user.getUserName(),user.getPwd(),user.getTel());
            String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"注册成功\"}";
            return jsonStr;
        }
    }

    //登录
    @Override
    public String login(User user) {
        User np_user = userDao.queryUser(user);
        //判断用户是否在user数据库里
        User n = userDao.registerQueryUser(user.getUserName());
        //判断表login中是否已经有这个账户
        Login np_login = loginDao.queryUser(user.getUserName());
        System.out.println(np_login);

        Date errorLoginTime = new Date();
        if (np_login == null) {
            loginDao.insertUser(user.getUserName(), errorLoginTime, 0);
            //login表和user表没有设置关联，如果user表中存在该用户而login表中不存在，则将其添加进去。
            np_login = loginDao.queryUser(user.getUserName());
        }
        int count = np_login.getCount();
        System.out.println("count: " + count);
        Date time = np_login.getTime();
        long result = errorLoginTime.getTime() - time.getTime();

        if (result > 180000)
            count = 0;

        if (n != null) {      //数据库里存在昵称为userName的用户
            System.out.println("用户id存在");
            if (count > 2)//连续错误登陆次数已经超过三次
            {
                System.out.println("登录错误次数太多，账户锁定");
                String jsonStr = "{\"errorCode\":\"33\",\"errorMessage\":\"您由于错误登陆次数太多，系统已将您的账户锁定，请在三分钟后重新登录！\"}";
                loginDao.updateUser(user.getUserName(), errorLoginTime, count + 1);
                return jsonStr;
            } else {
                //id存在，密码错误
                if ((np_user == null)) {        //用户存在但密码输入错误，那么输出密码输入错误，并且如果当前和上次错误时间相隔不到1分钟则count+1;
                    System.out.println("id存在，密码错误");
                    String jsonStr = "{\"errorCode\":\"22\",\"errorMessage\":\"密码输入错误，错误输入三次后您的账户将会被锁定！\"}";
                    loginDao.updateUser(user.getUserName(), errorLoginTime, count + 1);
                    return jsonStr;
                } else {
                    System.out.println("登录成功");
                    loginDao.updateUser(user.getUserName(), errorLoginTime, 0);
//                    HttpSession session = request.getSession();
//                    session.setAttribute("LoginUser", np_user);
//                    System.out.println(request.getSession());
//                    String jsonStr = "{\"errorCode\":\"00\",\"errorMessage\":\"登陆成功！\"}";
//                    return jsonStr;
                    String success = "success";
                    return success;
                }
            }
        } else {    //该数据库没有存储过该tel
            System.out.println("用户id不存在");
            System.out.println(user.getUserName());
            System.out.println(errorLoginTime);
            loginDao.updateUser(user.getUserName(), errorLoginTime, count + 1);
            String jsonStr = "{\"errorCode\":\"11\",\"errorMessage\":\"该用户不存在\"}";
//            String jsonStr = "{errorCode:11,errorMessage:该用户不存在}";
            return jsonStr;
        }
    }

    @Override
    public String findback(User user) {

        if (user == null) {
            System.out.println("是到这里了吗");
            return "{\"errorCode\":\"11\",\"errorMessage\":\"该手机号用户不存在\"}";
        } else {
            return "{\"errorCode\":\"00\",\"errorMessage\":\"该手机号用户存在\"}";
        }
    }

}
