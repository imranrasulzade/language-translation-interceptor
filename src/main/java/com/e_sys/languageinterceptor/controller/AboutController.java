package com.e_sys.languageinterceptor.controller;

import com.e_sys.languageinterceptor.dto.AboutDto;
import com.e_sys.languageinterceptor.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping("{id}")
    public AboutDto about(@PathVariable Long id) {
        return aboutService.getByID(id);
    }






//    @GetMapping("json")
//    public String aboutJson() {
//        String jsonString = aboutService.getByID(1L).toString();
////        String jsonString = "{\n" +
////                "    \"id\": 1,\n" +
////                "    \"header\": {\n" +
////                "        \"text\": \"salam\"\n" +
////                "    },\n" +
////                "    \"data\": {\n" +
////                "        \"content\": {\n" +
////                "            \"text\": \"salam\"\n" +
////                "        },\n" +
////                "        \"nested\": [\n" +
////                "            {\n" +
////                "                \"section\": {\n" +
////                "                    \"text\": \"salam\"\n" +
////                "                }\n" +
////                "            }\n" +
////                "        ]\n" +
////                "    }\n" +
////                "}";
//        System.out.println(jsonString.toString());
//        //AboutDto(id=1, title=TranslationDto(text=azerbayc), content=TranslationDto(text=azerbaycan))
//        JSONObject transformedJson = transformJson(new JSONObject(jsonString));
//        System.out.println(transformedJson.toString(4));
//        return transformedJson.toString();
//    }
//
//    public static JSONObject transformJson(JSONObject jsonObject) {
//        jsonObject.keySet().forEach(key -> {
//            Object value = jsonObject.get(key);
//            if (value instanceof JSONObject) {
//                JSONObject childObject = (JSONObject) value;
//                if (childObject.has("text")) {
//                    String textValue = childObject.getString("text");
//                    jsonObject.put(key, textValue);
//                } else {
//                    transformJson(childObject);
//                }
//            } else if (value instanceof JSONArray) {
//                JSONArray array = (JSONArray) value;
//                for (int i = 0; i < array.length(); i++) {
//                    Object arrayElement = array.get(i);
//                    if (arrayElement instanceof JSONObject) {
//                        transformJson((JSONObject) arrayElement);
//                    }
//                }
//            }
//        });
//        return jsonObject;
//    }
}
