<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>Cliente: <xsl:value-of select="venda/cliente/@cod"/></title>
      </head>
      <body>
        <p>Cliente: <xsl:value-of select="venda/cliente/@cod"/></p>
        <p>Número de produtos: <xsl:value-of select="count(//produto)"/></p>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
