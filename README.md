# Lob Java Bindings

[![Build Status](https://secure.travis-ci.org/lob/lob-java.png)](https://travis-ci.org/lob/lob-java)
[![Coverage Status](https://coveralls.io/repos/javadev/lob-java/badge.png?branch=master)](https://coveralls.io/r/javadev/lob-java)

You can sign up for a Lob account at https://www.lob.com.

Requirements
============

Java 1.5 and later.

Installation
============

### Maven users

Add this dependency to your project's POM:

    <dependency>
      <groupId>com.lob</groupId>
      <artifactId>lob-java</artifactId>
      <version>1.1</version>
    </dependency>

### Others

You'll need to manually install the following JARs:

* The Lob JAR lob-java-1.1.jar
* [Google Gson](http://code.google.com/p/google-gson/) from <http://google-gson.googlecode.com/files/google-gson-2.2.2-release.zip>.
* [Apache Commons Codec](http://commons.apache.org/proper/commons-codec/index.html) from <http://apache.claz.org//commons/codec/binaries/commons-codec-1.8-bin.zip>.
* [Apache Commons Logging](http://commons.apache.org/proper/commons-logging/) from <http://www.motorlogy.com/apache//commons/logging/binaries/commons-logging-1.1.3-bin.zip>.
* [Apache HttpClient](http://hc.apache.org/httpcomponents-client-4.3.x/index.html) from <http://mirrors.gigenet.com/apache//httpcomponents/httpclient/binary/httpcomponents-client-4.3.2-bin.zip>.
* [Apache HttpCore](http://hc.apache.org/httpcomponents-core-ga/) from <http://mirrors.sonic.net/apache//httpcomponents/httpcore/binary/httpcomponents-core-4.3.1-bin.zip>.
* [Apache HttpClient Mime](http://hc.apache.org/httpcomponents-client-ga/) from <http://repo1.maven.org/maven2/org/apache/httpcomponents/httpmime/4.3.2/httpmime-4.3.2.jar>.

Usage
=====

LobExample.java

	import java.util.HashMap;
	import java.util.Map;

	import com.lob.Lob;
	import com.lob.exception.LobException;
	import com.lob.model.Job;
	import com.lob.model.JobCollection;

	public class LobExample {

		public static void main(String[] args) {
			Lob.apiKey = "test_0dc8d51e0acffcb1880e0f19c79b2f5b0cc:";
			String id = "job_0e3eff58cb59c935";
			try {
	 
				Job j1 = Job.retrieve(id, Lob.apiKey);
				System.out.println(j1);           
		   
				Map<String, java.lang.Object> ObjectMap = new HashMap<String, java.lang.Object>();
				ObjectMap.put("name", "Michigan fan letter");
				ObjectMap.put("to", "adr_43769b47aed248c2");
				ObjectMap.put("from", "adr_7f9ece71fbca3796");
				ObjectMap.put("object1", "obj_7ca5f80b42b6dfca");
				ObjectMap.put("object2", "obj_12128d3aad2aa98f");
				ObjectMap.put("object3", "obj_4241a46e01b4f892");       
						
				Job j2 = Job.create(ObjectMap, Lob.apiKey);
				System.out.println(j2);
				
				Map<String, java.lang.Object> listParams = new HashMap<String, java.lang.Object>();
				listParams.put("count", 2);
				listParams.put("offset", 3);
				JobCollection ac = Job.all(listParams, Lob.apiKey);
				System.out.println(ac);
				
			} catch (LobException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}


See Example folder for more examples.
