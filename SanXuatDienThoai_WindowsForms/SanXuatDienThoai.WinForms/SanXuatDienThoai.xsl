<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/sanxuatdienthoai">
    <html lang="vi">
      <head>
        <meta charset="UTF-8"/>
        <title>Thị trường sản xuất điện thoại</title>
        <style>
          body { font-family: "Times New Roman", serif; font-size: 21px; margin: 0; background: #fff; }
          main { max-width: 790px; margin: 28px auto; padding: 0 20px 30px; }
          h1 { text-align: center; font-size: 31px; margin: 0 0 8px; }
          section { margin: 0 0 28px; }
          .nam { font-size: 24px; margin: 0 0 3px; }
          table { border-collapse: collapse; width: 100%; table-layout: fixed; }
          th, td { border: 1px solid #222; padding: 5px 10px; }
          th { background: #74b816; font-size: 23px; }
          th:nth-child(1) { width: 10%; }
          th:nth-child(2) { width: 35%; }
          th:nth-child(3) { width: 29%; }
          th:nth-child(4) { width: 26%; }
          td { height: 120px; }
          td:nth-child(1) { text-align: center; }
          td:nth-child(3), td:nth-child(4) { text-align: right; font-size: 23px; }
          .congty { font-size: 22px; }
          .logo { display: block; max-width: 125px; max-height: 74px; object-fit: contain; margin: 10px auto 0; }
        </style>
      </head>
      <body>
        <main>
          <h1>THỊ TRƯỜNG SẢN XUẤT ĐIỆN THOẠI</h1>
          <xsl:for-each select="thoigian">
            <section>
              <div class="nam">Năm: <xsl:value-of select="@nam"/></div>
              <table>
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>Công ty</th>
                    <th>Xuất xưởng</th>
                    <th>Thị phần</th>
                  </tr>
                </thead>
                <tbody>
                  <xsl:for-each select="congty">
                    <tr>
                      <td><xsl:value-of select="position()"/></td>
                      <td class="congty">
                        <xsl:value-of select="@ten"/>
                        <img class="logo" alt="{@ten}">
                          <xsl:attribute name="src">
                            <xsl:choose>
                              <xsl:when test="@ten = 'Samsung'">S.png</xsl:when>
                              <xsl:when test="@ten = 'Apple'">A.png</xsl:when>
                              <xsl:when test="@ten = 'Xiaomi'">X.png</xsl:when>
                            </xsl:choose>
                          </xsl:attribute>
                        </img>
                      </td>
                      <td><xsl:value-of select="xuatxuong"/></td>
                      <td><xsl:value-of select="thiphan"/></td>
                    </tr>
                  </xsl:for-each>
                </tbody>
              </table>
            </section>
          </xsl:for-each>
        </main>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
