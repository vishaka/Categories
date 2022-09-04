package Utilities;

import POJO.Category;
import com.google.gson.Gson;

public class GenerateRequestBody {
    Category category;

    public String generateReqBody(String id,String name){
        category=new Category();
        category.setId(id);
        category.setName(name);
        Gson requestBody = new Gson();
        String body = requestBody.toJson(category);
        return body;
    }
}
