package com.noc.servletuser;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {
    private final String url = "mongodb://192.168.206.128:27017";
    private final MongoCollection<Document> collection = MongoClients.create(url).getDatabase("test").getCollection("user");

    /*
     * 功能描述：
     * 获取请求中name或者age参数，并通过name和age从mongodb中查询出相应数据（name模糊匹配，age精确匹配）。并将查询出的数据响应给客户端。
     * @author jiangzhenyue
     * @date 2021/9/28 10:07
     * @param request
     * @param response
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        Bson filter;
        try {
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            // 参数校验
            if (name == null && age == null) {
                out.println("没有参数 ");
                return;
            }
            // 过滤器选择
            if (name != null && age != null) {
                filter = Filters.and(Filters.eq("age", Integer.parseInt(age)), Filters.regex("name", name));//转int
            } else if (name != null) {
                filter = Filters.regex("name", name);
            } else {
                filter = Filters.eq("age", Integer.parseInt(age));
            }
            FindIterable<Document> documentList = collection.find(filter);
            out.println("查询成功");
            // 只输出name和age
            for (Document document : documentList) {
                out.println("name:" + document.get("name"));
                out.println("age:" + document.get("age"));
            }
        }catch (Exception e) {
            out.println("查询失败");
            out.println("异常：" + e);
        }
    }

    /*
     * 功能描述：
     * 获取请求中name（string类型）和age（int类型）参数，并将其存储到mongodb的test库的 user集合中，并且如果存储成功则给客户端响应“新增成功”，否则“新增失败”
     * @author jiangzhenyue
     * @date 2021/9/28 10:06
     * @param request
     * @param response
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        try{
            String name = request.getParameter("name");
            Integer age = Integer.parseInt(request.getParameter("age"));
            // 新增文档
            collection.insertOne(new Document("name", name).append("age", age));
            out.println("新增成功");
        } catch (Exception e) {
            out.println("新增失败");
            out.println("异常：" + e);
        }
    }
}