package hkmu.comps380f;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "GuestBook", value = "/GuestBook")
public class GuestBook extends HttpServlet {
    @Override
    public void init() throws ServletException {
        List<GuestBookEntry> entries = new CopyOnWriteArrayList<>();
        this.getServletContext().setAttribute("entries", entries);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/GuestBook.jsp")
                .forward(request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
