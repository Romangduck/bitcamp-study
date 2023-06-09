// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json.gson;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Exam0114 {
  public static void main(String[] args) {

    // 1) 객체 준비
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>()
      
    }


  @Override
  public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    String str = dateFormat.format(src);
    System.out.println(str);
    return new JsonPrimitive( new SimpleDateFormat("yyyy-MM-dd"););
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Date.class, new GsonDateFormatAdapter());

    Gson gson = builder.create();

    String jsonStr = gson.toJson(m);

    System.out.println(jsonStr);
  }
}

// JSON 객체 형식 - { 객체 정보 }
// => { "프로퍼티명" : 값, "프로퍼티명": 값, ...}
//
// 값:
// - 문자열 => "값"
// - 숫자 => 값
// - 논리 => true, false
//
// 프로퍼티명은 반드시 문자열로 표현해야 한다.


