<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/banggiaxe">
    <html lang="vi">
      <head>
        <meta charset="UTF-8"/>
        <title>Bảng giá xe</title>
        <style>
          body { font-family: "Times New Roman", serif; font-size: 20px; margin: 0; background: white; }
          main { max-width: 850px; margin: 25px auto; padding: 0 20px 30px; }
          h1 { text-align: center; font-size: 32px; margin: 0 0 8px; }
          section { margin-bottom: 30px; }
          .hang { display: flex; align-items: center; gap: 12px; font-size: 24px; margin-bottom: 4px; }
          .logo { width: 90px; height: 70px; object-fit: contain; }
          table { border-collapse: collapse; width: 100%; table-layout: fixed; }
          th, td { border: 1px solid #222; padding: 6px 10px; }
          th { background: #8fcf2f; font-size: 22px; }
          th:nth-child(1) { width: 9%; }
          th:nth-child(2) { width: 22%; }
          th:nth-child(3) { width: 22%; }
          th:nth-child(4) { width: 29%; }
          th:nth-child(5) { width: 18%; }
          td:nth-child(1) { text-align: center; }
          td:nth-child(5) { text-align: right; }
        </style>
      </head>
      <body>
        <main>
          <h1>BẢNG GIÁ XE</h1>
          <xsl:for-each select="hangxe">
            <section>
              <div class="hang">
                <span>Hãng xe: <xsl:value-of select="@ten"/></span>
                <img class="logo" alt="{@ten}">
                  <xsl:attribute name="src">
                    <xsl:choose>
                      <xsl:when test="@ten = 'Toyota'">T.png</xsl:when>
                      <xsl:when test="@ten = 'Honda'">H.png</xsl:when>
                      <xsl:when test="@ten = 'BMW'">B.png</xsl:when>
                    </xsl:choose>
                  </xsl:attribute>
                </img>
              </div>
              <table>
                <thead>
                  <tr>
                    <th>STT</th>
                    <th>Dòng xe</th>
                    <th>Phiên bản</th>
                    <th>Động cơ</th>
                    <th>Giá (triệu)</th>
                  </tr>
                </thead>
                <tbody>
                  <xsl:for-each select="dongxe">
                    <tr>
                      <td><xsl:value-of select="position()"/></td>
                      <td><xsl:value-of select="@ten"/></td>
                      <td><xsl:value-of select="phienban"/></td>
                      <td><xsl:value-of select="dongco"/></td>
                      <td><xsl:value-of select="gia"/></td>
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
