package com.codecool.ccforum.api.threads;

import com.codecool.ccforum.application.ServiceRegistry;
import com.codecool.ccforum.domain.entities.Thread;
import com.codecool.ccforum.domain.services.ThreadService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class ListThreadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThreadService svc = ServiceRegistry.getInstance(ThreadService.class);
        List<Thread> threads = svc.listThreads();

        StringBuilder builder = new StringBuilder();

        builder.append("{threads:[");

        for (Thread t : threads) {
            builder.append("{");
            builder.append("id: ").append(t.getId()).append(";");
            builder.append("title: \"").append(t.getTitle()).append("\";");
            builder.append("},");
        }

        builder.append("]}");

        resp.setStatus(200);
        resp.setContentType("image/png");

        BufferedImage img = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(100, 100, 100, 50);
        g.setColor(Color.BLUE);
        g.drawRect(100, 100, 100, 50);
        g.dispose();

        ImageIO.write(img, "png", resp.getOutputStream());

        //resp.getWriter().write("<html><body><button>Clickme</button></body></html>");
    }
}
