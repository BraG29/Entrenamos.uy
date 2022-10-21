package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import logica.controlador.*;

@MultipartConfig
@WebServlet("/api/content")
public class ContentHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ContentHandler() {
        super();
    }

    private void getContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String c = request.getParameter("c"); // c=clase de imagen (usuario, actividad, etc.).
        String cc = null;
        String id = request.getParameter("id");
        String idf = null;
        int cacheAge = Integer.parseInt(ConfigListener.cfg.getProperty("contentCacheTime", "60"));
        long expiry = new Date().getTime() + cacheAge * 1000;

        if (c == null || id == null)
            r404(request, response);

        if (c.equals("usu")) {
            try {
                if (IUC.seleccionarUsuario(id).getImagen() != null)
                    idf = new String(IUC.seleccionarUsuario(id).getImagen());
            } catch (ClassNotFoundException ex) {
                r404(request, response);
                return;
            }
            cc = "users";

        } else if (c.equals("cla")) {
            try {
                idf = IDCC.buscarClase(id).getImgName();
            } catch (ClassNotFoundException ex) {
                r404(request, response);
                return;
            }
            cc = "classes";

        } else if (c.equals("act")) {
            boolean fnghfn = false;
            for (String i : IADC.obtenerInstituciones())
                try {
                    idf = IADC.getActDepExt(i, id).getImgName();
                    fnghfn = true;
                } catch (Exception e) {
                }
            if (idf == null && !fnghfn) {
                r404(request, response);
                return;
            }
            cc = "activities";

        } else if (c.equals("cup")) {
            try {
                idf = ICC.seleccionarCuponera(id).getImgName();
            } catch (ClassNotFoundException ex) {
                r404(request, response);
                return;
            }
            cc = "cups";
        }

        if (idf == null || cc == null)
            idf = "default.png";

        if (idf != "default.png") {
            ServletOutputStream stream = response.getOutputStream();
            byte[] i = ICOC.get(c, idf);
            stream.write(i);
            response.setContentType("image/" + idf.split("[.]")[idf.split("[.]").length - 1]);
            response.setContentLength(i.length);
            response.setDateHeader("Expires", expiry);
            response.setHeader("Cache-Control", "max-age=" + cacheAge);
            response.flushBuffer();

        } else {
            try {
                PrintWriter stream = response.getWriter();
                int s = 0;
                try (FileInputStream inputStream = new FileInputStream(
                        request.getServletContext().getRealPath("/assets/images/default/" + c + "_default.png"))) {
                    for (int ch; (ch = inputStream.read()) != -1;) {
                        stream.write(ch);
                        s++;
                    }
                    response.setContentType("image/" + idf.split("[.]")[idf.split("[.]").length - 1]);
                    response.setContentLength(s);
                    response.setDateHeader("Expires", expiry);
                    response.setHeader("Cache-Control", "max-age=" + cacheAge);
                    response.flushBuffer();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void postContent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getAttribute("attribute_asset_transfer") != null) {
            Part filePart = (Part) request.getAttribute("attribute_asset_transfer");
            InputStream fileContent = filePart.getInputStream();
            ICOC.post((String) request.getAttribute("type"), (String) request.getAttribute("id"),
                    IOUtils.toByteArray(fileContent));

        } else if (request.getPart("img") != null && request.getPart("img").getSize() > 0) {
            Part filePart = request.getPart("img");
            InputStream fileContent = filePart.getInputStream();
            ICOC.post(request.getParameter("type"), request.getParameter("id"), IOUtils.toByteArray(fileContent));
        }
    }

    private void r404(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("pages/404.jsp").forward(request, response);
            return;
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getContent(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        postContent(request, response);
    }
}