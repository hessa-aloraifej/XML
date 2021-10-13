package com.example.xml

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XMLParser {
    private val students = ArrayList<Students>()
    private var text: String? = null

    private var studentName = ""
    private var studentId = 0
    private var studentMarks = 0F

    fun parse(inputStream: InputStream): ArrayList<Students> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType // notify the start or end of tag
            while (eventType != XmlPullParser.END_DOCUMENT) { // if not end of file complete
                val tagName = parser.name // to know the name of parseer
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", ignoreCase = true) -> {
                            studentId = text.toString().toInt()
                        }
                        tagName.equals("name", ignoreCase = true) -> {
                            studentName = text!!.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            studentMarks = text!!.toFloat()
                        }
                        tagName.equals("student", ignoreCase = true) -> {students.add(Students(studentId, studentName,studentMarks))}
                        else -> {}
                    }

                    else -> {
                    }
                }
                eventType = parser.next() // to go next line in file
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return students
    }
}