/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-12 11:55:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

public final class VerifyCode_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {



/*
字体相关配置
*/
//可选字符列表
char[] chars = "2345678ABCDEFGHJKLMPQRSTUVWXYabcdefhkmnqrstuvwx"
.toCharArray();
//可选字体
String[] fontNames = new String[] { "Courier", "Arial",
        "Verdana", "Georgia", "Times", "Tahoma" };
//可选字体
int[] fontStyle = new int[] { Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC };
//宽、高、生成字符个数、干扰线数量
int width = 100;
int height = 30;
int charCnt = 4;
int disturbLineNum = 10;

//随机角度
private double getRandomArch() {
    return ((int) (Math.random() * 1000) % 2 == 0 ? -1 : 1) * Math.random();
}
//随机颜色
private Color getRandomColor() {
    int r = (int) (Math.random() * 10000) % 200;
    int g = (int) (Math.random() * 10000) % 200;
    int b = (int) (Math.random() * 10000) % 200;
    return new Color(r, g, b);
}
//随机字体
private String getRandomFontName() {
    int pos = (int) (Math.random() * 10000) % (fontNames.length);
    return fontNames[pos];
}
//随机字形
private int getRandomStyle() {
    int pos = (int) (Math.random() * 10000) % (fontStyle.length);
    return fontStyle[pos];
}
//随机字体大小
private int getRandomSize() {
    int max = (int) (this.height * 0.9);
    int min = (int) (this.height * 0.6);
    return (int) (Math.random() * 10000) % (max - min + 1) + min;
}
//随机字符
private char[] generateCode() {
    char[] ret = new char[charCnt];
    for (int i = 0; i < charCnt; i++) {
        int letterPos = (int) (Math.random() * 10000) % (chars.length);
        ret[i] = chars[letterPos];
    }
    return ret;
}
//生成字符图片
private BufferedImage generateBuffImg(char c) {
    String tmp = Character.toString(c);
    Color forecolor = getRandomColor();
    Color backcolor = new Color(255, 255, 255, 0);
    String fontName = getRandomFontName();
    int fontStyle = getRandomStyle();
    int fontSize = getRandomSize();
    int strX = (this.height - fontSize) / 2;
    int strY = (this.height - fontSize) / 2 + fontSize;
    double arch = getRandomArch();

    BufferedImage ret = new BufferedImage(this.height, this.height,
            BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = ret.createGraphics();
    g.setColor(backcolor);
    g.fillRect(0, 0, this.height, this.height);

    g.setColor(forecolor);
    g.setFont(new Font(fontName, fontStyle, fontSize));
    g.rotate(arch, this.height / 2, this.height / 2);
    g.drawString(tmp, strX, strY);

    g.dispose();
    return ret;
}

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("image/jpeg;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

response.reset();
//设置页面不缓存
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);


/*
* 绘制验证码图片
*/
BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
Graphics2D g = bi.createGraphics();
g.setColor(new Color(245, 245, 245));
g.fillRect(0, 0, width, height);

/*
* 绘制干扰线
*/
for (int i = 0; i < disturbLineNum; i++) {
    g.setColor(getRandomColor());
    int x = (int) (Math.random() * 10000) % (width + 1) + 1;
    int x1 = (int) (Math.random() * 10000) % (width + 1) + 1;
    int y = (int) (Math.random() * 10000) % (height + 1) + 1;
    int y1 = (int) (Math.random() * 10000) % (height + 1) + 1;
    g.drawLine(x, y, x1, y1);
}


//绘制生成的字符
BufferedImage[] bis = new BufferedImage[charCnt];
char[] codes = generateCode();
for (int i = 0; i < charCnt; i++) {
    bis[i] = generateBuffImg(codes[i]);
    g.drawImage(bis[i], null, (int) (this.height * 0.7) * i, 0);
}


//将认证码存入SESSION
session.setAttribute("rand",new String(codes));

//图象生效
g.dispose();


//输出图象到页面
ImageIO.write(bi, "gif", response.getOutputStream());
//清空流，返回新out对象
out.clear();
out = pageContext.pushBody();


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
