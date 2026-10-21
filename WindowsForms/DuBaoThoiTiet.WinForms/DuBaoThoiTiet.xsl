<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>
  <xsl:template match="/dubaothoitiet">
    <html lang="vi">
      <head>
        <meta charset="UTF-8"/>
        <title>Dự báo thời tiết</title>
        <style>
          body { font-family: "Times New Roman", serif; font-size: 20px; }
          main { max-width: 850px; margin: 40px auto; }
          h1 { text-align: center; font-size: 28px; margin-bottom: 4px; }
          section { margin-bottom: 28px; overflow-x: auto; }
          table { border-collapse: collapse; width: 100%; }
          th, td { border: 1px solid black; padding: 4px 8px; }
          th { background: yellowgreen; white-space: nowrap; }
          td:nth-child(1), td:nth-child(2) { text-align: center; }
          td:nth-child(4), td:nth-child(5) { text-align: right; }
          img { display: block; width: 90px; height: 70px; object-fit: contain; margin: auto; }
        </style>
      </head>
      <body><main>
        <h1>DỰ BÁO THỜI TIẾT</h1>
        <xsl:for-each select="thoitiet">
          <section>
            <div>Ngày: <xsl:value-of select="@ngay"/></div>
            <table>
              <thead><tr>
                <th>STT</th><th>Khu vực</th><th>Kiểu thời tiết</th>
                <th>Nhiệt độ cao nhất</th><th>Nhiệt độ thấp nhất</th>
              </tr></thead>
              <tbody><xsl:for-each select="khuvuc">
                <tr>
                  <td><xsl:value-of select="position()"/></td>
                  <td><xsl:value-of select="@ma"/></td>
                  <td>
                    <xsl:value-of select="kieuthoitiet"/>
                    <img alt="{kieuthoitiet}">
                      <xsl:attribute name="src"><xsl:choose>
                        <xsl:when test="kieuthoitiet = 'Nắng'">1.png</xsl:when>
                        <xsl:when test="kieuthoitiet = 'Mây'">2.png</xsl:when>
                        <xsl:when test="kieuthoitiet = 'Mưa'">3.png</xsl:when>
                      </xsl:choose></xsl:attribute>
                    </img>
                  </td>
                  <td><xsl:value-of select="nhietdocaonhat"/></td>
                  <td><xsl:value-of select="nhietdothapnhat"/></td>
                </tr>
              </xsl:for-each></tbody>
            </table>
          </section>
        </xsl:for-each>
      </main></body>
    </html>
  </xsl:template>
</xsl:stylesheet>
