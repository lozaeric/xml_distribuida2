<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="xml" indent="yes"/>

<xsl:template match="/">
<properties>
	<xsl:for-each select="rentalProperties/property">
		<property>
		<xsl:attribute name="type">
			<xsl:value-of select="type"/>
		</xsl:attribute>
		<xsl:attribute name="rent">
			<xsl:value-of select="price"/>
		</xsl:attribute>
		<id>
			<xsl:value-of select="@id"/>
		</id>
		<address>
			<xsl:attribute name="zipCode">
			<xsl:value-of select="address/zipcode"/>
			</xsl:attribute>
			<streetNo>
			<xsl:value-of select="address/streetNo"/>
			</streetNo>
			<street>
			<xsl:value-of select="address/street"/>
			</street>
			<state>
			<xsl:value-of select="address/state"/>
			</state>
		</address>
		<numberOfBedrooms>
			<xsl:value-of select="numberOfBedrooms"/>
		</numberOfBedrooms>
		<numberOfBathrooms>
			<xsl:value-of select="numberOfBathrooms"/>
		</numberOfBathrooms>
		<garage>
			<xsl:value-of select="garage"/>
		</garage>
		</property>
	</xsl:for-each>
</properties>
</xsl:template>

</xsl:stylesheet>
