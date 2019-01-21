import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account"); // 从 req 中获取名为 account 的参数的值
        String password = req.getParameter("password"); // 从 req 中获取名为 password 的参数的值
        System.out.println("account:" + account + "\npassword:" + password); // 打印出来看一看

        String result = "";
        if ("abc".equals(account)
                && "123".equals(password)) { // 模拟登陆账号、密码验证
            result = "Login Success!";
        } else {
            result = "Login False!";
        }
        /* 这里我们只是模拟了一个最简单的业务逻辑，当然，你的实际业务可以相当复杂 */

        resp.setContentType("text/html;charset=utf-8"); // 设置响应报文的编码格式
        PrintWriter pw = resp.getWriter(); // 获取 response 的输出流
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        pw.println(user.toString()); // 通过输出流把业务逻辑的结果输出
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        doGet(req, resp);
    }
}
