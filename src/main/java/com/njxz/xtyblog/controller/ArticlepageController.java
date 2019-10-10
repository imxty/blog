package com.njxz.xtyblog.controller;

import com.njxz.xtyblog.model.BackMes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
* @program: ArticlepageController.java
*
* @author: xty
*
* @create: 2019/10/8/008
**/
@RestController
public class ArticlepageController {

    @PostMapping("/saveArticle")
    public BackMes savaArticle(String article, HttpServletRequest request)
    {
        BackMes backMes = new BackMes();
        backMes.setCode(404);
        backMes.setDate("失败");
        FileWriter writer = null;

        String name = article.substring(2,5);
        String fullFilePath="D:\\xtyblogsave\\xty.txt";
        System.out.println(fullFilePath);
        try {
            writer = new FileWriter(fullFilePath);
            writer.write(article);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return backMes;
            }
        }
        backMes.setCode(200);
        backMes.setDate("yes");
        return backMes;
    }

    @GetMapping("/getArticle")
    public BackMes getArticle() throws IOException {
        BackMes backMes = new BackMes();
        String fullFilePath="D:\\xtyblogsave\\xty.txt";

        File file = new File(fullFilePath);

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        String mes = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            mes = mes.concat(line+"\n");
        }
        fis.close();
        backMes.setCode(200);
        backMes.setDate(mes);
        return backMes;
    }

}
