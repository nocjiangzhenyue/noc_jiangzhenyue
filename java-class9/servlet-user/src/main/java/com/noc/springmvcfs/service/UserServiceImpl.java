package com.noc.springmvcfs.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.noc.springmvcfs.model.User;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonRegularExpression;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    MongoCollection<Document> collection = MongoClients.create(URL).getDatabase("test").getCollection("user");

    /*
     * 功能描述：
     * 数据库插入，返回成功/失败
     * @author jiangzhenyue
     * @date 2021/9/30 12:11
     * @param user
     * @return boolean
    */
    @Override
    public boolean addUser(User user) {
        // 开启事务
        try {
            String name =  user.getName();
            int age = user.getAge();
            if(name == null || name.equals("") || age == 0)return false;
            collection.insertOne(new Document().append("name", name).append("age", age));
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*
     * 功能描述：
     * 查询操作，返回特定格式结果
     * @author jiangzhenyue
     * @date 2021/9/30 12:11
     * @param name
     * @param age
     * @return String
    */
    @Override
    public String getUser(String name, String age) {
        StringBuilder answer = new StringBuilder();
        BsonDocument query = new BsonDocument();
        if (name == null && age == null) return "参数错误";
        if (!"".equals(name) && name != null){
            query.append("name", new BsonRegularExpression("^.*"+name+".*$"));
        }
        if (!"".equals(age) && age != null){
            query.append("age", new BsonInt32(Integer.parseInt(age)));
        }
        try {
            FindIterable<Document> documentList = collection.find(query);
            // 只输出name和age
            for (Document document : documentList) {
                answer.append("name:").append(document.getString("name")).append(",")
                        .append("age:").append(document.getInteger("age")).append("\n");
            }
            return String.valueOf(answer);
        }catch (Exception e){
            return "查找失败,出现异常" + e;
        }
    }
}
