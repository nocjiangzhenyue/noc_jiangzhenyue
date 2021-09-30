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

//事务 transaction
@Service
public class UserServiceImpl implements UserService{
    MongoCollection<Document> collection = MongoClients.create(URL).getDatabase("test").getCollection("user");

    @Override
    public boolean addUser(User user) {
        // 开启事务
        // 1, 2, 3操作
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
