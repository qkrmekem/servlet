package hello.servlet.basic.response;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Content-Type: application/json
        resp.setContentType("json");
        resp.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("park");
        helloData.setAge(20);

        //{"username":"park","age":20}
        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);

    }

}
