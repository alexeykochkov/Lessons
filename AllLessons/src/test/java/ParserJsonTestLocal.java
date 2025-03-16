import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ParserJsonTestLocal {

    @DisplayName("Метод GET, хэдэры по тексту не проверяем")
    @Test
    public void getTest() throws IOException {
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Postman.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        Assert.assertNotNull(rootElement);

        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray items = rootObject.get("item").getAsJsonArray();
        Assert.assertNotNull(items);

        /**Ищем объект с именем "Request Methods"*/
        JsonObject requestMethodsItem = null;
        for (JsonElement item : items) {
            JsonObject obj = item.getAsJsonObject();
            if (obj.get("name").getAsString().equals("Request Methods")) {
                requestMethodsItem = obj;
                break;
            }
        }

        if (requestMethodsItem == null) {
            throw new RuntimeException("Не удалось найти объект 'Request Methods'");
        }

        /**Извлекаем массив "item" из объекта "Request Methods"*/
        JsonArray requestItems = requestMethodsItem.get("item").getAsJsonArray();

        /**Обрабатываем только первый запрос*/
        if (!requestItems.isEmpty()) {
            JsonObject firstRequest = requestItems.get(0).getAsJsonObject();

            /**Проверяем, что это GET*/
            JsonObject request = firstRequest.get("request").getAsJsonObject();
            String method = request.get("method").getAsString();
            if (method.equalsIgnoreCase("GET")) {
                /**Проверяем наличие поля "response"*/
                if (firstRequest.has("response")) {
                    JsonArray responses = firstRequest.get("response").getAsJsonArray();

                    /**Берем только первый ответ*/
                    JsonObject responseObject = responses.get(0).getAsJsonObject();

                    String status = responseObject.get("status").getAsString();
                    System.out.println("Status: " + status);
                    Assert.assertEquals(status, "OK");

                    int code = responseObject.get("code").getAsInt();
                    System.out.println("Code: " + code);
                    Assert.assertEquals(code, 200);

                    JsonArray headers = responseObject.get("header").getAsJsonArray();
                    System.out.println("Header Count: " + headers.size());
                    Assert.assertTrue(headers.size() > 0);

                    JsonArray cookies = responseObject.get("cookie").getAsJsonArray();
                    System.out.println("Cookie Count: " + cookies.size());
                    Assert.assertEquals(cookies.size(), 0);  // Утверждение, что куки отсутствуют

                    /**Вот Body*/
                    String body = responseObject.get("body").getAsString();
                    System.out.println("Body: " + body);

                    /**Парсим строку body как JSON-объект*/
                    JsonObject bodyObject = parser.parse(body).getAsJsonObject();

                    /**Проверяем наличие поля "args"*/
                    if (bodyObject.has("args")) {
                        JsonObject argsObject = bodyObject.get("args").getAsJsonObject();

                        /**Проверяем значения в "args"*/
                        String foo1Value = argsObject.get("foo1").getAsString();
                        System.out.println("foo1: " + foo1Value);
                        Assert.assertEquals(foo1Value, "bar1");  // Утверждение для foo1

                        String foo2Value = argsObject.get("foo2").getAsString();
                        System.out.println("foo2: " + foo2Value);
                        Assert.assertEquals(foo2Value, "bar2");  // Утверждение для foo2
                    } else {
                        Assert.fail("Поле 'args' отсутствует в теле ответа");
                    }
                }
            } else {
                System.out.println("Этот запрос не является GET-запросом.");
            }
        }
    }
}