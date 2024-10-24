package by.itclass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()){
            var name = req.getParameter("userName");
            var age = req.getParameter("userAge");
            var gender = req.getParameter("gender");
            var country = req.getParameter("country");
            var courses = req.getParameterValues("course");
            writer.append("<p> Name: " + name + "</p>")
                    .append("<p> Age: " + age + "</p>")
                    .append("<p> Gender: " + gender + "</p>")
                    .append("<p> Country: " + country + "</p>")
                    .append("<p> Courses</p>")
                    .append("<ol>");
            Arrays.stream(courses).forEach(it -> writer.append("<li>" + it + "</li>"));
            writer.append("</ol>");
            writer.flush();
        }
    }
}
