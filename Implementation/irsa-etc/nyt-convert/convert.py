#!/usr/bin/python
#
# This script's purpose is to convert database of NYT from MS SQL dump file
# to xml data format
#
# First you need to restore database to your running SQL server then change
# connection configuration below and run the script

import pyodbc
import codecs
from xml.sax.saxutils import escape

print("Connecting to db")
conn = pyodbc.connect("""
	DRIVER={SQL Server};
	SERVER=EVERNIGH-5F5A2C;
	DATABASE=nyt2005;
""") # Change that connect string to yours
cursor = conn.cursor()
c = conn.cursor()
c.execute('select Doc_Title title, Doc_Body text from dbo.search_documents')

file = codecs.open('nytimes2005.xml', 'w', encoding='UTF-8')
file.write('<collection>\n')
file.write('<name>New York Times 2005</name>\n')
file.write('<description>description of New York Times 2005</description>\n')
file.write('<comment>comment for New York Times 2005</comment>\n')

count = 0
for row in c:
	if not row.title or not row.text:
		continue
	file.write('<item>\n')
	file.write('	<title>%s</title>\n' % escape(row.title))
	file.write('	<text>\n %s \n</text>\n' % escape(row.text))
	file.write('	<metadata></metadata>\n')
	file.write('</item>\n')

	count += 1
	if count % 100 == 0:		
		print('Processed %s rows...' % count)
file.write('</collection>\n')	