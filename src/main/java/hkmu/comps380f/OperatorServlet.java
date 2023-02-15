package hkmu.comps380f;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(
        name = "operatorServlet",
        value = "/operator"
)
public class OperatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String> dinnerMap = new ConcurrentHashMap<>();
        dinnerMap.put("Chinese", "Green River");
        dinnerMap.put("Japanese", "Sushi Express");
        dinnerMap.put("Hongkong", "Australia Dairy");
        request.setAttribute("dinnerMap", dinnerMap);

        String[] dinnerTypes = {"Chinese", "Japanese", "Hongkong"};
        request.setAttribute("DinnerType", dinnerTypes);
        request.getRequestDispatcher("/WEB-INF/jsp/operator.jsp")
                .forward(request, response);
    }
}
