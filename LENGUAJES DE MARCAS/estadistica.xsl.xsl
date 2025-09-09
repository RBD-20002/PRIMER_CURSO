<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output encoding="UTF-8" method="xml"/>
    <xsl:template match="/">
        <xsl:element name="alumnos">
            <xsl:attribute name="universidad" select="/universidad/nombre"/>
            <xsl:attribute name="numTitulos" select="count(//carrera[@id])"/>
            <xsl:attribute name="numCreditos" select="sum(//creditos)"/>
            <xsl:attribute name="numAlumnos" select="count(//alumno)"/>
            <xsl:apply-templates select="//alumno"/>
        </xsl:element>
    </xsl:template>
    <xsl:template match="alumno">
        <xsl:element name="alumno">
            <xsl:attribute name="codigoAlumno">
                <xsl:value-of select="@id" />
            </xsl:attribute>
            <xsl:attribute name="codigoGrado">
                <xsl:value-of select="//carrera/@codigo" />
            </xsl:attribute>
            <xsl:attribute name="numeroAsignaturas">
                <xsl:value-of select="count(//asignatura)" /> 
            </xsl:attribute>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>